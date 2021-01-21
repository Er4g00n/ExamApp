package optaplanner;

import abstracts.AbstractPersistable;
import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("PeriodePenalite")
public class PeriodePenalite extends AbstractPersistable {

    private PeriodePenaliteType periodePenaliteType;
    private Epreuve leftEpreuve;
    private Epreuve rightEpreuve;
    public PeriodePenalite() {
    }
    public PeriodePenalite(Epreuve leftEpreuve, Epreuve rightEpreuve, PeriodePenaliteType periodePenaliteType) {
        this.leftEpreuve = leftEpreuve;
        this.rightEpreuve = rightEpreuve;
        this.periodePenaliteType = periodePenaliteType;
    }

    public PeriodePenaliteType getPeriodePenaliteType() {
        return periodePenaliteType;
    }

    public void setPeriodePenaliteType(PeriodePenaliteType periodePenaliteType) {
        this.periodePenaliteType = periodePenaliteType;
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

    @Override
    public String toString() {
        return periodePenaliteType + "@" + leftEpreuve.getId() + "&" + rightEpreuve.getId();
    }

}
