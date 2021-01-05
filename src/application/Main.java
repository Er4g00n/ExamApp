package application;

import connexion.BDD;
import etudiant.Etudiant;
import examen.Examen;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import promotion.Promotion;
import salle.Salle;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;

import java.util.ArrayList;
import java.util.HashMap;


public class Main extends Application {

	private String darktheme = getClass().getResource("darkmode.css").toExternalForm();
	private String lighttheme = getClass().getResource("lightmode.css").toExternalForm();
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("../connexion/Connexion.fxml"));
		primaryStage.setTitle("ExamApp | Connexion");
		primaryStage.setScene(new Scene(root));
		primaryStage.setResizable(false);
		primaryStage.show();


		FXMLLoader loader = new FXMLLoader(getClass().getResource("Sample.fxml"));
		Parent root2 = loader.load();
		SampleController sampleController = loader.getController();
		TableView<Examen> examenTable = sampleController.getExamenTable();
		TableView<Promotion> promotionTable = sampleController.getPromotionTable();
		TableView<Salle> salleTable = sampleController.getSalleTable();

		sampleController.setThemes(root, darktheme, lighttheme);

		Scene scene = new Scene(root2);
		primaryStage.setTitle("ExamApp");

		primaryStage.focusedProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue) {
				examenTable.refresh();
				promotionTable.refresh();
				salleTable.refresh();
			}
		});

	}

	public static void main(String[] args) {
		BDD loadDataBDD = new BDD();
		loadDataBDD.loadPromotions();
		loadDataBDD.loadSalles();
		loadDataBDD.loadEtudiants();
		loadDataBDD.loadExamens();

		launch(args);
	}


}
