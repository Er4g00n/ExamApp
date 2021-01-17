package score;

import java.util.Arrays;

import optaplanner.*;
import optaplanner.solver.EpreuveConflit;
import org.junit.jupiter.api.Test;
import org.optaplanner.test.api.score.stream.ConstraintVerifier;
import utilisateur.Etudiant;

public class ContrainteTest {
    private final ConstraintVerifier<Contrainte, Calendrier> constraintVerifier = ConstraintVerifier
            .build(new Contrainte(), Calendrier.class, Examen.class);

    private final Etudiant etudiant1 = new Etudiant("Tom","Lefrere","tom@hotmail.fr", "21903169", null, (long)1);
    private final Etudiant etudiant2 = new Etudiant("Robenson","Rapha","rob@hotmail.fr", "21903168", null,(long)2);
    private final Etudiant etudiant3 = new Etudiant("Jimmy","SaintOuen","jimmy@hotmail.fr", "21903167", null,(long)3);
    private final Etudiant etudiant4 = new Etudiant("Thomas","Timar","thomas@hotmail.fr", "21903166", null,(long)4);

    @Test
    public void conflictingExamsInSamePeriodeTest() {
        Epreuve epreuve1 = new Epreuve();
        Epreuve epreuve2 = new Epreuve();
        EpreuveConflit conflict = new EpreuveConflit(epreuve1, epreuve2, 2);

        Periode periode = new Periode();

        ExamenEnCours exam1 = new ExamenEnCours()
                .withEpreuve(epreuve1)
                .withPeriode(periode)
                .withSalle(new Salle());
        ExamenEnCours exam2 = new ExamenEnCours()
                .withEpreuve(epreuve2)
                .withPeriode(periode)
                .withSalle(new Salle());

        constraintVerifier.verifyThat(Contrainte::conflictingExamensInSamePeriode)
                .given(conflict, exam1, exam2)
                .penalizesBy(2);
    }

    @Test
    public void periodeDureeTooShortTest() {
        ExamenEnCours exam = new ExamenEnCours()
                .withEpreuve(new Epreuve().withDuree(2).withEtudiantList(Arrays.asList(etudiant1, etudiant2)))
                .withPeriode(new Periode().withDuree(1))
                .withSalle(new Salle());

        constraintVerifier.verifyThat(Contrainte::periodeDureeTooShort)
                .given(exam)
                .penalizesBy(2);
    }

    @Test
    public void salleCapacityTooSmallSingleLargeExamTest() {
        Periode periode = new Periode();
        Salle salle = new Salle().withCapacite(2);

        ExamenEnCours exam = new ExamenEnCours()
                .withEpreuve(new Epreuve().withEtudiantList(Arrays.asList(etudiant1, etudiant2, etudiant3, etudiant4)))
                .withPeriode(periode)
                .withSalle(salle);

        constraintVerifier.verifyThat(Contrainte::salleCapaciteTooSmall)
                .given(periode, exam, salle)
                .penalizesBy(2);
    }

    @Test
    public void salleCapacityTooSmallTwoExamsTest() {
        Periode periode = new Periode();
        Salle salle = new Salle().withCapacite(2);

        ExamenEnCours exam1 = new ExamenEnCours()
                .withEpreuve(new Epreuve().withEtudiantList(Arrays.asList(etudiant1, etudiant2)))
                .withPeriode(periode)
                .withSalle(salle);
        ExamenEnCours exam2 = new ExamenEnCours()
                .withEpreuve(new Epreuve().withEtudiantList(Arrays.asList(etudiant3, etudiant4)))
                .withPeriode(periode)
                .withSalle(salle);

        constraintVerifier.verifyThat(Contrainte::salleCapaciteTooSmall)
                .given(periode, exam1, exam2, salle)
                .penalizesBy(2);
    }

