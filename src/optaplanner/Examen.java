package optaplanner;

import abstracts.AbstractPersistable;
import com.thoughtworks.xstream.annotations.XStreamInclude;
import optaplanner.solver.ExamenPoidDetermination;
import optaplanner.solver.SallePoidDetermination;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;
import salle.Salle;

/**
 * The type Examen.
 */
@PlanningEntity(difficultyWeightFactoryClass = ExamenPoidDetermination.class)
@XStreamInclude({
        ExamenEnCours.class,
        ExamenSuivant.class
})
public abstract class Examen extends AbstractPersistable {

    /**
     * The Epreuve.
     */
    protected Epreuve epreuve;

    /**
     * The Salle.
     */
// Planning variables: changes during planning, between score calculations.
    protected Salle salle;

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

    /**
     * Gets salle.
     *
     * @return the salle
     */
    @PlanningVariable(valueRangeProviderRefs = {"salleRange"}, strengthWeightFactoryClass = SallePoidDetermination.class)
    public Salle getSalle() {
        return salle;
    }

    /**
     * Sets salle.
     *
     * @param salle the salle
     */
    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    /**
     * Gets periode.
     *
     * @return the periode
     */
    public abstract Periode getPeriode();

    /**
     * Gets epreuve duree.
     *
     * @return the epreuve duree
     */
    public int getEpreuveDuree() {
        return getEpreuve().getDuree();
    }

    /**
     * Gets epreuve etudiant size.
     *
     * @return the epreuve etudiant size
     */
    public int getEpreuveEtudiantSize() {
        return getEpreuve().getEtudiantSize();
    }

    /**
     * Gets jour index.
     *
     * @return the jour index
     */
    public int getJourIndex() {
        Periode periode = getPeriode();
        if (periode == null) {
            return Integer.MIN_VALUE;
        }
        return periode.getJourIndex();
    }

    /**
     * Gets periode index.
     *
     * @return the periode index
     */
    public int getPeriodeIndex() {
        Periode periode = getPeriode();
        if (periode == null) {
            return Integer.MIN_VALUE;
        }
        return periode.getPeriodeIndex();
    }

    /**
     * Gets periode duree.
     *
     * @return the periode duree
     */
    public int getPeriodeDuree() {
        Periode periode = getPeriode();
        if (periode == null) {
            return Integer.MIN_VALUE;
        }
        return periode.getDuree();
    }

    /**
     * Is epreuve front load large boolean.
     *
     * @return the boolean
     */
    public boolean isEpreuveFrontLoadLarge() {
        return epreuve.isFrontLoadLarge();
    }

    /**
     * Is periode front load last boolean.
     *
     * @return the boolean
     */
    public boolean isPeriodeFrontLoadLast() {
        Periode periode = getPeriode();
        if (periode == null) {
            return false;
        }
        return periode.isFrontLoadLast();
    }

    /**
     * Gets label.
     *
     * @return the label
     */
    public String getLabel() {
        return Long.toString(epreuve.getId());
    }

    @Override
    public String toString() {
        return epreuve.toString();
    }

}
