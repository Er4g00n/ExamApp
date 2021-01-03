package application;

import etudiant.Etudiant;
import examen.Examen;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import promotion.Promotion;
import salle.Salle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Labeled;
import javafx.scene.control.TableView;


public class Main extends Application {

	private String darktheme = getClass().getResource("darkmode.css").toExternalForm();
	private String lighttheme = getClass().getResource("lightmode.css").toExternalForm();
	private Label nbExamenLabel;
	private Label nbEtuLabel;
	
	@Override
	public void start(Stage primaryStage) throws Exception {


		FXMLLoader loader = new FXMLLoader(getClass().getResource("Sample.fxml"));
		Parent root = loader.load();
		SampleController sampleController = loader.getController();
		TableView<Examen> examenTable = sampleController.getExamenTable();
		TableView<Promotion> promotionTable = sampleController.getPromotionTable();
		TableView<Salle> salleTable = sampleController.getSalleTable();

		sampleController.setPrimaryStage(primaryStage);
		sampleController.setThemes(root, darktheme, lighttheme);
		
		Scene scene = new Scene(root);
		primaryStage.setTitle("Examapp");
		primaryStage.setScene(scene);
		primaryStage.show();

		nbExamenLabel = sampleController.getNbExamenLabel();
		nbEtuLabel = sampleController.getNbEtuLabel();

		primaryStage.focusedProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue) {
				examenTable.refresh();
				promotionTable.refresh();
				salleTable.refresh();
				nbExamenLabel.setText(String.valueOf(Examen.getExamens().size()));
				nbEtuLabel.setText(String.valueOf(Etudiant.getEtudiants().size()));
			}
		});

	}

	public static void main(String[] args) {

		Promotion promo_a = new Promotion("L1Info", "L1 : Informatique");
		Promotion promo_b = new Promotion("L3Info", "L3 : Informatique");
		Promotion promo_c = new Promotion("L2Math", "L3 : Informatique");
		Promotion promo_d = new Promotion("L1Math", "L3 : Informatique");
		new Examen("info",promo_a,"dispo");
		new Examen("abcd",promo_a,"pas dispo");
		new Examen("bureau",promo_b,"pas dispo");
		new Examen("info",promo_a,"dispo");
		new Examen("abcd",promo_b,"pas dispo");
		new Examen("bureau",promo_a,"pas dispo");
		new Examen("info",promo_b,"dispo");
		new Examen("abcd",promo_b,"pas dispo");
		new Examen("bureau",promo_b,"pas dispo");
		new Examen("info",promo_b,"dispo");
		new Examen("abcd",promo_a,"pas dispo");
		new Examen("bureau",promo_a,"pas dispo");
		new Salle("s1", 210, "pas de données");
		new Salle("s2", 50, "pas de données");
		new Salle("s3", 100, "pas de données");
		new Salle("s4", 12, "pas de données");
		Etudiant a = new Etudiant("21902170", "Quelque", "un");
		Etudiant b = new Etudiant("21901984", "Quelque2", "deux");
		Etudiant c = new Etudiant("21702310", "Quelque3", "trois");
		Etudiant d = new Etudiant("21802014", "Quelque4", "quatre");
		promo_a.ajouterEtudiant(a);
		promo_a.ajouterEtudiant(b);
		promo_a.ajouterEtudiant(c);
		promo_a.ajouterEtudiant(d);
		promo_b.ajouterEtudiant(a);
		promo_b.ajouterEtudiant(b);
		promo_b.ajouterEtudiant(c);
		promo_c.ajouterEtudiant(c);
		promo_d.ajouterEtudiant(a);
		promo_d.ajouterEtudiant(d);

		launch(args);
	}
}
