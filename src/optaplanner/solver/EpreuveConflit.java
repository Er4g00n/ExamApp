package optaplanner.solver;

import optaplanner.Epreuve;

import java.util.Comparator;
import java.util.Objects;

/**
 * Calculated during initialization, not modified during score calculation.
 */
public class EpreuveConflit implements Comparable<EpreuveConflit> {

    private static final Comparator<Epreuve> TOPIC_COMPARATOR = Comparator.comparingLong(Epreuve::getId);
    private static final Comparator<EpreuveConflit> COMPARATOR = Comparator
            .comparing(EpreuveConflit::getLeftEpreuve, TOPIC_COMPARATOR)
            .thenComparing(EpreuveConflit::getRightEpreuve, TOPIC_COMPARATOR);
    private Epreuve leftEpreuve;
    private Epreuve rightEpreuve;
    private int etudiantSize;

    public EpreuveConflit(Epreuve leftEpreuve, Epreuve rightEpreuve, int etudiantSize) {
        this.leftEpreuve = leftEpreuve;
        this.rightEpreuve = rightEpreuve;
        this.etudiantSize = etudiantSize;
    }

    public Epreuve getLeftEpreuve() {
        return leftEpreuve;
    }

    public void setLeftEpreuve(Epreuve leftEpreuve) {
        this.leftEpreuve = leftEpreuve;
    }

    public Epreuve getRightEpreuve() {
        return rightEpreuve;
    }

    public void setRightEpreuve(Epreuve rightEpreuve) {
        this.rightEpreuve = rightEpreuve;
    }

    public int getEtudiantSize() {
        return etudiantSize;
    }

    public void setEtudiantSize(int etudiantSize) {
        this.etudiantSize = etudiantSize;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final EpreuveConflit other = (EpreuveConflit) o;
        return Objects.equals(leftEpreuve, other.leftEpreuve) &&
                Objects.equals(rightEpreuve, other.rightEpreuve);
    }

    @Override
    public int hashCode() {
        return Objects.hash(leftEpreuve, rightEpreuve);
    }

    @Override
    public int compareTo(EpreuveConflit other) {
        return COMPARATOR.compare(this, other);
    }

    @Override
    public String toString() {
        return leftEpreuve + " & " + rightEpreuve + " = " + etudiantSize;
    }
}