    @Test
    public void periodePenaliteTypeTest() {
        Epreuve epreuve1 = new Epreuve().withEtudiantList(Arrays.asList(etudiant1, etudiant2));
        Epreuve epreuve2 = new Epreuve().withEtudiantList(Arrays.asList(etudiant1, etudiant2));

        PeriodePenalite periodePenalite = new PeriodePenalite(epreuve1, epreuve2, PeriodePenaliteType.EXCLUSION);

        Periode periode = new Periode().withPeriodeIndex(1);

        ExamenEnCours exam1 = new ExamenEnCours()
                .withEpreuve(epreuve1)
                .withPeriode(periode)
                .withSalle(new Salle());
        ExamenEnCours exam2 = new ExamenEnCours()
                .withEpreuve(epreuve2)
                .withPeriode(periode)
                .withSalle(new Salle());

        // EXCLUSION
        constraintVerifier.verifyThat(Contrainte::periodePenaliteExclusion)
                .given(periodePenalite, exam1, exam2)
                .penalizesBy(4);

        // COINCIDENCE
        periodePenalite.setPeriodePenaliteType(PeriodePenaliteType.EXAM_COINCIDENCE);
        exam2.setPeriode(new Periode().withPeriodeIndex(0));

        constraintVerifier.verifyThat(Contrainte::periodePenaliteExamenCoincidence)
                .given(periodePenalite, exam1, exam2)
                .penalizesBy(4);

        // AFTER
        // Exam2 after exam1.
        periodePenalite.setPeriodePenaliteType(PeriodePenaliteType.AFTER);
        exam2.setPeriode(new Periode().withPeriodeIndex(2));

        constraintVerifier.verifyThat(Contrainte::periodePenaliteAfter)
                .given(periodePenalite, exam1, exam2)
                .penalizesBy(4);

        // Exam2 before exam1. Should not trigger the AFTER constraint, since its not symmetrical.
        exam2.setPeriode(new Periode().withPeriodeIndex(0));

        constraintVerifier.verifyThat(Contrainte::periodePenaliteAfter)
                .given(periodePenalite, exam1, exam2)
                .penalizesBy(0);
    }

    @Test
    public void sallePenaliteExclusiveTest() {
        Epreuve epreuve1 = new Epreuve().withEtudiantList(Arrays.asList(etudiant1, etudiant2));
        Epreuve epreuve2 = new Epreuve().withEtudiantList(Arrays.asList(etudiant3, etudiant4));

        SallePenalite penalty = new SallePenalite().withEpreuve(epreuve1).withSallePenaliteType(SallePenaliteType.ROOM_EXCLUSIVE);

        Salle salle = new Salle();
        Periode periode = new Periode();

        ExamenEnCours exam1 = new ExamenEnCours().withPeriode(periode).withSalle(salle).withEpreuve(epreuve1);
        ExamenEnCours exam2 = new ExamenEnCours().withPeriode(periode).withSalle(salle).withEpreuve(epreuve2);

        constraintVerifier.verifyThat(Contrainte::sallePenaliteExclusive)
                .given(penalty, exam1, exam2)
                .penalizesBy(4);
    }

    @Test
    public void twoExamsInARowAndInAJourTest() {
        Epreuve epreuve1 = new Epreuve();
        Epreuve epreuve2 = new Epreuve();
        EpreuveConflit conflict = new EpreuveConflit(epreuve1, epreuve2, 2);

        ExamenEnCours exam1 = new ExamenEnCours()
                .withEpreuve(epreuve1)
                .withPeriode(new Periode().withPeriodeIndex(0).withJourIndex(0))
                .withSalle(new Salle());
        ExamenEnCours exam2 = new ExamenEnCours()
                .withEpreuve(epreuve2)
                .withPeriode(new Periode().withPeriodeIndex(2).withJourIndex(1))
                .withSalle(new Salle());

        // Not in a row nor jour.
        constraintVerifier.verifyThat(Contrainte::twoExamensInARow)
                .given(conflict, exam1, exam2)
                .penalizesBy(0);
        constraintVerifier.verifyThat(Contrainte::twoExamensInAJour)
                .given(conflict, exam1, exam2)
                .penalizesBy(0);

        // In neighboring indexes, but not the same jour.
        exam2.setPeriode(new Periode().withPeriodeIndex(1).withJourIndex(1));

        constraintVerifier.verifyThat(Contrainte::twoExamensInARow)
                .given(conflict, exam1, exam2)
                .penalizesBy(0);
        constraintVerifier.verifyThat(Contrainte::twoExamensInAJour)
                .given(conflict, exam1, exam2)
                .penalizesBy(0);

        // Not in a row on the same jour.
        exam2.setPeriode(new Periode().withPeriodeIndex(2).withJourIndex(0));

        constraintVerifier.verifyThat(Contrainte::twoExamensInARow)
                .given(conflict, exam1, exam2)
                .penalizesBy(0);
        constraintVerifier.verifyThat(Contrainte::twoExamensInAJour)
                .given(conflict, exam1, exam2)
                .penalizesBy(2);

        // In a row on the same jour. These two constraints don't overlap, therefore only the twoExamsInARow triggers.
        exam2.setPeriode(new Periode().withPeriodeIndex(1).withJourIndex(0));

        constraintVerifier.verifyThat(Contrainte::twoExamensInARow)
                .given(conflict, exam1, exam2)
                .penalizesBy(2);
        constraintVerifier.verifyThat(Contrainte::twoExamensInAJour)
                .given(conflict, exam1, exam2)
                .penalizesBy(0);
    }

