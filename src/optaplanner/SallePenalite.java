package optaplanner;

import abstracts.AbstractPersistable;
import com.thoughtworks.xstream.annotations.XStreamAlias;


/**
 * The type Salle penalite.
 */
@XStreamAlias("SallePenalite")
public class SallePenalite extends AbstractPersistable {

    private SallePenaliteType sallePenaliteType;
    private Epreuve epreuve;

    /**
     * Gets salle penalite type.
     *
     * @return the salle penalite type
     */
    public SallePenaliteType getSallePenaliteType() {
        return sallePenaliteType;
    }

    /**
     * Sets salle penalite type.
     *
     * @param sallePenaliteType the salle penalite type
     */
    public void setSallePenaliteType(SallePenaliteType sallePenaliteType) {
        this.sallePenaliteType = sallePenaliteType;
    }

    /**
     * Gets epreuve.
     *
     * @return the epreuve
     */
    public Epreuve getEpreuve() {
        return epreuve;
    }

    /**
     * Sets epreuve.
     *
     * @param epreuve the epreuve
     */
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

    /**
     * With id salle penalite.
     *
     * @param id the id
     * @return the salle penalite
     */
    public SallePenalite withId(long id) {
        this.setId(id);
        return this;
    }

    /**
     * With salle penalite type salle penalite.
     *
     * @param type the type
     * @return the salle penalite
     */
    public SallePenalite withSallePenaliteType(SallePenaliteType type) {
        this.setSallePenaliteType(type);
        return this;
    }

    /**
     * With epreuve salle penalite.
     *
     * @param epreuve the epreuve
     * @return the salle penalite
     */
    public SallePenalite withEpreuve(Epreuve epreuve) {
        this.setEpreuve(epreuve);
        return this;
    }

}
