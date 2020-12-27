package Examen;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

import java.util.ArrayList;

@PlanningSolution
public class Calendrier {

    private HardSoftScore score;

    @PlanningScore
    public HardSoftScore getScore() {
        return score;
    }

    private ArrayList<Examen> listExamen;

    @ValueRangeProvider(id = "dureeExamen")
    @PlanningEntityCollectionProperty
    public ArrayList<Examen> getListExamen() {
        return listExamen;
    }

    public void setListExamen(ArrayList<Examen> listExamen) {
        this.listExamen = listExamen;
    }

    public void exporter() {
    }

}
