package salle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class Salle {

	private int capacite;
	private String nom,dispo;
	private CheckBox statut;
	private Button modifier;
	private static ObservableList<Salle> salles = FXCollections.observableArrayList();

	public Salle(String nom, int cap, String dispo) {
		salles.add(this);
		this.capacite = cap;
		this.nom = nom;
		this.dispo=dispo;
		this.statut = new CheckBox();
		this.statut.setOnAction(event -> SalleViewController.updateNumberSelectedSalle((Button) (this.statut.getScene().lookup("#salleDel"))));
		this.modifier = new Button("Modifier");
		this.modifier.setOnAction(new SalleModifierEventHandler(this));
	}

	public CheckBox getStatut() {
		return statut;
	}

	public Button getModifier() {
		return modifier;
	}

	public static ObservableList<Salle> getSalles() {
		return salles;
	}

	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getDispo() {
		return dispo;
	}

	public void setDispo(String dispo) {
		this.dispo = dispo;
	}

}