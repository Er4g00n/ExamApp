package application;

import connexion.BDD;
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.paint.Color;
import javafx.stage.StageStyle;
import javafx.util.Duration;
import optaplanner.Epreuve;
import salle.Salle;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import promotion.Promotion;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;

public class Main extends Application {
	@FXML
	private ProgressBar progressBar;

	@FXML
	private Label labelTitre;

	private FadeTransition fadeIn = new FadeTransition(
			Duration.millis(3000)
	);

	private String darktheme = getClass().getResource("darkmode.css").toExternalForm();
	private String lighttheme = getClass().getResource("lightmode.css").toExternalForm();
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		Parent root = FXMLLoader.load(getClass().getResource("../loader/SplashScreen.fxml"));
		primaryStage.setTitle("ExamApp | Connexion");
		primaryStage.setScene(new Scene(root, Color.TRANSPARENT));
		primaryStage.initStyle(StageStyle.TRANSPARENT);
		primaryStage.setResizable(false);
		primaryStage.show();


		FXMLLoader loader = new FXMLLoader(getClass().getResource("Sample.fxml"));
		Parent root2 = loader.load();
		SampleController sampleController = loader.getController();
		TableView<Epreuve> examenTable = sampleController.getExamenTable();
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
		BDD bdd = new BDD();
		launch(args);
	}


}
