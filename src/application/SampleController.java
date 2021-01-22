package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import connexion.Login;
import javafx.scene.control.Label;
import optaplanner.Epreuve;
import salle.Salle;
import optaplanner.ExamenViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import promotion.Promotion;
import promotion.PromotionViewController;
import salle.SalleViewController;

public class SampleController implements Initializable {

	private String darktheme, lighttheme;
	private Parent root;

	@FXML
	public ToggleButton switchButton;

	@FXML
	public BorderPane globalLayout;

	@FXML
	public ToggleGroup pageGroup;

	@FXML
	public Label userEmail;

	@FXML
	public Label userType;

	Parent solveurView;
	Parent promotionView;
	Parent salleView;
	
	ExamenViewController solveurController;
	PromotionViewController promotionController;
	SalleViewController salleController;

	TableView<Epreuve> examenTable;
	TableView<Promotion> promotionTable;
	TableView<Salle> salleTable;

	public TableView<Epreuve> getExamenTable() {
		return examenTable;
	}

	public TableView<Promotion> getPromotionTable() {
		return promotionTable;
	}

	public TableView<Salle> getSalleTable() {
		return salleTable;
	}


	@Override
	public void initialize(URL url, ResourceBundle rb) {
		userEmail.setText(Login.getEmail());
		userType.setText(Login.getPersonnelType());
		try {
			FXMLLoader solveurLoader = new FXMLLoader(getClass().getResource("../optaplanner/ExamenView.fxml"));
			solveurView = solveurLoader.load();
			solveurController = solveurLoader.getController();
			examenTable = solveurController.getExamenTable();

			FXMLLoader promotionLoader = new FXMLLoader(getClass().getResource("../promotion/PromotionView.fxml"));
			promotionView = promotionLoader.load();
			promotionController = promotionLoader.getController();
			promotionTable = promotionController.getPromotionTable();

			FXMLLoader salleLoader = new FXMLLoader(getClass().getResource("../salle/SalleView.fxml"));
			salleView = salleLoader.load();
			salleController = salleLoader.getController();
			salleTable = salleController.getSalleTable();
		} catch (IOException e) {
			e.printStackTrace();
		}
		globalLayout.setCenter(solveurView);

		pageGroup.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
			if (newValue == null) {
				oldValue.setSelected(true);
			}
		});


	}

	@FXML
	private void switchToSolveurAction(ActionEvent event) {
		globalLayout.setCenter(solveurView);
	}
	@FXML
	private void switchToPromotionsAction(ActionEvent event) {
		globalLayout.setCenter(promotionView);
	}
	@FXML
	private void switchToSallesAction(ActionEvent event) {
		globalLayout.setCenter(salleView);
	}

	
	
	@FXML
	private void switchLightMode(ActionEvent event) {
		if (this.switchButton.isSelected()) {
			this.switchButton.setText("mode clair");
			root.getStylesheets().remove(lighttheme);
			root.getStylesheets().add(darktheme);
			solveurView.getStylesheets().clear();
			solveurView.getStylesheets().addAll(root.getStylesheets());
			promotionView.getStylesheets().clear();
			promotionView.getStylesheets().addAll(root.getStylesheets());
			salleView.getStylesheets().clear();
			salleView.getStylesheets().addAll(root.getStylesheets());
		}
		else {
			this.switchButton.setText("mode sombre");
			root.getStylesheets().remove(darktheme);
			root.getStylesheets().add(lighttheme);
			solveurView.getStylesheets().clear();
			solveurView.getStylesheets().addAll(root.getStylesheets());
			promotionView.getStylesheets().clear();
			promotionView.getStylesheets().addAll(root.getStylesheets());
			salleView.getStylesheets().clear();
			salleView.getStylesheets().addAll(root.getStylesheets());
		}
	}

	public void setThemes(Parent root, String darktheme, String lighttheme) {
		this.root = root;
		this.darktheme = darktheme;
		this.lighttheme = lighttheme;
		
	}

	public ToggleButton getSwitch() {
		return this.switchButton;
	}
}
