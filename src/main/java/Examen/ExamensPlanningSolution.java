package Examen;

import Salle.Salle;
import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

import java.util.ArrayList;
import java.util.List;

@PlanningSolution
public class ExamensPlanningSolution {
    private List<Examen> listExamen;
    private List<Salle> listSalles;
    private List<Periode> listPeriode;

    private HardSoftScore score;

    public ExamensPlanningSolution() {
        listExamen = new ArrayList<>();
        listSalles = new ArrayList<>();
        listPeriode = new ArrayList<>();
    }

    @PlanningEntityCollectionProperty
    public List<Examen> getListExamen() {
        return listExamen;
    }

    @ValueRangeProvider(id = "sallesPossible")
    @PlanningEntityCollectionProperty
    public List<Salle> getListSalles() {
        return listSalles;
    }

    @ValueRangeProvider(id = "periodesPossible")
    @PlanningEntityCollectionProperty
    public List<Periode> getListPeriode() {
        return listPeriode;
    }

    @PlanningScore
    public HardSoftScore getScore() {
        return score;
    }

    public void setScore(HardSoftScore score) {
        this.score = score;
    }
}
