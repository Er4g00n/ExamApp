package examen;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import etudiant.Etudiant;
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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
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
	
	private Stage primaryStage;
	
	@FXML
	private TextField path;
	@FXML
	private Button fileButton;
	private DirectoryChooser directoryChooser;
	
	@FXML
	private Label nbExamenLabel;
	@FXML
	private Label nbEtuLabel;
	
	private CheckBox examenSelectAll = new CheckBox();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		
		nbExamenLabel.setText(String.valueOf(Examen.getExamens().size()));
		nbEtuLabel.setText(String.valueOf(Etudiant.getEtudiants().size()));
		
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
		
		directoryChooser = new DirectoryChooser();
	
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
		nbExamenLabel.setText(String.valueOf(Examen.getExamens().size()));
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
	
	@FXML
	private void fileButtonAction(ActionEvent event) {
		File file = this.directoryChooser.showDialog(primaryStage);
		if (file != null) {
			path.setText(file.getPath());
		}
		
	}

	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}

	public Label getNbExamenLabel() {
		return this.nbExamenLabel;
	}

	public Label getNbEtuLabel() {
		return this.nbEtuLabel;
	}
}
