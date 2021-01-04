package Examen.solver;

import Examen.Examen;

import java.util.Comparator;
import java.util.Objects;

/**
 * Calculated during initialization, not modified during score calculation.
 */
public class CourseConflict implements Comparable<CourseConflict> {

    private static final Comparator<Examen> COURSE_COMPARATOR = Comparator.comparingLong(Examen::getId);
    private static final Comparator<CourseConflict> COMPARATOR = Comparator
            .comparing(CourseConflict::getLeftCourse, COURSE_COMPARATOR)
            .thenComparing(CourseConflict::getRightCourse, COURSE_COMPARATOR);

    private final Examen leftCourse;
    private final Examen rightCourse;
    private final int conflictCount;

    public CourseConflict(Examen leftCourse, Examen rightCourse, int conflictCount) {
        this.leftCourse = leftCourse;
        this.rightCourse = rightCourse;
        this.conflictCount = conflictCount;
    }

    public Examen getLeftCourse() {
        return leftCourse;
    }

    public Examen getRightCourse() {
        return rightCourse;
    }

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