    @Test
    public void periodeSpreadTest() {
        CalendrierContraintes config = new CalendrierContraintes()
                // At least 1 periode apart.
                .withPeriodeSpreadLength(1);

        Epreuve epreuve1 = new Epreuve();
        Epreuve epreuve2 = new Epreuve();
        EpreuveConflit epreuveConflict = new EpreuveConflit(epreuve1, epreuve2, 3);

        ExamenEnCours exam1 = new ExamenEnCours()
                .withEpreuve(epreuve1)
                .withPeriode(new Periode().withPeriodeIndex(0))
                .withSalle(new Salle());
        ExamenEnCours exam2 = new ExamenEnCours()
                .withEpreuve(epreuve2)
                .withPeriode(new Periode().withPeriodeIndex(0))
                .withSalle(new Salle());

        // Periode index saturation: 0, 0
        // Should trigger when periode spread length is 1.
        constraintVerifier.verifyThat(Contrainte::periodeSpread)
                .given(config, epreuveConflict, exam1, exam2)
                .penalizesBy(3);

        // Periode index saturation: 0, 1
        // Should trigger when periode spread length is 1.
        exam2.setPeriode(new Periode().withPeriodeIndex(1));

        constraintVerifier.verifyThat(Contrainte::periodeSpread)
                .given(config, epreuveConflict, exam1, exam2)
                .penalizesBy(3);

        // Periode index saturation: 0, 2
        exam2.setPeriode(new Periode().withPeriodeIndex(2));

        constraintVerifier.verifyThat(Contrainte::periodeSpread)
                .given(config, epreuveConflict, exam1, exam2)
                .penalizesBy(0);
    }

    @Test
    public void mixedDurees11Test() {
        Periode periode = new Periode();
        Salle salle = new Salle();
        ExamenEnCours exam1 = new ExamenEnCours()
                .withId(1L)
                .withEpreuve(new Epreuve()
                        .withId(1)
                        .withDuree(1))
                .withPeriode(periode)
                .withSalle(salle);
        ExamenEnCours exam2 = new ExamenEnCours()
                .withId(2L)
                .withEpreuve(new Epreuve()
                        .withId(2)
                        .withDuree(1))
                .withPeriode(periode)
                .withSalle(salle);

        // Epreuve durees: 1, 1
        constraintVerifier.verifyThat(Contrainte::mixedDurees)
                .given(exam1, exam2)
                .penalizesBy(0);
    }

    @Test
    public void mixedDurees12Test() {
        Periode periode = new Periode();
        Salle salle = new Salle();
        ExamenEnCours exam1 = new ExamenEnCours()
                .withId(1L)
                .withEpreuve(new Epreuve()
                        .withId(1)
                        .withDuree(1))
                .withPeriode(periode)
                .withSalle(salle);
        ExamenEnCours exam2 = new ExamenEnCours()
                .withId(2L)
                .withEpreuve(new Epreuve()
                        .withId(2)
                        .withDuree(2))
                .withPeriode(periode)
                .withSalle(salle);

        // Epreuve durees: 1, 2
        constraintVerifier.verifyThat(Contrainte::mixedDurees)
                .given(exam1, exam2)
                .penalizesBy(1);
    }

