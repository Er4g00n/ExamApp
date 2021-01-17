package optaplanner;

import abstracts.AbstractPersistable;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import optaplanner.solver.EpreuveConflit;
import org.optaplanner.core.api.domain.constraintweight.ConstraintConfigurationProvider;
import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.persistence.xstream.api.score.buildin.hardsoft.HardSoftScoreXStreamConverter;
import utilisateur.Etudiant;

import java.util.ArrayList;
import java.util.List;

@PlanningSolution()
@XStreamAlias("Calendrier")
public class Calendrier extends AbstractPersistable {

    private CalendrierContraintes constraintConfiguration;

    private List<Etudiant> etudiantList;
    private List<Epreuve> epreuveList;
    private List<Periode> periodeList;
    private List<Salle> salleList;

    private List<PeriodePenalite> periodePenaliteList;
    private List<SallePenalite> sallePenaliteList;

    private List<Examen> examenList;

    @XStreamConverter(HardSoftScoreXStreamConverter.class)
    private HardSoftScore score;

    @ConstraintConfigurationProvider
    public CalendrierContraintes getConstraintConfiguration() {
        return constraintConfiguration;
    }

    public void setConstraintConfiguration(CalendrierContraintes constraintConfiguration) {
        this.constraintConfiguration = constraintConfiguration;
    }

    public List<Etudiant> getEtudiantList() {
        return etudiantList;
    }

    public void setEtudiantList(List<Etudiant> etudiantList) {
        this.etudiantList = etudiantList;
    }

    @ProblemFactCollectionProperty
    public List<Epreuve> getEpreuveList() {
        return epreuveList;
    }

    public void setEpreuveList(List<Epreuve> epreuveList) {
        this.epreuveList = epreuveList;
    }

    @ValueRangeProvider(id = "periodeRange")
    @ProblemFactCollectionProperty
    public List<Periode> getPeriodeList() {
        return periodeList;
    }

    public void setPeriodeList(List<Periode> periodeList) {
        this.periodeList = periodeList;
    }

    @ValueRangeProvider(id = "salleRange")
    @ProblemFactCollectionProperty
    public List<Salle> getSalleList() {
        return salleList;
    }

    public void setSalleList(List<Salle> salleList) {
        this.salleList = salleList;
    }

    @ProblemFactCollectionProperty
    public List<PeriodePenalite> getPeriodePenaliteList() {
        return periodePenaliteList;
    }

    public void setPeriodePenaliteList(List<PeriodePenalite> periodePenaliteList) {
        this.periodePenaliteList = periodePenaliteList;
    }

    @ProblemFactCollectionProperty
    public List<SallePenalite> getSallePenaliteList() {
        return sallePenaliteList;
    }

    public void setSallePenaliteList(List<SallePenalite> sallePenaliteList) {
        this.sallePenaliteList = sallePenaliteList;
    }

    @PlanningEntityCollectionProperty
    public List<Examen> getExamenList() {
        return examenList;
    }

    public void setExamenList(List<Examen> examenList) {
        this.examenList = examenList;
    }

    @PlanningScore
    public HardSoftScore getScore() {
        return score;
    }

    public void setScore(HardSoftScore score) {
        this.score = score;
    }

    // ************************************************************************
    // Complex methods
    // ************************************************************************

    @ProblemFactCollectionProperty
    private List<EpreuveConflit> calculateEpreuveConflitList() {
        List<EpreuveConflit> epreuveConflitList = new ArrayList<>();
        for (Epreuve leftEpreuve : epreuveList) {
            for (Epreuve rightEpreuve : epreuveList) {
                if (leftEpreuve.getId() < rightEpreuve.getId()) {
                    int etudiantSize = 0;
                    for (Etudiant etudiant : leftEpreuve.getEtudiantList()) {
                        if (rightEpreuve.getEtudiantList().contains(etudiant)) {
                            etudiantSize++;
                        }
                    }
                    if (etudiantSize > 0) {
                        epreuveConflitList.add(new EpreuveConflit(leftEpreuve, rightEpreuve, etudiantSize));
                    }
                }
            }
        }
        return epreuveConflitList;
    }

}
