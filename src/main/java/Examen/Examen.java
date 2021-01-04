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

    /**
     * Instancie un nouvel examen.
     *
     * @param id                the id
     * @param title             the title
     * @param lectureSize       the lecture size
     * @param studentSize       the student size
     * @param minWorkingDaySize the min working day size
     */
    public Examen(int id, String title, int lectureSize, int studentSize, int minWorkingDaySize) {
        super(id);
        this.title = requireNonNull(title);
        this.lectureSize = lectureSize;
        this.minWorkingDaySize = minWorkingDaySize;
        this.studentSize = studentSize;
    }

    /**
     * Instancie un nouvel examen.
     */
    public Examen() {
    }

    /**
     * Obtient le code.
     *
     * @return the code
     */
    public String getCode() {
        return title;
    }

    /**
     * Définit le code.
     *
     * @param title the title
     */
    public void setCode(String title) {
        this.title = title;
    }

    /**
     * Obtient la taille de la conférence.
     *
     * @return the lecture size
     */
    public int getLectureSize() {
        return lectureSize;
    }

    /**
     * Définit la taille de la conférence.
     *
     * @param lectureSize the lecture size
     */
    public void setLectureSize(int lectureSize) {
        this.lectureSize = lectureSize;
    }

    /**
     * Obtient la taille minimale de la journée de travail.
     *
     * @return the min working day size
     */
    public int getMinWorkingDaySize() {
        return minWorkingDaySize;
    }

    /**
     * Définit la taille minimale de la journée de travail.
     *
     * @param minWorkingDaySize the min working day size
     */
    public void setMinWorkingDaySize(int minWorkingDaySize) {
        this.minWorkingDaySize = minWorkingDaySize;
    }

    /**
     * Obtient la taille de l'étudiant.
     *
     * @return the student size
     */
    public int getStudentSize() {
        return studentSize;
    }

    /**
     * Définit la taille de l'étudiant.
     *
     * @param studentSize the student size
     */
    public void setStudentSize(int studentSize) {
        this.studentSize = studentSize;
    }

    @Override
    public String toString() {
        return title;
    }
}