package etudiant;

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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import promotion.Promotion;

public class EtudiantListeStageController implements Initializable {

	@FXML
	public TableView<Etudiant> etudiantTable;
	@FXML
	private TableColumn<Etudiant, String> etudiantNomColumn;
	@FXML
	private TableColumn<Etudiant, String> etudiantPrenomColumn;
	@FXML
	private TableColumn<Etudiant, Integer> etudiantNumEtuColumn;
	@FXML
	private TableColumn<Etudiant, Void> etudiantCheckColumn;
	@FXML
	private TableColumn<Etudiant, Void> etudiantModifColumn;
	@FXML
	public Button etudiantDelButton;
	@FXML
	private Button etudiantAddButton;
	@FXML
	private Label nomPromo;
	@FXML
	private Button terminer;
	
	private CheckBox etudiantSelectAll = new CheckBox();
	
	private Promotion cPromotion;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
		//cPromotion.getEtudiants().forEach(e -> e.setcPromotion(cPromotion));
		
		nomPromo.setId("nomPromo");
		
		etudiantDelButton.setId("etuDel");
		etudiantNomColumn.setReorderable(false);
		etudiantPrenomColumn.setReorderable(false);
		etudiantNumEtuColumn.setReorderable(false);
		etudiantCheckColumn.setReorderable(false);
		etudiantModifColumn.setReorderable(false);
		
		etudiantNomColumn.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("nom"));
		etudiantPrenomColumn.setCellValueFactory(new PropertyValueFactory<Etudiant, String>("prenom"));
		etudiantNumEtuColumn.setCellValueFactory(new PropertyValueFactory<Etudiant, Integer>("numEtudiant"));
		etudiantModifColumn.setCellValueFactory(new PropertyValueFactory<Etudiant, Void>("modifier"));
		etudiantCheckColumn.setCellValueFactory(new PropertyValueFactory<Etudiant, Void>("statut"));
		etudiantCheckColumn.setGraphic(etudiantSelectAll);
		
		etudiantSelectAll.selectedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				for (Etudiant etudiant : etudiantTable.getItems()) {
					if (newValue) {
						etudiant.getStatut().setSelected(true);
					}
					else {
						etudiant.getStatut().setSelected(false);
					}
				}
				//updateNumberSelectedEtudiant(etudiantDelButton, cPromotion);
			}
			
		});
	
		
	}
	
	//supprimer
	public static void updateNumberSelectedEtudiant(Button del, Promotion promo) {
		del.setText("-    Supprimer ("+promo.getEtudiants().stream().filter(e -> e.getStatut().isSelected()).count()+")");
	}
	
	
	@FXML
	private void delButtonAction(ActionEvent event) {
		etudiantTable.getItems().removeIf(e -> e.getStatut().isSelected());
		//updateNumberSelectedEtudiant(etudiantDelButton, cPromotion);
	}
	
	@FXML
	private void addButtonAction(ActionEvent event) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("EtudiantSubStage.fxml"));
		Parent root = loader.load();
		EtudiantSubStageController controller = loader.getController();
		controller.setPromotion(this.cPromotion);
		//controller.setPromotion(this.promotion);
		//Parent root = FXMLLoader.load(getClass().getResource("EtudiantSubStage.fxml"));
		Scene scene = new Scene(root);
		Stage subStage = new Stage();
		subStage.setTitle("Ajouter un etudiant");
		subStage.initModality(Modality.WINDOW_MODAL);
		subStage.initOwner(etudiantAddButton.getScene().getWindow());
		subStage.setScene(scene);
		subStage.show();
		
	}
	
	@FXML
	private void terminerAction(ActionEvent event) {
		((Stage) terminer.getScene().getWindow()).close();
	}

	public void setPromotion(Promotion p) {
		this.cPromotion = p;
		this.nomPromo.setText(cPromotion.getNom());
		etudiantTable.setItems(cPromotion.getEtudiants());
		
	}

	public TableView<Etudiant> getEtudiantTable() {
		return this.etudiantTable;
	}
}
