package score;

import static org.optaplanner.core.api.score.stream.ConstraintCollectors.sum;
import static org.optaplanner.core.api.score.stream.Joiners.equal;
import static org.optaplanner.core.api.score.stream.Joiners.filtering;
import static org.optaplanner.core.api.score.stream.Joiners.greaterThan;
import static org.optaplanner.core.api.score.stream.Joiners.lessThan;
import static org.optaplanner.core.api.score.stream.Joiners.lessThanOrEqual;

import java.util.function.Function;

import optaplanner.*;
import optaplanner.solver.EpreuveConflit;
import org.optaplanner.core.api.score.stream.Constraint;
import org.optaplanner.core.api.score.stream.ConstraintFactory;
import org.optaplanner.core.api.score.stream.ConstraintProvider;
import salle.Salle;

// TODO The Contrainte is unusually slow. For more information, see: https://issues.redhat.com/browse/PLANNER-2011
public class Contrainte implements ConstraintProvider {

    @Override
    public Constraint[] defineConstraints(ConstraintFactory constraintFactory) {
        return new Constraint[]{
                // Hard constraints
                conflitExamenDansLaMemePeriode(constraintFactory),
                periodeDureeTropCourte(constraintFactory),
                capaciteSalleTropPetite(constraintFactory),
                periodePenaliteExamenCoincidencePenalite(constraintFactory),
                periodePenaliteExclusionPenalite(constraintFactory),
                periodePenaliteAfterPenalite(constraintFactory),
                sallePenaliteExclusivePenalite(constraintFactory),

                // Soft constraints
                twoExamensInARow(constraintFactory),
                twoExamensInAJour(constraintFactory),
                periodeSpread(constraintFactory),
                mixedDurees(constraintFactory),
                frontLoad(constraintFactory),
                periodePenalite(constraintFactory),
                sallePenalite(constraintFactory)
        };
    }

    protected Constraint conflitExamenDansLaMemePeriode(ConstraintFactory constraintFactory) {
        return constraintFactory.from(EpreuveConflit.class)
                .join(Examen.class,
                        equal(EpreuveConflit::getLeftEpreuve, Examen::getEpreuve),
                        filtering((epreuveConflit, leftExam) -> leftExam.getPeriode() != null))
                .ifExists(Examen.class,
                        equal((epreuveConflit, leftExam) -> epreuveConflit.getRightEpreuve(), Examen::getEpreuve),
                        equal((epreuveConflit, leftExam) -> leftExam.getPeriode(), Examen::getPeriode))
                .penalizeConfigurable("conflitExamenDansLaMemePeriode",
                        (epreuveConflit, leftExam) -> epreuveConflit.getEtudiantSize());
    }

    protected Constraint periodeDureeTropCourte(ConstraintFactory constraintFactory) {
        return constraintFactory.from(Examen.class)
                .filter(exam -> exam.getEpreuveDuree() > exam.getPeriodeDuree())
                .penalizeConfigurable("periodeDureeTropCourte", Examen::getEpreuveEtudiantSize);
    }

    protected Constraint capaciteSalleTropPetite(ConstraintFactory constraintFactory) {
        return constraintFactory.from(Examen.class)
                //  Periode is genuine planning variable on ExamenEnCours, shadow var on FollowingExam, nothing on Exam.
                .filter(exam -> exam.getPeriode() != null)
                .groupBy(Examen::getSalle, Examen::getPeriode, sum(Examen::getEpreuveEtudiantSize))
                .filter((salle, periode, totalEtudiantSize) -> totalEtudiantSize > salle.getCapacite())
                .penalizeConfigurable("capaciteSalleTropPetite",
                        (salle, periode, totalEtudiantSize) -> totalEtudiantSize - salle.getCapacite());
    }

    protected Constraint periodePenaliteExamenCoincidencePenalite(ConstraintFactory constraintFactory) {
        return constraintFactory.from(PeriodePenalite.class)
                .filter(periodePenalite -> periodePenalite.getPeriodePenaliteType() == PeriodePenaliteType.EXAM_COINCIDENCE)
                .join(Examen.class,
                        equal(PeriodePenalite::getLeftEpreuve, Examen::getPeriode),
                        filtering((periodePenalite, leftExam) -> leftExam.getPeriode() != null))
                .join(Examen.class,
                        equal((periodePenalite, leftExam) -> periodePenalite.getRightEpreuve(), Examen::getPeriode),
                        filtering((periodePenalite, leftExam, rightExam) -> rightExam.getPeriode() != null),
                        filtering((periodePenalite, leftExam, rightExam) -> leftExam.getPeriode() != rightExam.getPeriode()))
                .penalizeConfigurable("periodePenaliteExamenCoincidencePenalite",
                        (periodePenalite, leftExam, rightExam) -> leftExam.getEpreuve().getEtudiantSize()
                                + rightExam.getEpreuve().getEtudiantSize());
    }

