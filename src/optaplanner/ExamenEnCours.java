package optaplanner;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.variable.PlanningVariable;

import java.util.List;

@PlanningEntity
@XStreamAlias("ExamenEnCours")
public class ExamenEnCours extends Examen {

    protected List<ExamenSuivant> examenSuivantList;

    // Planning variables: changes during planning, between score calculations.
    protected Periode periode;

    public List<ExamenSuivant> getExamenSuivantList() {
        return examenSuivantList;
    }

    public void setExamenSuivantList(List<ExamenSuivant> examenSuivantList) {
        this.examenSuivantList = examenSuivantList;
    }

    @Override
    @PlanningVariable(valueRangeProviderRefs = {"periodeRange"})
    public Periode getPeriode() {
        return periode;
    }

    public void setPeriode(Periode periode) {
        this.periode = periode;
    }

    // ************************************************************************
    // With methods
    // ************************************************************************

    public ExamenEnCours withId(long id) {
        this.setId(id);
        return this;
    }

    public ExamenEnCours withEpreuve(Epreuve epreuve) {
        this.setEpreuve(epreuve);
        return this;
    }

    public ExamenEnCours withSalle(Salle salle) {
        this.setSalle(salle);
        return this;
    }

    public ExamenEnCours withPeriode(Periode periode) {
        this.setPeriode(periode);
        return this;
    }

    public ExamenEnCours withExamenSuivantList(List<ExamenSuivant> examenSuivantList) {
        this.setExamenSuivantList(examenSuivantList);
        return this;
    }

    // ************************************************************************
    // Complex methods
    // ************************************************************************

}
