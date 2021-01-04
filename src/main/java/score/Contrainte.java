package score;

import Examen.Epreuve;
import Examen.UnavailablePeriodPenalty;
import Examen.solver.CourseConflict;
import org.optaplanner.core.api.score.stream.Constraint;
import org.optaplanner.core.api.score.stream.ConstraintFactory;
import org.optaplanner.core.api.score.stream.ConstraintProvider;


import static org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore.*;
import static org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore.ofSoft;
import static org.optaplanner.core.api.score.stream.ConstraintCollectors.countDistinct;
import static org.optaplanner.core.api.score.stream.Joiners.equal;


public class Contrainte implements ConstraintProvider {
    @Override
    public Constraint[] defineConstraints(ConstraintFactory factory) {
        return new Constraint[]{
                conflictingLecturesDifferentCourseInSamePeriod(factory),
                conflictingLecturesSameCourseInSamePeriod(factory),
                roomOccupancy(factory),
                unavailablePeriodPenalty(factory),
                roomCapacity(factory),
                minimumWorkingDays(factory),
                roomStability(factory)
        };
    }

    // ************************************************************************
    // Hard constraints
    // ************************************************************************

    Constraint conflictingLecturesDifferentCourseInSamePeriod(ConstraintFactory factory) {
        return factory.from(CourseConflict.class)
                .join(Epreuve.class,
                        equal(CourseConflict::getLeftCourse, Epreuve::getExamen))
                .join(Epreuve.class,
                        equal((courseConflict, lecture1) -> courseConflict.getRightCourse(), Epreuve::getExamen),
                        equal((courseConflict, lecture1) -> lecture1.getPeriode(), Epreuve::getPeriode))
                .filter(((courseConflict, lecture1, lecture2) -> lecture1 != lecture2))
                .penalize("conflictingLecturesDifferentCourseInSamePeriod", ONE_HARD,
                        (courseConflict, lecture1, lecture2) -> courseConflict.getConflictCount());
    }

    Constraint conflictingLecturesSameCourseInSamePeriod(ConstraintFactory factory) {
        return factory.fromUniquePair(Epreuve.class,
                equal(Epreuve::getPeriode),
                equal(Epreuve::getExamen))
                .penalize("conflictingLecturesSameCourseInSamePeriod", ONE_HARD);
    }

    Constraint roomOccupancy(ConstraintFactory factory) {
        return factory.fromUniquePair(Epreuve.class,
                equal(Epreuve::getSalle),
                equal(Epreuve::getPeriode))
                .penalize("roomOccupancy", ONE_HARD);
    }

    Constraint unavailablePeriodPenalty(ConstraintFactory factory) {
        return factory.from(UnavailablePeriodPenalty.class)
                .join(Epreuve.class,
                        equal(UnavailablePeriodPenalty::getExamen, Epreuve::getExamen),
                        equal(UnavailablePeriodPenalty::getPeriode, Epreuve::getPeriode))
                .penalize("unavailablePeriodPenalty", ofHard(10));
    }

    // ************************************************************************
    // Soft constraints
    // ************************************************************************

    Constraint roomCapacity(ConstraintFactory factory) {
        return factory.from(Epreuve.class)
                .filter(epreuve -> epreuve.getStudentSize() > epreuve.getSalle().getCapacite())
                .penalize("roomCapacity", ofSoft(1),
                        lecture -> lecture.getStudentSize() - lecture.getSalle().getCapacite());
    }

    Constraint minimumWorkingDays(ConstraintFactory factory) {
        return factory.from(Epreuve.class)
                .groupBy(Epreuve::getExamen, countDistinct(Epreuve::getJour))
                .filter((course, dayCount) -> course.getMinWorkingDaySize() > dayCount)
                .penalize("minimumWorkingDays", ofSoft(5),
                        (course, dayCount) -> course.getMinWorkingDaySize() - dayCount);
    }

    Constraint roomStability(ConstraintFactory factory) {
        return factory.from(Epreuve.class)
                .groupBy(Epreuve::getExamen, countDistinct(Epreuve::getSalle))
                .filter((course, roomCount) -> roomCount > 1)
                .penalize("roomStability", ofSoft(1),
                        (course, roomCount) -> roomCount - 1);
    }

}
