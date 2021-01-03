package Examen;

import Abstracts.AbstractPersistable;
import Examen.solver.LectureDifficultyWeightFactory;
import Examen.solver.PeriodStrengthWeightFactory;
import Examen.solver.RoomStrengthWeightFactory;
import Salle.Salle;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.entity.PlanningPin;
import org.optaplanner.core.api.domain.variable.PlanningVariable;


@PlanningEntity(difficultyWeightFactoryClass = LectureDifficultyWeightFactory.class)
public class Epreuve extends AbstractPersistable {

    private Examen examen;
    private int lectureIndexInCourse;
    private boolean pinned;

    // Planning variables: changes during planning, between score calculations.
    private Periode periode;
    private Salle salle;

    public Epreuve() {
    }

    public Epreuve(int id, Examen examen, Periode periode, Salle salle) {
        super(id);
        this.examen = examen;
        this.periode = periode;
        this.salle = salle;
    }

    public Examen getExamen() {
        return examen;
    }

    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    public int getLectureIndexInCourse() {
        return lectureIndexInCourse;
    }

    public void setLectureIndexInCourse(int lectureIndexInCourse) {
        this.lectureIndexInCourse = lectureIndexInCourse;
    }

    @PlanningPin
    public boolean isPinned() {
        return pinned;
    }

    public void setPinned(boolean pinned) {
        this.pinned = pinned;
    }

    @PlanningVariable(valueRangeProviderRefs = {
            "periodRange" }, strengthWeightFactoryClass = PeriodStrengthWeightFactory.class)
    public Periode getPeriode() {
        return periode;
    }

    public void setPeriode(Periode periode) {
        this.periode = periode;
    }

    @PlanningVariable(valueRangeProviderRefs = { "roomRange" }, strengthWeightFactoryClass = RoomStrengthWeightFactory.class)
    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    // ************************************************************************
    // Complex methods
    // ************************************************************************

    public int getStudentSize() {
        return examen.getStudentSize();
    }

    public Jour getJour() {
        if (periode == null) {
            return null;
        }
        return periode.getJour();
    }

    public int getTimeslotIndex() {
        if (periode == null) {
            return Integer.MIN_VALUE;
        }
        return periode.getTimeslot().getTimeslotIndex();
    }

    public String getLabel() {
        return examen.getCode() + "-" + lectureIndexInCourse;
    }

    @Override
    public String toString() {
        return examen + "-" + lectureIndexInCourse;
    }

}
