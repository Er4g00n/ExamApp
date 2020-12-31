package Examen;

import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;

import java.util.ArrayList;


public class Calendrier {
    private ArrayList<Examen> listExamen;

    public ArrayList<Examen> getListExamen() {
        return listExamen;
    }

    public void setListExamen(ArrayList<Examen> listExamen) {
        this.listExamen = listExamen;
    }

    public void exporter() {
    }

}
