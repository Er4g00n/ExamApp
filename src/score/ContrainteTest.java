
package score;

import examen.Examen;
import examen.Calendrier;
import examen.Epreuve;
import examen.Timeslot;
import examen.Jour;
import examen.Periode;
import salle.Salle;
import org.junit.jupiter.api.Test;
import org.optaplanner.test.api.score.stream.ConstraintVerifier;

public class ContrainteTest {

    private static final Examen EXAMEN1 = new Examen(1, "Exam1", 20, 3);
    private static final Examen EXAMEN2 = new Examen(2, "Exam2", 10, 2);
    private static final Examen COURSE_3 = new Examen(3, "Exam3", 5, 1);
    private static final Salle SALLE1 = new Salle("Salle1", 10);
    private static final Salle ROOM_2 = new Salle("Salle2", 20);
    private static final Timeslot FIRST_TIMESLOT = new Timeslot(0);
    private static final Timeslot SECOND_TIMESLOT = new Timeslot(1);
    private static final Jour MONDAY = new Jour(0);
    private static final Jour TUESDAY = new Jour(1);
    private static final Periode LUNDI = new Periode(0, MONDAY, FIRST_TIMESLOT);
    private static final Periode LUNDI2 = new Periode(1, MONDAY, SECOND_TIMESLOT);
    private static final Periode LUNDI3 = new Periode(2, TUESDAY, FIRST_TIMESLOT);

    private final ConstraintVerifier<Contrainte, Calendrier> constraintVerifier =
            ConstraintVerifier.build(new Contrainte(), Calendrier.class, Epreuve.class);
    @SuppressWarnings("all")

/**
 * Test permetant de tester la class ConflitEpreuve
 * Test de calcule de conflit
*/
    @Test
    public void conflitEpreuveDansLaMemeDuree() {
        int compteur = 2; // limite de conflit
        ConflitEpreuve conflitEpreuve = new ConflitEpreuve(EXAMEN1, EXAMEN2, compteur);

        // Voir si des epreuves sans periode ne seront pas comptabilise.
        Epreuve epreuve1SansPeriode = new Epreuve(0, EXAMEN1, null, null);
        Epreuve epreuve2SansPeriode = new Epreuve(1, EXAMEN1, null, null);
        // Voir si des epreuves sur la meme periode genere un conflit
        Epreuve epreuve1AvecPeriode = new Epreuve(2, EXAMEN1, LUNDI, SALLE1);
        Epreuve epreuve2AvecPeriode = new Epreuve(3, EXAMEN2, LUNDI, SALLE1);
        constraintVerifier.verifyThat(Contrainte::conflictingLecturesDifferentCourseInSamePeriod)
                .given(conflitEpreuve, epreuve1SansPeriode, epreuve2SansPeriode, epreuve1AvecPeriode, epreuve2AvecPeriode)
                .penalizesBy(compteur);
    }

    @Test
    public void conflitEpreuveMemeHoraireMemeExamen() {
        // Test de piece differente
        Epreuve epreuve1AvecPeriode = new Epreuve(2, EXAMEN1, LUNDI, SALLE1);
        Epreuve epreuve2AvecPeriode = new Epreuve(3, EXAMEN1, LUNDI, SALLE2);
        // Test, si le cours est different, il n'est pas comptabilise dans le compteur de conflit
        Epreuve epreuve3AvecPeriode = new Epreuve(4, EXAMEN2, LUNDI, SALLE1);
        constraintVerifier.verifyThat(Contrainte::conflictingLecturesSameCourseInSamePeriod)
                .given(epreuve1AvecPeriode, epreuve2AvecPeriode, epreuve3AvecPeriode)
                .penalizesBy(2);
    }

