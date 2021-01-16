package optaplanner;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import optaplanner.solver.PeriodeUpdatingVariableListener;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.CustomShadowVariable;
import org.optaplanner.core.api.domain.variable.PlanningVariableReference;

@PlanningEntity
@XStreamAlias("ExamenSuivant")
public class ExamenSuivant extends Examen {

    protected ExamenEnCours examenEnCours;

    // Shadow variables
    protected Periode periode;

    public ExamenEnCours getExamenEnCours() {
        return examenEnCours;
    }

    public void setExamenEnCours(ExamenEnCours examenEnCours) {
        this.examenEnCours = examenEnCours;
    }

    @Override
    @CustomShadowVariable(variableListenerClass = PeriodeUpdatingVariableListener.class, sources = {
            @PlanningVariableReference(entityClass = ExamenEnCours.class, variableName = "periode")})
    public Periode getPeriode() {
        return periode;
    }

    public void setPeriode(Periode periode) {
        this.periode = periode;
    }

    // ************************************************************************
    // With methods
    // ************************************************************************

    public ExamenSuivant withId(long id) {
        this.setId(id);
        return this;
    }

    public ExamenSuivant withEpreuve(Epreuve epreuve) {
        this.setEpreuve(epreuve);
        return this;
    }

    public ExamenSuivant withSalle(Salle salle) {
        this.setSalle(salle);
        return this;
    }

    public ExamenSuivant withPeriode(Periode periode) {
        this.setPeriode(periode);
        return this;
    }

    public ExamenSuivant withExamenEnCours(ExamenEnCours examenEnCours) {
        this.setExamenEnCours(examenEnCours);
        return this;
    }

    // ************************************************************************
    // Complex methods
    // ************************************************************************

}