    protected Constraint periodePenaliteExclusionPenalite(ConstraintFactory constraintFactory) {
        return constraintFactory.from(PeriodePenalite.class)
                .filter(periodePenalite -> periodePenalite.getPeriodePenaliteType() == PeriodePenaliteType.EXCLUSION)
                .join(Examen.class,
                        equal(PeriodePenalite::getLeftEpreuve, Examen::getEpreuve),
                        filtering((periodePenalite, leftExam) -> leftExam.getPeriode() != null))
                .join(Examen.class,
                        equal((periodePenalite, leftExam) -> periodePenalite.getRightEpreuve(), Examen::getPeriode),
                        equal((periodePenalite, leftExam) -> leftExam.getPeriode(), Examen::getPeriode))
                .penalizeConfigurable("periodePenaliteExclusionPenalite",
                        (periodePenalite, leftExam, rightExam) -> leftExam.getEpreuve().getEtudiantSize()
                                + rightExam.getEpreuve().getEtudiantSize());
    }

    protected Constraint periodePenaliteAfterPenalite(ConstraintFactory constraintFactory) {
        return constraintFactory.from(PeriodePenalite.class)
                .filter(periodePenalite -> periodePenalite.getPeriodePenaliteType() == PeriodePenaliteType.AFTER)
                .join(Examen.class,
                        equal(PeriodePenalite::getLeftEpreuve, Examen::getPeriode),
                        filtering((periodePenalite, leftExam) -> leftExam.getPeriode() != null))
                .join(Examen.class,
                        equal((periodePenalite, leftExam) -> periodePenalite.getRightEpreuve(), Examen::getEpreuve),
                        lessThanOrEqual((periodePenalite, leftExam) -> leftExam.getPeriodeIndex(), Examen::getPeriodeIndex))
                .penalizeConfigurable("periodePenaliteAfterPenalite",
                        (periodePenalite, leftExam, rightExam) -> leftExam.getEpreuve().getEtudiantSize()
                                + rightExam.getEpreuve().getEtudiantSize());
    }

    protected Constraint sallePenaliteExclusivePenalite(ConstraintFactory constraintFactory) {
        return constraintFactory.from(SallePenalite.class)
                .filter(sallePenalite -> sallePenalite.getSallePenaliteType() == SallePenaliteType.ROOM_EXCLUSIVE)
                .join(Examen.class,
                        equal(SallePenalite::getEpreuve, Examen::getEpreuve),
                        filtering((sallePenalite, leftExam) -> leftExam.getPeriode() != null && leftExam.getSalle() != null))
                .join(Examen.class,
                        equal((sallePenalite, leftExam) -> leftExam.getSalle(), Examen::getSalle),
                        equal((sallePenalite, leftExam) -> leftExam.getPeriode(), Examen::getPeriode),
                        filtering((sallePenalite, leftExam, rightExam) -> leftExam.getEpreuve() != rightExam.getEpreuve()))
                .penalizeConfigurable("sallePenaliteExclusivePenalite",
                        (periodePenalite, leftExam, rightExam) -> leftExam.getEpreuve().getEtudiantSize()
                                + rightExam.getEpreuve().getEtudiantSize());
    }

    protected Constraint twoExamensInARow(ConstraintFactory constraintFactory) {
        return constraintFactory.from(EpreuveConflit.class)
                .join(Examen.class,
                        equal(EpreuveConflit::getLeftEpreuve, Examen::getEpreuve),
                        filtering((epreuveConflit, leftExam) -> leftExam.getPeriode() != null))
                .join(Examen.class,
                        equal((epreuveConflit, leftExam) -> epreuveConflit.getRightEpreuve(), Examen::getEpreuve),
                        equal((epreuveConflit, leftExam) -> leftExam.getJourIndex(), Examen::getJourIndex),
                        filtering((epreuveConflit, leftExam,
                                   rightExam) -> getPeriodeIndexDifferenceBetweenExams(leftExam, rightExam) == 1))
                .penalizeConfigurable("twoExamensInARow", (epreuveConflit, leftExam, rightExam) -> epreuveConflit.getEtudiantSize());
    }