    @Test
    public void mixedDurees123Test() {
        Periode periode = new Periode();
        Salle salle = new Salle();
        ExamenEnCours exam1 = new ExamenEnCours()
                .withId(1L)
                .withEpreuve(new Epreuve()
                        .withId(1)
                        .withDuree(1))
                .withPeriode(periode)
                .withSalle(salle);
        ExamenEnCours exam2 = new ExamenEnCours()
                .withId(2L)
                .withEpreuve(new Epreuve()
                        .withId(2)
                        .withDuree(2))
                .withPeriode(periode)
                .withSalle(salle);
        ExamenEnCours exam3 = new ExamenEnCours()
                .withId(3L)
                .withEpreuve(new Epreuve()
                        .withId(3)
                        .withDuree(3))
                .withPeriode(periode)
                .withSalle(salle);

        // Epreuve durees: 1, 2, 3
        constraintVerifier.verifyThat(Contrainte::mixedDurees)
                .given(exam1, exam2, exam3)
                .penalizesBy(2);
    }

    @Test
    public void mixedDurees113Test() {
        Periode periode = new Periode();
        Salle salle = new Salle();
        ExamenEnCours exam1 = new ExamenEnCours()
                .withId(1L)
                .withEpreuve(new Epreuve()
                        .withId(1)
                        .withDuree(1))
                .withPeriode(periode)
                .withSalle(salle);
        ExamenEnCours exam2 = new ExamenEnCours()
                .withId(2L)
                .withEpreuve(new Epreuve()
                        .withId(2)
                        .withDuree(1))
                .withPeriode(periode)
                .withSalle(salle);
        ExamenEnCours exam3 = new ExamenEnCours()
                .withId(3L)
                .withEpreuve(new Epreuve()
                        .withId(3)
                        .withDuree(3))
                .withPeriode(periode)
                .withSalle(salle);

        // Epreuve durees: 1, 1, 3
        constraintVerifier.verifyThat(Contrainte::mixedDurees)
                .given(exam1, exam2, exam3)
                .penalizesBy(1);
    }

    @Test
    public void mixedDurees133Test() {
        Periode periode = new Periode();
        Salle salle = new Salle();
        ExamenEnCours exam1 = new ExamenEnCours()
                .withId(1L)
                .withEpreuve(new Epreuve()
                        .withId(1)
                        .withDuree(1))
                .withPeriode(periode)
                .withSalle(salle);
        ExamenEnCours exam2 = new ExamenEnCours()
                .withId(2L)
                .withEpreuve(new Epreuve()
                        .withId(2)
                        .withDuree(3))
                .withPeriode(periode)
                .withSalle(salle);
        ExamenEnCours exam3 = new ExamenEnCours()
                .withId(3L)
                .withEpreuve(new Epreuve()
                        .withId(3)
                        .withDuree(3))
                .withPeriode(periode)
                .withSalle(salle);

        // Epreuve durees: 1, 3, 3
        constraintVerifier.verifyThat(Contrainte::mixedDurees)
                .given(exam1, exam2, exam3)
                .penalizesBy(1);
    }

    @Test
    public void mixedDurees131Test() {
        Periode periode = new Periode();
        Salle salle = new Salle();
        ExamenEnCours exam1 = new ExamenEnCours()
                .withId(1L)
                .withEpreuve(new Epreuve()
                        .withId(1)
                        .withDuree(1))
                .withPeriode(periode)
                .withSalle(salle);
        ExamenEnCours exam2 = new ExamenEnCours()
                .withId(2L)
                .withEpreuve(new Epreuve()
                        .withId(2)
                        .withDuree(3))
                .withPeriode(periode)
                .withSalle(salle);
        ExamenEnCours exam3 = new ExamenEnCours()
                .withId(3L)
                .withEpreuve(new Epreuve()
                        .withId(3)
                        .withDuree(1))
                .withPeriode(periode)
                .withSalle(salle);

        // Epreuve durees: 1, 3, 1
        constraintVerifier.verifyThat(Contrainte::mixedDurees)
                .given(exam1, exam2, exam3)
                .penalizesBy(1);
    }

    @Test
    public void mixedDurees431Test() {
        Periode periode = new Periode();
        Salle salle = new Salle();
        ExamenEnCours exam1 = new ExamenEnCours()
                .withId(1L)
                .withEpreuve(new Epreuve()
                        .withId(1)
                        .withDuree(4))
                .withPeriode(periode)
                .withSalle(salle);
        ExamenEnCours exam2 = new ExamenEnCours()
                .withId(2L)
                .withEpreuve(new Epreuve()
                        .withId(2)
                        .withDuree(3))
                .withPeriode(periode)
                .withSalle(salle);
        ExamenEnCours exam3 = new ExamenEnCours()
                .withId(3L)
                .withEpreuve(new Epreuve()
                        .withId(3)
                        .withDuree(1))
                .withPeriode(periode)
                .withSalle(salle);

        // Epreuve durees: 4, 3, 1
        constraintVerifier.verifyThat(Contrainte::mixedDurees)
                .given(exam1, exam2, exam3)
                .penalizesBy(2);
    }

