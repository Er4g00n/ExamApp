package examen;

import Abstracts.AbstractPersistable;
import examen.solver.CourseConflict;
import Salle.Salle;
import com.thoughtworks.xstream.annotations.XStreamConverter;
import org.optaplanner.core.api.domain.solution.PlanningEntityCollectionProperty;
import org.optaplanner.core.api.domain.solution.PlanningScore;
import org.optaplanner.core.api.domain.solution.PlanningSolution;
import org.optaplanner.core.api.domain.solution.ProblemFactCollectionProperty;
import org.optaplanner.core.api.domain.valuerange.ValueRangeProvider;
import org.optaplanner.core.api.score.buildin.hardsoft.HardSoftScore;
import org.optaplanner.persistence.xstream.api.score.buildin.hardsoft.HardSoftScoreXStreamConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * Le type Calendrier.
 * Cette classe est la Solution de Planning d'optaplanner
 */
@PlanningSolution
public class Calendrier extends AbstractPersistable {
    private String name;

    private List<Examen> courseList;
    private List<Jour> dayList;
    private List<Timeslot> timeslotList;
    private List<Periode> periodList;
    private List<Salle> roomList;

    private List<UnavailablePeriodPenalty> unavailablePeriodPenaltyList;

    private List<Epreuve> lectureList;

    @XStreamConverter(HardSoftScoreXStreamConverter.class)
    private HardSoftScore score;

    /**
     * Obtient le nom.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * D�finit le nom.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Obtient la liste des cours.
     * Propri�t� de la collection d'entit� de planification pour Optaplanner
     * @return the course list
     */
    @ProblemFactCollectionProperty
    public List<Examen> getCourseList() {
        return courseList;
    }

    /**
     * D�finit la liste des cours.
     *
     * @param courseList the course list
     */
    public void setCourseList(List<Examen> courseList) {
        this.courseList = courseList;
    }

    /**
     * Obtient la liste des jours.
     * Propri�t� de la collection d'entit� de planification pour Optaplanner
     * @return the day list
     */
    @ProblemFactCollectionProperty
    public List<Jour> getDayList() {
        return dayList;
    }

    /**
     * D�finit la liste des jours.
     *
     * @param dayList the day list
     */
    public void setDayList(List<Jour> dayList) {
        this.dayList = dayList;
    }

    /**
     * Obtient la liste des plages horaires.
     * Propri�t� de la collection d'entit� de planification pour Optaplanner
     * @return the timeslot list
     */
    @ProblemFactCollectionProperty
    public List<Timeslot> getTimeslotList() {
        return timeslotList;
    }

    /**
     * D�finit la liste des plages horaires.
     *
     * @param timeslotList the timeslot list
     */
    public void setTimeslotList(List<Timeslot> timeslotList) {
        this.timeslotList = timeslotList;
    }

    /**
     * Obtient la liste des p�riodes.
     * Fournisseur de plage de valeurs pour Optaplanner avec l'id periodRange
     * Propri�t� de la collection d'entit� de planification pour Optaplanner
     * @return the period list
     */
    @ValueRangeProvider(id = "periodRange")
    @ProblemFactCollectionProperty
    public List<Periode> getPeriodList() {
        return periodList;
    }

    /**
     * D�finit la liste des p�riodes.
     *
     * @param periodList the period list
     */
    public void setPeriodList(List<Periode> periodList) {
        this.periodList = periodList;
    }

    /**
     * Obtient la liste des salles.
     * Fournisseur de plage de valeurs pour Optaplanner avec l'id roomRange
     * Propri�t� de la collection d'entit� de planification pour Optaplanner
     * @return the room list
     */
    @ValueRangeProvider(id = "roomRange")
    @ProblemFactCollectionProperty
    public List<Salle> getRoomList() {
        return roomList;
    }

    /**
     * D�finit la liste des salles.
     *
     * @param roomList the room list
     */
    public void setRoomList(List<Salle> roomList) {
        this.roomList = roomList;
    }

    /**
     * Obtient la liste des p�nalit�s de p�riode indisponible.
     * Propri�t� de la collection d'entit� de planification pour Optaplanner
     * @return the unavailable period penalty list
     */
    @ProblemFactCollectionProperty
    public List<UnavailablePeriodPenalty> getUnavailablePeriodPenaltyList() {
        return unavailablePeriodPenaltyList;
    }

    /**
     * D�finit la liste des p�nalit�s de p�riode indisponible.
     *
     * @param unavailablePeriodPenaltyList the unavailable period penalty list
     */
    public void setUnavailablePeriodPenaltyList(List<UnavailablePeriodPenalty> unavailablePeriodPenaltyList) {
        this.unavailablePeriodPenaltyList = unavailablePeriodPenaltyList;
    }

    /**
     * Obtient la liste des epreuves.
     * Propri�t� de la collection d'entit� de planification pour Optaplanner
     * @return the lecture list
     */
    @PlanningEntityCollectionProperty
    public List<Epreuve> getLectureList() {
        return lectureList;
    }

    /**
     * D�finit la liste des epreuves.
     *
     * @param lectureList the lecture list
     */
    public void setLectureList(List<Epreuve> lectureList) {
        this.lectureList = lectureList;
    }

    /**
     * Obtient le score.
     * Il represente le score d'optaplanner
     * @return the score
     */
    @PlanningScore
    public HardSoftScore getScore() {
        return score;
    }

    /**
     * D�finit le score.
     *
     * @param score the score
     */
    public void setScore(HardSoftScore score) {
        this.score = score;
    }


    @ProblemFactCollectionProperty
    private List<CourseConflict> calculateCourseConflictList() {
        List<CourseConflict> courseConflictList = new ArrayList<>();
        for (Examen leftCourse : courseList) {
            for (Examen rightCourse : courseList) {
                if (leftCourse.getId() < rightCourse.getId()) {
                    int conflictCount = 0;
                    if (conflictCount > 0) {
                        courseConflictList.add(new CourseConflict(leftCourse, rightCourse, conflictCount));
                    }
                }
            }
        }
        return courseConflictList;
    }


}
