package examen;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import promotion.Promotion;

public class Examen {

	private String nom, duree;
	private Promotion filiere;
	private CheckBox statut;
	private Button modifier;
	private static ObservableList<Examen> examens = FXCollections.observableArrayList();

	public Examen(String nom, Promotion filiere, String duree) {
		examens.add(this);
		this.nom = nom;
		this.filiere = filiere;
		this.duree = duree;
		this.statut = new CheckBox();
		this.statut.setOnAction(event -> ExamenViewController.updateNumberSelectedExamen((Button) (this.statut.getScene().lookup("#examDel"))));
		this.modifier = new Button("Modifier");
		this.modifier.setOnAction(new ExamenModifierEventHandler(this));
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public Promotion getFiliere() {
		return filiere;
	}


	public void setFiliere(Promotion filiere) {
		this.filiere = filiere;
	}


	public String getDuree() {
		return duree;
	}


	public void setDuree(String duree) {
		this.duree = duree;
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