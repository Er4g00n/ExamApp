package examen.solver;

import examen.Examen;

import java.util.Comparator;
import java.util.Objects;

/**
 * Cette classe permet pendant l'initiation de vérifié les conflits entre Examen
 */
public class CourseConflict implements Comparable<CourseConflict> {

    private static final Comparator<Examen> COURSE_COMPARATOR = Comparator.comparingLong(Examen::getId);
    private static final Comparator<CourseConflict> COMPARATOR = Comparator
            .comparing(CourseConflict::getLeftCourse, COURSE_COMPARATOR)
            .thenComparing(CourseConflict::getRightCourse, COURSE_COMPARATOR);

    private final Examen leftCourse;
    private final Examen rightCourse;
    private final int conflictCount;

    /**
     * Instantie un Course conflict.
     *
     * @param leftCourse    left course
     * @param rightCourse   right course
     * @param conflictCount conflict count
     */
    public CourseConflict(Examen leftCourse, Examen rightCourse, int conflictCount) {
        this.leftCourse = leftCourse;
        this.rightCourse = rightCourse;
        this.conflictCount = conflictCount;
    }

    /**
     * Gets left course.
     *
     * @return the left course
     */
    public Examen getLeftCourse() {
        return leftCourse;
    }

    /**
     * Gets right course.
     *
     * @return the right course
     */
    public Examen getRightCourse() {
        return rightCourse;
    }

    /**
     * Gets conflict count.
     *
     * @return the conflict count
     */
    public int getConflictCount() {
        return conflictCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final CourseConflict other = (CourseConflict) o;
        return Objects.equals(leftCourse, other.leftCourse) &&
                Objects.equals(rightCourse, other.rightCourse);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leftCourse, rightCourse);
    }

    @Override
    public int compareTo(CourseConflict other) {
        return COMPARATOR.compare(this, other);
    }

    @Override
    public String toString() {
        return leftCourse + " & " + rightCourse;
    }
}
