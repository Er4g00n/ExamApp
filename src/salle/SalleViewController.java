package salle;

import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import connexion.BDD;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import optaplanner.Epreuve;
import promotion.Promotion;

public class SalleViewController implements Initializable {

	@FXML
	public TableView<Salle> salleTable;
	@FXML
	private TableColumn<Salle, String> salleNomColumn;
	@FXML
	private TableColumn<Salle, String> salleTypeColumn;
	@FXML
	private TableColumn<Salle, Integer> salleCapaciteColumn;
	@FXML
	private TableColumn<Salle, Void> salleCheckColumn;
	@FXML
	private TableColumn<Salle, Void> salleModifColumn;
	@FXML
	public Button salleDelButton;
	@FXML
	private Button salleAddButton;

	private CheckBox salleSelectAll = new CheckBox();


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		salleDelButton.setId("salleDel");
		salleNomColumn.setReorderable(false);
		salleTypeColumn.setReorderable(false);
		salleCapaciteColumn.setReorderable(false);
		salleCheckColumn.setReorderable(false);
		salleModifColumn.setReorderable(false);

		salleNomColumn.setCellValueFactory(new PropertyValueFactory<Salle, String>("nom"));
		salleTypeColumn.setCellValueFactory(new PropertyValueFactory<Salle, String>("type"));
		salleCapaciteColumn.setCellValueFactory(new PropertyValueFactory<Salle, Integer>("capacite"));
		salleModifColumn.setCellValueFactory(new PropertyValueFactory<Salle, Void>("modifier"));
		salleCheckColumn.setCellValueFactory(new PropertyValueFactory<Salle, Void>("statut"));
		salleCheckColumn.setGraphic(salleSelectAll);

		salleSelectAll.selectedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {

				for (Salle salle : salleTable.getItems()) {
					if (newValue) {
						salle.getStatut().setSelected(true);
					}
					else {
						salle.getStatut().setSelected(false);
					}
				}
				updateNumberSelectedSalle(salleDelButton);
			}

		});

		salleTable.setItems(Salle.getSalles());
	}

	// Met à jour la couleur le nombre de sélection
	public static void updateNumberSelectedSalle(Button del) {
		long number = Salle.getSalles().stream().filter(e -> e.getStatut().isSelected()).count();
		if (number > 0){
			del.setStyle("-fx-opacity: 1;");
		}
		else {
			del.setStyle("-fx-opacity: 0.5;");
		}
		del.setText("-    Supprimer ("+number+")");
	}
	@FXML
	private void delButtonAction(ActionEvent event) {
		BDD bdd = new BDD();
		for (Salle element : salleTable.getItems()) {
			if (element.getStatut().isSelected() == true){
				bdd.supprimerSalle(element.getNom());
			}
		}
		salleTable.getItems().removeIf(p -> p.getStatut().isSelected());
		updateNumberSelectedSalle(salleDelButton);
	}

	@FXML
	private void addButtonAction(ActionEvent event) throws Exception {

		SalleSubStageController salleSubStageController = new SalleSubStageController();
		for (Salle element : salleTable.getItems()) {
			if (element.getStatut().isSelected() == true){
				salleSubStageController.initializeTypeSalle(element.getType());
			}
		}

		Parent root = FXMLLoader.load(getClass().getResource("SalleSubStage.fxml"));
		Scene scene = new Scene(root);
		Stage subStage = new Stage();
		subStage.setTitle("Ajouter une salle");
		subStage.initModality(Modality.WINDOW_MODAL);
		subStage.initOwner(salleAddButton.getScene().getWindow());
		subStage.setScene(scene);
		subStage.show();

	}

	public TableView<Salle> getSalleTable() {
		return salleTable;
	}

}
