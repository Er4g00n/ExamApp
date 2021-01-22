package optaplanner;

import abstracts.AbstractPersistable;
import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * The type Periode penalite.
 */
@XStreamAlias("PeriodePenalite")
public class PeriodePenalite extends AbstractPersistable {

    private PeriodePenaliteType periodePenaliteType;
    private Epreuve leftEpreuve;
    private Epreuve rightEpreuve;

    /**
     * Instantiates a new Periode penalite.
     */
    public PeriodePenalite() {
    }

    /**
     * Instantiates a new Periode penalite.
     *
     * @param leftEpreuve         the left epreuve
     * @param rightEpreuve        the right epreuve
     * @param periodePenaliteType the periode penalite type
     */
    public PeriodePenalite(Epreuve leftEpreuve, Epreuve rightEpreuve, PeriodePenaliteType periodePenaliteType) {
        this.leftEpreuve = leftEpreuve;
        this.rightEpreuve = rightEpreuve;
        this.periodePenaliteType = periodePenaliteType;
    }

    /**
     * Gets periode penalite type.
     *
     * @return the periode penalite type
     */
    public PeriodePenaliteType getPeriodePenaliteType() {
        return periodePenaliteType;
    }

    /**
     * Sets periode penalite type.
     *
     * @param periodePenaliteType the periode penalite type
     */
    public void setPeriodePenaliteType(PeriodePenaliteType periodePenaliteType) {
        this.periodePenaliteType = periodePenaliteType;
    }

    /**
     * Gets left epreuve.
     *
     * @return the left epreuve
     */
    public Epreuve getLeftEpreuve() {
        return leftEpreuve;
    }

    /**
     * Sets left epreuve.
     *
     * @param leftEpreuve the left epreuve
     */
    public void setLeftEpreuve(Epreuve leftEpreuve) {
        this.leftEpreuve = leftEpreuve;
    }

    /**
     * Gets right epreuve.
     *
     * @return the right epreuve
     */
    public Epreuve getRightEpreuve() {
        return rightEpreuve;
    }

    /**
     * Sets right epreuve.
     *
     * @param rightEpreuve the right epreuve
     */
    public void setRightEpreuve(Epreuve rightEpreuve) {
        this.rightEpreuve = rightEpreuve;
    }

    @Override
    public String toString() {
        return periodePenaliteType + "@" + leftEpreuve.getId() + "&" + rightEpreuve.getId();
    }

}
