package promotion;

import java.net.URL;
import java.util.ResourceBundle;

import connexion.BDD;
import javafx.animation.FadeTransition;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
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
import javafx.util.Duration;

public class PromotionViewController implements Initializable {

	@FXML
	public BorderPane borderPanePromotions;
	@FXML
	public TableView<Promotion> promotionTable;
	@FXML
	private TableColumn<Promotion, String> promotionNomColumn;
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


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		promotionDelButton.setId("promoDel");
		promotionNomColumn.setReorderable(false);
		promotionFiliereColumn.setReorderable(false);
		promotionNbEtuColumn.setReorderable(false);
		promotionCheckColumn.setReorderable(false);
		promotionModifColumn.setReorderable(false);

		promotionNomColumn.setCellValueFactory(new PropertyValueFactory<Promotion, String>("nom"));
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
		for (Promotion element : promotionTable.getItems()) {
			BDD bdd = new BDD();
			if (element.getStatut().isSelected() == true){
				bdd.supprimerPromotion(element.getFiliere());
			}

		}
		promotionTable.getItems().removeIf(p -> p.getStatut().isSelected());


		updateNumberSelectedPromotion(promotionDelButton);
	}

	@FXML
	private void addButtonAction(ActionEvent event) throws Exception {
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

	}

	public TableView<Promotion> getPromotionTable() {
		return promotionTable;
	}
}
