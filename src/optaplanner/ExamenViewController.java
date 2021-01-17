package optaplanner;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ExamenViewController implements Initializable {

	@FXML
	public TableView<Examen> examenTable;
	@FXML
	private TableColumn<Examen, String> examenNomColumn;
	@FXML
	private TableColumn<Examen, String> examenFiliereColumn;
	@FXML
	private TableColumn<Examen, String> examenDureeColumn;
	@FXML
	private TableColumn<Examen, Void> examenCheckColumn;
	@FXML
	private TableColumn<Examen, Void> examenModifColumn;
	@FXML
	public Button examenDelButton;
	@FXML
	private Button examenAddButton;

	private Stage subStage;

	private CheckBox examenSelectAll = new CheckBox();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		examenDelButton.setId("examDel");
		examenNomColumn.setReorderable(false);
		examenFiliereColumn.setReorderable(false);
		examenDureeColumn.setReorderable(false);
		examenCheckColumn.setReorderable(false);
		examenModifColumn.setReorderable(false);

		examenNomColumn.setCellValueFactory(new PropertyValueFactory<Examen, String>("nom"));
		examenFiliereColumn.setCellValueFactory(new PropertyValueFactory<Examen, String>("filiere"));
		examenDureeColumn.setCellValueFactory(new PropertyValueFactory<Examen, String>("duree"));
		examenModifColumn.setCellValueFactory(new PropertyValueFactory<Examen, Void>("modifier"));
		examenCheckColumn.setCellValueFactory(new PropertyValueFactory<Examen, Void>("statut"));
		examenCheckColumn.setGraphic(examenSelectAll);

		examenSelectAll.selectedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {

				for (Examen examen : Examen.getExamens()) {
					if (newValue) {
						examen.getStatut().setSelected(true);
					}
					else {
						examen.getStatut().setSelected(false);
					}
				}
				updateNumberSelectedExamen(examenDelButton);
			}

		});

		examenTable.setItems(Examen.getExamens());


	}

	public TableView<Examen> getExamenTable() {
		return examenTable;
	}

	public static void updateNumberSelectedExamen(Button del) {
		del.setText("-    Supprimer ("+Examen.getExamens().stream().filter(e -> e.getStatut().isSelected()).count()+")");
	}
	@FXML
	private void delButtonAction(ActionEvent event) {
		examenTable.getItems().removeIf(p -> p.getStatut().isSelected());
		updateNumberSelectedExamen(examenDelButton);
	}

	@FXML
	private void addButtonAction(ActionEvent event) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("ExamenSubStage.fxml"));
		Scene scene = new Scene(root);
		subStage = new Stage();
		subStage.setTitle("Ajouter un examen");
		subStage.initModality(Modality.WINDOW_MODAL);
		subStage.initOwner(examenAddButton.getScene().getWindow());
		subStage.setScene(scene);
		subStage.show();

	}
}
