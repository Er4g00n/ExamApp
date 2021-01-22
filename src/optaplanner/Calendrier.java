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
import salle.Salle;
import utilisateur.Etudiant;

import java.util.ArrayList;
import java.util.List;

/**
 * The type Calendrier.
 */
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

    /**
     * Obtient la configuration de la contrainte.
     *
     * @return the constraint configuration
     */
    @ConstraintConfigurationProvider
    public CalendrierContraintes getConstraintConfiguration() {
        return constraintConfiguration;
    }

    /**
     * Définit la configuration des contraintes.
     *
     * @param constraintConfiguration the constraint configuration
     */
    public void setConstraintConfiguration(CalendrierContraintes constraintConfiguration) {
        this.constraintConfiguration = constraintConfiguration;
    }

    /**
     * Gets etudiant list.
     *
     * @return the etudiant list
     */
    public List<Etudiant> getEtudiantList() {
        return etudiantList;
    }

    /**
     * Sets etudiant list.
     *
     * @param etudiantList the etudiant list
     */
    public void setEtudiantList(List<Etudiant> etudiantList) {
        this.etudiantList = etudiantList;
    }

    /**
     * Gets epreuve list.
     *
     * @return the epreuve list
     */
    @ProblemFactCollectionProperty
    public List<Epreuve> getEpreuveList() {
        return epreuveList;
    }

    /**
     * Sets epreuve list.
     *
     * @param epreuveList the epreuve list
     */
    public void setEpreuveList(List<Epreuve> epreuveList) {
        this.epreuveList = epreuveList;
    }

    /**
     * Gets periode list.
     *
     * @return the periode list
     */
    @ValueRangeProvider(id = "periodeRange")
    @ProblemFactCollectionProperty
    public List<Periode> getPeriodeList() {
        return periodeList;
    }

    /**
     * Sets periode list.
     *
     * @param periodeList the periode list
     */
    public void setPeriodeList(List<Periode> periodeList) {
        this.periodeList = periodeList;
    }

    /**
     * Gets salle list.
     *
     * @return the salle list
     */
    @ValueRangeProvider(id = "salleRange")
    @ProblemFactCollectionProperty
    public List<Salle> getSalleList() {
        return salleList;
    }

    /**
     * Sets salle list.
     *
     * @param salleList the salle list
     */
    public void setSalleList(List<Salle> salleList) {
        this.salleList = salleList;
    }

    /**
     * Gets periode penalite list.
     *
     * @return the periode penalite list
     */
    @ProblemFactCollectionProperty
    public List<PeriodePenalite> getPeriodePenaliteList() {
        return periodePenaliteList;
    }

    /**
     * Sets periode penalite list.
     *
     * @param periodePenaliteList the periode penalite list
     */
    public void setPeriodePenaliteList(List<PeriodePenalite> periodePenaliteList) {
        this.periodePenaliteList = periodePenaliteList;
    }

    /**
     * Gets salle penalite list.
     *
     * @return the salle penalite list
     */
    @ProblemFactCollectionProperty
    public List<SallePenalite> getSallePenaliteList() {
        return sallePenaliteList;
    }

    /**
     * Sets salle penalite list.
     *
     * @param sallePenaliteList the salle penalite list
     */
    public void setSallePenaliteList(List<SallePenalite> sallePenaliteList) {
        this.sallePenaliteList = sallePenaliteList;
    }

    /**
     * Gets examen list.
     *
     * @return the examen list
     */
    @PlanningEntityCollectionProperty
    public List<Examen> getExamenList() {
        return examenList;
    }

    /**
     * Sets examen list.
     *
     * @param examenList the examen list
     */
    public void setExamenList(List<Examen> examenList) {
        this.examenList = examenList;
    }

    /**
     * Gets score.
     *
     * @return the score
     */
    @PlanningScore
    public HardSoftScore getScore() {
        return score;
    }

    /**
     * Sets score.
     *
     * @param score the score
     */
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