    @Test
    public void roomOccupancy() {
        // Make sure that unassigned lectures are ignored.
        Epreuve unassignedLecture = new Epreuve(0, COURSE_1, null, null);
        // Make sure only unique pairs are counted.
        Epreuve assignedLecture1 = new Epreuve(2, COURSE_1, PERIOD_1_MONDAY, ROOM_1);
        Epreuve assignedLecture2 = new Epreuve(3, COURSE_2, PERIOD_1_MONDAY, ROOM_1);
        Epreuve assignedLecture3 = new Epreuve(4, COURSE_3, PERIOD_1_MONDAY, ROOM_1);
        // Make sure that different rooms are irrelevant.
        Epreuve assignedLecture4 = new Epreuve(5, COURSE_1, PERIOD_1_MONDAY, ROOM_2);
        constraintVerifier.verifyThat(Contrainte::roomOccupancy)
                .given(unassignedLecture, assignedLecture1, assignedLecture2, assignedLecture3, assignedLecture4)
                .penalizesBy(3);
    }

    @Test
    public void unavailablePeriodPenalty() {
        UnavailablePeriodPenalty unavailablePeriodPenalty = new UnavailablePeriodPenalty(0, COURSE_1, PERIOD_1_MONDAY);
        Epreuve matchingLecture = new Epreuve(0, COURSE_1, PERIOD_1_MONDAY, ROOM_1);
        Epreuve wrongCourseLecture = new Epreuve(1, COURSE_2, PERIOD_1_MONDAY, ROOM_2);
        Epreuve wrongPeriodLecture = new Epreuve(2, COURSE_1, PERIOD_2_MONDAY, ROOM_1);
        constraintVerifier.verifyThat(Contrainte::unavailablePeriodPenalty)
                .given(unavailablePeriodPenalty, matchingLecture, wrongCourseLecture, wrongPeriodLecture)
                .penalizesBy(1);
    }

    @Test
    public void roomCapacity() {
        Epreuve overbookedLecture = new Epreuve(0, COURSE_1, PERIOD_1_MONDAY, ROOM_1);
        Epreuve packedLecture = new Epreuve(1, COURSE_2, PERIOD_2_MONDAY, ROOM_1);
        Epreuve nearlyEmptyLecture = new Epreuve(2, COURSE_3, PERIOD_1_TUESDAY, ROOM_2);
        constraintVerifier.verifyThat(Contrainte::roomCapacity)
                .given(overbookedLecture, packedLecture, nearlyEmptyLecture)
                .penalizesBy(10); // Only penalizes the overbooked lecture.
    }

    @Test
    public void minimumWorkingDays() {
        Epreuve meetsMinimum = new Epreuve(0, COURSE_3, PERIOD_1_MONDAY, ROOM_1);
        Epreuve doesNotMeetMinimumBy1 = new Epreuve(1, COURSE_2, PERIOD_1_MONDAY, ROOM_2);
        Epreuve doesNotMeetMinimumBy2 = new Epreuve(2, COURSE_1, PERIOD_2_MONDAY, ROOM_1);
        constraintVerifier.verifyThat(Contrainte::minimumWorkingDays)
                .given(meetsMinimum, doesNotMeetMinimumBy1, doesNotMeetMinimumBy2)
                .penalizesBy(3);
    }


    @Test
    public void roomStability() {
        Epreuve lectureOfSameCourse1 = new Epreuve(0, COURSE_1, PERIOD_1_MONDAY, ROOM_1);
        Epreuve lectureOfSameCourse2 = new Epreuve(0, COURSE_1, PERIOD_1_MONDAY, ROOM_2);
        Epreuve lectureOfSameCourse3 = new Epreuve(0, COURSE_1, PERIOD_2_MONDAY, ROOM_1);
        Epreuve lectureOfDifferentCourse = new Epreuve(0, COURSE_2, PERIOD_2_MONDAY, ROOM_1);
        constraintVerifier.verifyThat(Contrainte::roomStability)
                .given(lectureOfSameCourse1, lectureOfSameCourse2, lectureOfSameCourse3, lectureOfDifferentCourse)
                .penalizesBy(1); // lectureOfSameCourse2 is penalized
    }

}
