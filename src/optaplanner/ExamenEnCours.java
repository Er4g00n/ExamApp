package optaplanner;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;
import salle.Salle;

import java.util.List;

/**
 * The type Examen en cours.
 */
@PlanningEntity
@XStreamAlias("ExamenEnCours")
public class ExamenEnCours extends Examen {

    /**
     * The Examen suivant list.
     */
    protected List<ExamenSuivant> examenSuivantList;

    /**
     * The Periode.
     */
// Planning variables: changes during planning, between score calculations.
    protected Periode periode;

    /**
     * Gets examen suivant list.
     *
     * @return the examen suivant list
     */
    public List<ExamenSuivant> getExamenSuivantList() {
        return examenSuivantList;
    }

    /**
     * Sets examen suivant list.
     *
     * @param examenSuivantList the examen suivant list
     */
    public void setExamenSuivantList(List<ExamenSuivant> examenSuivantList) {
        this.examenSuivantList = examenSuivantList;
    }

    @Override
    @PlanningVariable(valueRangeProviderRefs = {"periodeRange"})
    public Periode getPeriode() {
        return periode;
    }

    /**
     * Sets periode.
     *
     * @param periode the periode
     */
    public void setPeriode(Periode periode) {
        this.periode = periode;
    }

    // ************************************************************************
    // With methods
    // ************************************************************************

    /**
     * With id examen en cours.
     *
     * @param id the id
     * @return the examen en cours
     */
    public ExamenEnCours withId(long id) {
        this.setId(id);
        return this;
    }

    /**
     * With epreuve examen en cours.
     *
     * @param epreuve the epreuve
     * @return the examen en cours
     */
    public ExamenEnCours withEpreuve(Epreuve epreuve) {
        this.setEpreuve(epreuve);
        return this;
    }

    /**
     * With salle examen en cours.
     *
     * @param salle the salle
     * @return the examen en cours
     */
    public ExamenEnCours withSalle(Salle salle) {
        this.setSalle(salle);
        return this;
    }

    /**
     * With periode examen en cours.
     *
     * @param periode the periode
     * @return the examen en cours
     */
    public ExamenEnCours withPeriode(Periode periode) {
        this.setPeriode(periode);
        return this;
    }

    /**
     * With examen suivant list examen en cours.
     *
     * @param examenSuivantList the examen suivant list
     * @return the examen en cours
     */
    public ExamenEnCours withExamenSuivantList(List<ExamenSuivant> examenSuivantList) {
        this.setExamenSuivantList(examenSuivantList);
        return this;
    }

    // ************************************************************************
    // Complex methods
    // ************************************************************************

}
