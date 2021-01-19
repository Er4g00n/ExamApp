package promotion;

import utilisateur.Etudiant;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;

public class Promotion {

	private String nom, filiere;
	private int nbetu;
	private CheckBox statut;
	private Button modifier;
	private static ObservableList<Promotion> promotions = FXCollections.observableArrayList();

	public void setEtudiants(ObservableList<Etudiant> etudiants) {
		this.etudiants = etudiants;
	}

	private ObservableList<Etudiant> etudiants;

	public ObservableList<Etudiant> getEtudiants() {
		return etudiants;
	}

	public Promotion(String name, String fil) {
		this.etudiants = FXCollections.observableArrayList();
		promotions.add(this);
		this.nbetu = 0;
		this.nom = name;
		this.filiere = fil;

//		this.statut = new CheckBox();
//		this.statut.setOnAction(event -> PromotionViewController.updateNumberSelectedPromotion((Button) (this.statut.getScene().lookup("#promoDel"))));
//		this.modifier = new Button("Modifier");
//		this.modifier.setOnAction(new PromotionModifierEventHandler(this));
	}

	//Pas utilisé
	public Promotion(String name, String fil, Etudiant... etus) {
		this(name, fil);
		for (Etudiant etudiant : etus) {
			this.ajouterEtudiant(etudiant);
		}
	}


	public void ajouterEtudiant(Etudiant e) {
		if (!this.etudiants.contains(e)) {
			this.etudiants.add(e);
			this.nbetu++;
		}

	}

	public void supprimerEtudiant(Etudiant e) {
		if (this.etudiants.contains(e)) {
			this.etudiants.remove(e);
			this.nbetu--;
		}
	}

	public static Promotion nomToPromotion(String promotionName){
		Promotion filliere = getPromotions().stream()
				.filter(fil -> promotionName.equals(fil.getNom()))
				.findAny()
				.orElse(null);
		return filliere;
	}

	@Override
	public String toString() {
		return nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getFiliere() {
		return filiere;
	}

	public void setFiliere(String filiere) {
		this.filiere = filiere;
	}

	public int getNbetu() {
		return nbetu;
	}

	public static ObservableList<Promotion> getPromotions() {
		return promotions;
	}

	public Button getModifier() {
		return modifier;
	}

	public CheckBox getStatut() {
		return statut;
	}

}