package optaplanner;

import abstracts.AbstractPersistable;
import com.thoughtworks.xstream.annotations.XStreamAlias;


@XStreamAlias("SallePenalite")
public class SallePenalite extends AbstractPersistable {

    private SallePenaliteType sallePenaliteType;
    private Epreuve epreuve;

    public SallePenaliteType getSallePenaliteType() {
        return sallePenaliteType;
    }

    public void setSallePenaliteType(SallePenaliteType sallePenaliteType) {
        this.sallePenaliteType = sallePenaliteType;
    }

    public Epreuve getEpreuve() {
        return epreuve;
    }

    public void setEpreuve(Epreuve epreuve) {
        this.epreuve = epreuve;
    }

    @Override
    public String toString() {
        return sallePenaliteType + "@" + epreuve.getId();
    }

    // ************************************************************************
    // With methods
    // ************************************************************************

    public SallePenalite withId(long id) {
        this.setId(id);
        return this;
    }

    public SallePenalite withSallePenaliteType(SallePenaliteType type) {
        this.setSallePenaliteType(type);
        return this;
    }

    public SallePenalite withEpreuve(Epreuve epreuve) {
        this.setEpreuve(epreuve);
        return this;
    }

}