    protected Constraint twoExamensInAJour(ConstraintFactory constraintFactory) {
        return constraintFactory.from(EpreuveConflit.class)
                .join(Examen.class,
                        equal(EpreuveConflit::getLeftEpreuve, Examen::getEpreuve),
                        filtering((epreuveConflit, leftExam) -> leftExam.getPeriode() != null))
                .join(Examen.class,
                        equal((epreuveConflit, leftExam) -> epreuveConflit.getRightEpreuve(), Examen::getEpreuve),
                        equal((epreuveConflit, leftExam) -> leftExam.getJourIndex(), Examen::getJourIndex),
                        // Find exams in a jour, but not being held right after each other. That case is handled in the twoExamsInARow constraint.
                        filtering((epreuveConflit, leftExam,
                                   rightExam) -> getPeriodeIndexDifferenceBetweenExams(leftExam, rightExam) > 1))
                .penalizeConfigurable("twoExamensInAJour", (epreuveConflit, leftExam, rightExam) -> epreuveConflit.getEtudiantSize());
    }

    protected Constraint periodeSpread(ConstraintFactory constraintFactory) {
        return constraintFactory.from(CalendrierContraintes.class)
                .join(EpreuveConflit.class)
                .join(Examen.class,
                        equal((config, epreuveConflit) -> epreuveConflit.getLeftEpreuve(), Examen::getEpreuve),
                        filtering((config, epreuveConflit, leftExam) -> leftExam.getPeriode() != null))
                .join(Examen.class,
                        equal((config, epreuveConflit, leftExam) -> epreuveConflit.getRightEpreuve(), Examen::getEpreuve),
                        filtering((config, epreuveConflit, leftExam, rightExam) -> rightExam.getPeriode() != null),
                        filtering((config, epreuveConflit, leftExam,
                                   rightExam) -> getPeriodeIndexDifferenceBetweenExams(leftExam,
                                rightExam) < (config.getPeriodeSpreadLength() + 1)))
                .penalizeConfigurable("periodeSpread",
                        (config, epreuveConflit, leftExam, rightExam) -> epreuveConflit.getEtudiantSize());
    }

    protected Constraint mixedDurees(ConstraintFactory constraintFactory) {
        // 4 mixed durees of 100, 150, 200 and 200 should only result in 2 penalties (for 100&150 and 100&200).
        return constraintFactory.from(Examen.class)
                //  Periode is genuine planning variable on ExamenEnCours, shadow var on FollowingExam, nothing on Exam.
                .filter(leftExam -> leftExam.getPeriode() != null)
                .ifNotExistsOther(Examen.class,
                        equal(Examen::getPeriode),
                        equal(Examen::getSalle),
                        greaterThan(Examen::getId))
                .join(Examen.class,
                        equal(Examen::getPeriode),
                        equal(Examen::getSalle),
                        lessThan(Examen::getId),
                        filtering((leftExam, rightExam) -> leftExam.getEpreuveDuree() != rightExam.getEpreuveDuree()))
                .ifNotExists(Examen.class,
                        equal((leftExam, rightExam) -> leftExam.getPeriode(), Examen::getPeriode),
                        equal((leftExam, rightExam) -> leftExam.getSalle(), Examen::getSalle),
                        equal((leftExam, rightExam) -> rightExam.getEpreuveDuree(), Examen::getEpreuveDuree),
                        greaterThan((leftExam, rightExam) -> rightExam.getId(), Examen::getId))
                .penalizeConfigurable("mixedDurees");
    }

    protected Constraint frontLoad(ConstraintFactory constraintFactory) {
        return constraintFactory.from(Examen.class)
                .filter(exam -> exam.isEpreuveFrontLoadLarge() && exam.isPeriodeFrontLoadLast())
                .penalizeConfigurable("frontLoad");
    }

    protected Constraint periodePenalite(ConstraintFactory constraintFactory) {
        return constraintFactory.from(Periode.class)
                .filter(periode -> periode.getPenalite() != 0)
                .join(Examen.class,
                        equal(Function.identity(), Examen::getPeriode))
                .penalizeConfigurable("periodePenalite", (periode, exam) -> periode.getPenalite());
    }

    protected Constraint sallePenalite(ConstraintFactory constraintFactory) {
        return constraintFactory.from(Salle.class)
                .filter(salle -> salle.getPenalite() != 0)
                .join(Examen.class,
                        equal(Function.identity(), Examen::getSalle))
                .penalizeConfigurable("sallePenalite", (salle, exam) -> salle.getPenalite());
    }

    private int getPeriodeIndexDifferenceBetweenExams(Examen leftExam, Examen rightExam) {
        return Math.abs(leftExam.getPeriodeIndex() - rightExam.getPeriodeIndex());
    }
}
