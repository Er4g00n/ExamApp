package etudiant;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import promotion.Promotion;
import promotion.PromotionViewController;

public class Etudiant {
	private String nom, prenom, numEtudiant;
	private CheckBox statut;
	private Button modifier;
	
	//private static ArrayList<Etudiant> etudiants = new ArrayList<Etudiant>();
	
	public Etudiant(String num, String nom, String prenom) {
		//etudiants.add(this);
		this.numEtudiant = num;
		this.nom = nom;
		this.prenom = prenom;
		this.statut = new CheckBox();
		//this.statut.setOnAction(event -> EtudiantListeStageController.updateNumberSelectedEtudiant((Button) (this.statut.getScene().lookup("#etuDel"))));
		this.modifier = new Button("Modifier");
		this.modifier.setOnAction(new EtudiantModifierEventHandler(this));
	}

	
	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setNumEtudiant(String numEtudiant) {
		this.numEtudiant = numEtudiant;
	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getNumEtudiant() {
		return numEtudiant;
	}

	public CheckBox getStatut() {
		return statut;
	}

	public Button getModifier() {
		return modifier;
	}
//
//	public static ArrayList<Etudiant> getEtudiants() {
//		return etudiants;
//	}
}
