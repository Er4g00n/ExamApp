package Examen;

import Abstracts.AbstractPersistable;
import Examen.solver.CourseConflict;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ProblemFactCollectionProperty
    public List<Examen> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Examen> courseList) {
        this.courseList = courseList;
    }

    @ProblemFactCollectionProperty
    public List<Jour> getDayList() {
        return dayList;
    }

    public void setDayList(List<Jour> dayList) {
        this.dayList = dayList;
    }

    @ProblemFactCollectionProperty
    public List<Timeslot> getTimeslotList() {
        return timeslotList;
    }

    public void setTimeslotList(List<Timeslot> timeslotList) {
        this.timeslotList = timeslotList;
    }

    @ValueRangeProvider(id = "periodRange")
    @ProblemFactCollectionProperty
    public List<Periode> getPeriodList() {
        return periodList;
    }

    public void setPeriodList(List<Periode> periodList) {
        this.periodList = periodList;
    }

    @ValueRangeProvider(id = "roomRange")
    @ProblemFactCollectionProperty
    public List<Salle> getRoomList() {
        return roomList;
    }

    public void setRoomList(List<Salle> roomList) {
        this.roomList = roomList;
    }

    @ProblemFactCollectionProperty
    public List<UnavailablePeriodPenalty> getUnavailablePeriodPenaltyList() {
        return unavailablePeriodPenaltyList;
    }

    public void setUnavailablePeriodPenaltyList(List<UnavailablePeriodPenalty> unavailablePeriodPenaltyList) {
        this.unavailablePeriodPenaltyList = unavailablePeriodPenaltyList;
    }

    @PlanningEntityCollectionProperty
    public List<Epreuve> getLectureList() {
        return lectureList;
    }

    public void setLectureList(List<Epreuve> lectureList) {
        this.lectureList = lectureList;
    }

    @PlanningScore
    public HardSoftScore getScore() {
        return score;
    }

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
