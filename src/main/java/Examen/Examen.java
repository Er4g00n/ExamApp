package Examen;

import Abstracts.AbstractPersistable;
import org.optaplanner.core.api.domain.entity.PlanningEntity;


import static java.util.Objects.requireNonNull;

/**
 * Classe Examen.
 * Permet l'utilisation de l'objet examen
 * Cet objet a pour role de définir les examens pour le solveur (OptaPlanner)
 */
@PlanningEntity
public class Examen extends AbstractPersistable {

    private String title;
    private Boolean estFini;
    private int studentSize;
    private int lectureSize;
    private int minWorkingDaySize;

    public Examen(int id, String title, int lectureSize, int studentSize, int minWorkingDaySize) {
        super(id);
        this.title = requireNonNull(title);
        this.lectureSize = lectureSize;
        this.minWorkingDaySize = minWorkingDaySize;
        this.studentSize = studentSize;
    }

    public Examen() {
    }

    public String getCode() {
        return title;
    }

    public void setCode(String title) {
        this.title = title;
    }

    public int getLectureSize() {
        return lectureSize;
    }

    public void setLectureSize(int lectureSize) {
        this.lectureSize = lectureSize;
    }

    public int getMinWorkingDaySize() {
        return minWorkingDaySize;
    }

    public void setMinWorkingDaySize(int minWorkingDaySize) {
        this.minWorkingDaySize = minWorkingDaySize;
    }

    public int getStudentSize() {
        return studentSize;
    }

    public void setStudentSize(int studentSize) {
        this.studentSize = studentSize;
    }

    @Override
    public String toString() {
        return title;
    }
}