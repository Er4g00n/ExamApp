package examen;


import abstracts.AbstractPersistable;
import examen.solver.LectureDifficultyWeightFactory;
import examen.solver.PeriodStrengthWeightFactory;
import examen.solver.RoomStrengthWeightFactory;
import salle.Salle;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import org.optaplanner.core.api.domain.entity.PlanningPin;
import org.optaplanner.core.api.domain.variable.PlanningVariable;


/**
 * Le type Epreuve.
 * Entité de planification d'Optaplanner
 */
@PlanningEntity(difficultyWeightFactoryClass = LectureDifficultyWeightFactory.class)
public class Epreuve extends AbstractPersistable {

    private Examen examen;
    private int lectureIndexInCourse;
    private boolean pinned;

    // Planning variables: changes during planning, between score calculations.
    private Periode periode;
    private Salle salle;

    /**
     * Instancie une nouvelle Epreuve.
     */
    public Epreuve() {
    }

    /**
     * Instancie une nouvelle Epreuve.
     *
     * @param id      the id
     * @param examen  the examen
     * @param periode the periode
     * @param salle   the salle
     */
    public Epreuve(int id, Examen examen, Periode periode, Salle salle) {
        super(id);
        this.examen = examen;
        this.periode = periode;
        this.salle = salle;
    }

    /**
     * Obtient un examen.
     *
     * @return the examen
     */
    public Examen getExamen() {
        return examen;
    }

    /**
     * Définit l'examen.
     *
     * @param examen the examen
     */
    public void setExamen(Examen examen) {
        this.examen = examen;
    }

    /**
     * Obtient l'index des Examens dans le Epreuve.
     *
     * @return the lecture index in course
     */
    public int getLectureIndexInCourse() {
        return lectureIndexInCourse;
    }

    /**
     * Definit l'index des Examens dans le Epreuve.
     *
     * @param lectureIndexInCourse the lecture index in course
     */
    public void setLectureIndexInCourse(int lectureIndexInCourse) {
        this.lectureIndexInCourse = lectureIndexInCourse;
    }

    /**
     * Est une valeur booléenne épinglée.
     * Broche de planification d'optaplanner
     * @return the boolean
     */
    @PlanningPin
    public boolean isPinned() {
        return pinned;
    }

    /**
     * Definit l'épingle
     *
     * @param pinned the pinned
     */
    public void setPinned(boolean pinned) {
        this.pinned = pinned;
    }

    /**
     * Obtient la periode.
     * Variable du planning d'optaplanner avec l'id periodRange
     * @return the periode
     */
    @PlanningVariable(valueRangeProviderRefs = {
            "periodRange"}, strengthWeightFactoryClass = PeriodStrengthWeightFactory.class)
    public Periode getPeriode() {
        return periode;
    }

    /**
     * Définit la période.
     *
     * @param periode the periode
     */
    public void setPeriode(Periode periode) {
        this.periode = periode;
    }

    /**
     * Obtient la salle.
     *
     * @return the salle
     */
    @PlanningVariable(valueRangeProviderRefs = {"roomRange"}, strengthWeightFactoryClass = RoomStrengthWeightFactory.class)
    public Salle getSalle() {
        return salle;
    }

    /**
     * Definit la salle
     *
     * @param salle the salle
     */
    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    /**
     * Obtient la taille de la liste étudiant.
     *
     * @return the student size
     */
    public int getStudentSize() {
        return examen.getStudentSize();
    }

    /**
     * Obtient jour.
     *
     * @return the jour
     */
    public Jour getJour() {
        if (periode == null) {
            return null;
        }
        return periode.getJour();
    }

    /**
     * Obtient l'index des plages horaires.
     *
     * @return the timeslot index
     */
    public int getTimeslotIndex() {
        if (periode == null) {
            return Integer.MIN_VALUE;
        }
        return periode.getTimeslot().getTimeslotIndex();
    }

    /**
     * Obtient l'étiquette.
     *
     * @return the label
     */
    public String getLabel() {
        return examen.getCode() + "-" + lectureIndexInCourse;
    }

    @Override
    public String toString() {
        return examen + "-" + lectureIndexInCourse;
    }

}