    @Test
    public void mixedDurees411Test() {
        Periode periode = new Periode();
        Salle salle = new Salle();
        ExamenEnCours exam1 = new ExamenEnCours()
                .withId(1L)
                .withEpreuve(new Epreuve()
                        .withId(1)
                        .withDuree(4))
                .withPeriode(periode)
                .withSalle(salle);
        ExamenEnCours exam2 = new ExamenEnCours()
                .withId(2L)
                .withEpreuve(new Epreuve()
                        .withId(2)
                        .withDuree(1))
                .withPeriode(periode)
                .withSalle(salle);
        ExamenEnCours exam3 = new ExamenEnCours()
                .withId(3L)
                .withEpreuve(new Epreuve()
                        .withId(3)
                        .withDuree(1))
                .withPeriode(periode)
                .withSalle(salle);

        // Epreuve durees: 4, 1, 1
        constraintVerifier.verifyThat(Contrainte::mixedDurees)
                .given(exam1, exam2, exam3)
                .penalizesBy(1);
    }

    @Test
    public void mixedDurees441Test() {
        Periode periode = new Periode();
        Salle salle = new Salle();
        ExamenEnCours exam1 = new ExamenEnCours()
                .withId(1L)
                .withEpreuve(new Epreuve()
                        .withId(1)
                        .withDuree(4))
                .withPeriode(periode)
                .withSalle(salle);
        ExamenEnCours exam2 = new ExamenEnCours()
                .withId(2L)
                .withEpreuve(new Epreuve()
                        .withId(2)
                        .withDuree(4))
                .withPeriode(periode)
                .withSalle(salle);
        ExamenEnCours exam3 = new ExamenEnCours()
                .withId(3L)
                .withEpreuve(new Epreuve()
                        .withId(3)
                        .withDuree(1))
                .withPeriode(periode)
                .withSalle(salle);

        // Epreuve durees: 4, 4, 1
        constraintVerifier.verifyThat(Contrainte::mixedDurees)
                .given(exam1, exam2, exam3)
                .penalizesBy(1);
    }

    @Test
    public void frontLoadTest() {
        ExamenEnCours exam = new ExamenEnCours()
                .withPeriode(new Periode().withFrontLoadLast(true))
                .withEpreuve(new Epreuve().withFrontLoadLarge(true))
                .withSalle(new Salle());

        constraintVerifier.verifyThat(Contrainte::frontLoad)
                .given(exam)
                .penalizesBy(1);
    }

    @Test
    public void periodePenaliteTest() {
        Periode periode = new Periode().withPenalite(5);
        Salle salle = new Salle();
        ExamenEnCours exam1 = new ExamenEnCours().withPeriode(periode).withSalle(salle);

        constraintVerifier.verifyThat(Contrainte::periodePenalite)
                .given(periode, exam1)
                .penalizesBy(5);

        // Second exam in the same periode. The penalty should be added for both of them.
        ExamenEnCours exam2 = new ExamenEnCours().withPeriode(periode).withSalle(salle);

        constraintVerifier.verifyThat(Contrainte::periodePenalite)
                .given(periode, exam1, exam2)
                .penalizesBy(10);
    }

    @Test
    public void sallePenaliteTest() {
        Salle salle = new Salle().withPenalite(5);
        ExamenEnCours exam1 = new ExamenEnCours().withSalle(salle).withPeriode(new Periode());

        constraintVerifier.verifyThat(Contrainte::sallePenalite)
                .given(salle, exam1)
                .penalizesBy(5);

        // Second exam in the same periode. The penalty should be added for both of them.
        ExamenEnCours exam2 = new ExamenEnCours().withSalle(salle).withPeriode(new Periode());

        constraintVerifier.verifyThat(Contrainte::sallePenalite)
                .given(salle, exam1, exam2)
                .penalizesBy(10);
    }
}
