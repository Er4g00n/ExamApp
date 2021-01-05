package examen;

import abstracts.AbstractPersistable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import org.optaplanner.core.api.domain.entity.PlanningEntity;
import static java.util.Objects.requireNonNull;

@PlanningEntity
public class Examen extends AbstractPersistable {

	private CheckBox statut;
	private Button modifier;
	private static ObservableList<Examen> examens = FXCollections.observableArrayList();

	private String title;
	private Boolean estFini;
	private int studentSize;
	private int minWorkingDaySize;

	/**
	 * Instancie un nouvel examen.
	 *
	 * @param id                the id
	 * @param title             the title
	 * @param studentSize       the student size
	 * @param minWorkingDaySize the min working day size
	 */
	public Examen(int id, String title, int studentSize, int minWorkingDaySize) {
		super(id);
		this.title = requireNonNull(title);
		this.minWorkingDaySize = minWorkingDaySize;
		this.studentSize = studentSize;

		examens.add(this);
		this.statut = new CheckBox();
		this.statut.setOnAction(event -> ExamenViewController.updateNumberSelectedExamen((Button) (this.statut.getScene().lookup("#examDel"))));
		this.modifier = new Button("Modifier");
		this.modifier.setOnAction(new ExamenModifierEventHandler(this));
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
	 * DÃ©finit le code.
	 *
	 * @param title the title
	 */
	public void setCode(String title) {
		this.title = title;
	}

	/**
	 * Obtient la taille minimale de la journÃ©e de travail.
	 *
	 * @return the min working day size
	 */
	public int getMinWorkingDaySize() {
		return minWorkingDaySize;
	}

	/**
	 * DÃ©finit la taille minimale de la journÃ©e de travail.
	 *
	 * @param minWorkingDaySize the min working day size
	 */
	public void setMinWorkingDaySize(int minWorkingDaySize) {
		this.minWorkingDaySize = minWorkingDaySize;
	}

	/**
	 * Obtient la taille de l'Ã©tudiant.
	 *
	 * @return the student size
	 */
	public int getStudentSize() {
		return studentSize;
	}

	/**
	 * DÃ©finit la taille de l'Ã©tudiant.
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


	public CheckBox getStatut() {
		return statut;
	}


	public void setStatut(CheckBox statut) {
		this.statut = statut;
	}


	public Button getModifier() {
		return modifier;
	}


	public void setModifier(Button modifier) {
		this.modifier = modifier;
	}


	public static ObservableList<Examen> getExamens() {
		return examens;
	}

}