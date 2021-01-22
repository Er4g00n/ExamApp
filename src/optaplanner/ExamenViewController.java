package optaplanner;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import salle.Salle;

public class ExamenViewController implements Initializable {

	@FXML
	public TableView<Epreuve> examenTable;
	@FXML
	private TableColumn<Epreuve, String> examenNomColumn;
	@FXML
	private TableColumn<Epreuve, String> examenDureeColumn;
	@FXML
	private TableColumn<Epreuve, Void> examenCheckColumn;
	@FXML
	private TableColumn<Epreuve, Void> examenModifColumn;
	@FXML
	public Button examenDelButton;
	@FXML
	private Button examenAddButton;
	@FXML
	private Button solve;

	@FXML
	private ProgressBar progressBar;

	private Stage subStage;

	private CheckBox examenSelectAll = new CheckBox();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		examenDelButton.setId("examDel");
		examenNomColumn.setReorderable(false);
		examenDureeColumn.setReorderable(false);
		examenCheckColumn.setReorderable(false);
		examenModifColumn.setReorderable(false);

		examenNomColumn.setCellValueFactory(new PropertyValueFactory<Epreuve, String>("nom"));
		examenDureeColumn.setCellValueFactory(new PropertyValueFactory<Epreuve, String>("duree"));
		examenModifColumn.setCellValueFactory(new PropertyValueFactory<Epreuve, Void>("modifier"));
		examenCheckColumn.setCellValueFactory(new PropertyValueFactory<Epreuve, Void>("statut"));
		examenCheckColumn.setGraphic(examenSelectAll);

		examenSelectAll.selectedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {

				for (Epreuve examen : examenTable.getItems()) {
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
		examenTable.setItems(Epreuve.getExamens());
	}

	public TableView<Epreuve> getExamenTable() {
		return examenTable;
	}

	public static void updateNumberSelectedExamen(Button del) {
		del.setText("-    Supprimer ("+Epreuve.getExamens().stream().filter(e -> e.getStatut().isSelected()).count()+")");
	}
	@FXML
	private void delButtonAction(ActionEvent event) {
		examenTable.getItems().removeIf(p -> p.getStatut().isSelected());
		updateNumberSelectedExamen(examenDelButton);
	}

	@FXML
	private void solve(ActionEvent event) {
		Initialisation init = new Initialisation();
		init.solverOn();
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

		subStage.setOnCloseRequest(
				event2 -> {
					examenTable.setItems(Epreuve.getExamens());
				}
		);
	}
}
