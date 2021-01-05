package salle;


import Abstracts.AbstractPersistable;
import Abstracts.Labeled;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import salle.SalleModifierEventHandler;
import salle.SalleViewController;
import salle.Specificite;
import salle.Type;

/**
 * Le type salle
 */
public class Salle extends AbstractPersistable implements Labeled {
	private String nom;
	private Integer capacite;

	private Type type;
	private Specificite specificite;

	private String dispo;
	private CheckBox statut;
	private Button modifier;
	private static ObservableList<salle.Salle> salles = FXCollections.observableArrayList();


	/**
	 * Instancie une nouvelle salle.
	 *
	 * @param nom         the nom
	 * @param capacite    the capacite
	 * @param type        the type
	 * @param specificite the specificite
	 */
	public Salle(String nom, Integer capacite, Type type, Specificite specificite, String dispo) {

		this.nom = nom;
		this.capacite = capacite;
		this.type = type;
		this.specificite = specificite;

		this.dispo=dispo;
		this.statut = new CheckBox();
		this.statut.setOnAction(event -> SalleViewController.updateNumberSelectedSalle((Button) (this.statut.getScene().lookup("#salleDel"))));
		this.modifier = new Button("Modifier");
		this.modifier.setOnAction(new SalleModifierEventHandler(this));
		salles.add(this);
	}

	/**
	 * Obtient nom.
	 *
	 * @param e the e
	 * @return the nom
	 */
	public String getNom(Salle e) {

		return e.getNom();
	}

	/**
	 * Obtient nom.
	 *
	 * @return the nom
	 */
	public String getNom() {

		return this.nom;
	}

	/**
	 * Definit nom.
	 *
	 * @param nom the nom
	 */
	public void setNom(String nom) {

		this.nom = nom;
	}

	/**
	 * Obtient capacite.
	 *
	 * @return the capacite
	 */
	public Integer getCapacite() {

		return this.capacite;
	}

	/**
	 * Definit capacite.
	 *
	 * @param capacite the capacite
	 */
	public void setCapacite(Integer capacite) {

		this.capacite = capacite;
	}


	/**
	 * Obtient type.
	 *
	 * @return the type
	 */
	public Type getType() {

		return this.type;
	}

	/**
	 * Definit type.
	 *
	 * @param type the type
	 */
	public void setType(Type type) {

		this.type = type;
	}

	/**
	 * Obtient specificite.
	 *
	 * @return the specificite
	 */
	public Specificite getSpecificite() {

		return this.specificite;
	}

	/**
	 * Definit specificite.
	 *
	 * @param specificite the specificite
	 */
	public void setSpecificite(Specificite specificite) {

		this.specificite = specificite;
	}

	public CheckBox getStatut() {
		return statut;
	}

	public Button getModifier() {
		return modifier;
	}

	public static ObservableList<salle.Salle> getSalles() {
		return salles;
	}

	public String getDispo() {
		return dispo;
	}

	public void setDispo(String dispo) {
		this.dispo = dispo;
	}

	@Override
	public String getLabel() {
		return null;
	}

	@Override
	public String toString() {
		return nom;
	}

}

