package optaplanner;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import optaplanner.solver.PeriodeUpdatingVariableListener;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.CustomShadowVariable;
import org.optaplanner.core.api.domain.variable.PlanningVariableReference;
import salle.Salle;

/**
 * The type Examen suivant.
 */
@PlanningEntity
@XStreamAlias("ExamenSuivant")
public class ExamenSuivant extends Examen {

    /**
     * The Examen en cours.
     */
    protected ExamenEnCours examenEnCours;

    /**
     * The Periode.
     */
// Shadow variables
    protected Periode periode;

    /**
     * Gets examen en cours.
     *
     * @return the examen en cours
     */
    public ExamenEnCours getExamenEnCours() {
        return examenEnCours;
    }

    /**
     * Sets examen en cours.
     *
     * @param examenEnCours the examen en cours
     */
    public void setExamenEnCours(ExamenEnCours examenEnCours) {
        this.examenEnCours = examenEnCours;
    }

    @Override
    @CustomShadowVariable(variableListenerClass = PeriodeUpdatingVariableListener.class, sources = {
            @PlanningVariableReference(entityClass = ExamenEnCours.class, variableName = "periode")})
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
     * With id examen suivant.
     *
     * @param id the id
     * @return the examen suivant
     */
    public ExamenSuivant withId(long id) {
        this.setId(id);
        return this;
    }

    /**
     * With epreuve examen suivant.
     *
     * @param epreuve the epreuve
     * @return the examen suivant
     */
    public ExamenSuivant withEpreuve(Epreuve epreuve) {
        this.setEpreuve(epreuve);
        return this;
    }

    /**
     * With salle examen suivant.
     *
     * @param salle the salle
     * @return the examen suivant
     */
    public ExamenSuivant withSalle(Salle salle) {
        this.setSalle(salle);
        return this;
    }

    /**
     * With periode examen suivant.
     *
     * @param periode the periode
     * @return the examen suivant
     */
    public ExamenSuivant withPeriode(Periode periode) {
        this.setPeriode(periode);
        return this;
    }

    /**
     * With examen en cours examen suivant.
     *
     * @param examenEnCours the examen en cours
     * @return the examen suivant
     */
    public ExamenSuivant withExamenEnCours(ExamenEnCours examenEnCours) {
        this.setExamenEnCours(examenEnCours);
        return this;
    }

    // ************************************************************************
    // Complex methods
    // ************************************************************************

}
