package promotion;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import application.SampleController;
import connexion.BDD;
import connexion.Login;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import loader.SplashScreenController;
import notification.GestionNotification;
import org.drools.model.Model;

public class PromotionViewController implements Initializable {

	@FXML
	public BorderPane borderPane1;
	@FXML
	public TableView<Promotion> promotionTable;
	@FXML
	private TableColumn<Promotion, String> promotionIdFiliereColumn;
	@FXML
	private TableColumn<Promotion, String> promotionFiliereColumn;
	@FXML
	private TableColumn<Promotion, Integer> promotionNbEtuColumn;
	@FXML
	private TableColumn<Promotion, Void> promotionCheckColumn;
	@FXML
	private TableColumn<Promotion, Void> promotionModifColumn;
	@FXML
	public Button promotionDelButton;
	@FXML
	private Button promotionAddButton;

	private CheckBox promotionSelectAll = new CheckBox();

	BDD bdd = new BDD();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		promotionDelButton.setId("promoDel");
		promotionIdFiliereColumn.setReorderable(false);
		promotionFiliereColumn.setReorderable(false);
		promotionNbEtuColumn.setReorderable(false);
		promotionCheckColumn.setReorderable(false);
		promotionModifColumn.setReorderable(false);

		promotionIdFiliereColumn.setCellValueFactory(new PropertyValueFactory<Promotion, String>("idFiliere"));
		promotionFiliereColumn.setCellValueFactory(new PropertyValueFactory<Promotion, String>("filiere"));
		promotionNbEtuColumn.setCellValueFactory(new PropertyValueFactory<Promotion, Integer>("nbetu"));
		promotionModifColumn.setCellValueFactory(new PropertyValueFactory<Promotion, Void>("modifier"));
		promotionCheckColumn.setCellValueFactory(new PropertyValueFactory<Promotion, Void>("statut"));
		promotionCheckColumn.setGraphic(promotionSelectAll);

		promotionSelectAll.selectedProperty().addListener(new ChangeListener<Boolean>() {
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				for (Promotion promotion : promotionTable.getItems()) {
					if (newValue) {
						promotion.getStatut().setSelected(true);
					}
					else {
						promotion.getStatut().setSelected(false);
					}
				}
				updateNumberSelectedPromotion(promotionDelButton);
			}
		});
		promotionTable.setItems(Promotion.getPromotions());
	}

	// Met à jour la couleur le nombre de sélection
	public static void updateNumberSelectedPromotion(Button del) {
		long number = Promotion.getPromotions().stream().filter(e -> e.getStatut().isSelected()).count();
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
		if (Login.getIdPersonnelType() != 1 || Login.getIdPersonnelType() != 2 || Login.getIdPersonnelType() != 3){
			GestionNotification.notification("Vous n'avez pas acces à ces fonctionnalites", "WARNING", 1.0);
			return;
		}
		for (Promotion element : promotionTable.getItems()) {
			if (element.getStatut().isSelected() == true){
				bdd.supprimerPromotion(element.getFiliere());
			}
		}
		promotionTable.getItems().removeIf(p -> p.getStatut().isSelected());
		updateNumberSelectedPromotion(promotionDelButton);
	}

	@FXML
	private void addButtonAction(ActionEvent event) throws Exception {
		if (Login.getIdPersonnelType() != 1 || Login.getIdPersonnelType() != 2 || Login.getIdPersonnelType() != 3){
			GestionNotification.notification("Vous n'avez pas acces à ces fonctionnalites", "WARNING", 1.0);
			return;
		}
		//Test instaciation constructeur du controller
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("PromotionSubStage.fxml"));
		Parent root = loader.load();
		PromotionSubStageController controller = loader.getController();
		Scene scene = new Scene(root);
		Stage subStage = new Stage();
		subStage.setTitle("Ajouter une promotion");
		subStage.initModality(Modality.WINDOW_MODAL);
		subStage.initOwner(promotionAddButton.getScene().getWindow());
		subStage.setScene(scene);
		subStage.show();
		subStage.setOnCloseRequest(
				event2 -> {
					promotionTable.setItems(Promotion.getPromotions());
				}
		);
	}

	public TableView<Promotion> getPromotionTable() {
		return promotionTable;
	}

	public void setPromotionTableFromDB() {
		promotionTable.setItems(Promotion.getPromotions());
	}

	public static void tester(){

	}

}
