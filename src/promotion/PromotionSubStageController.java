package promotion;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import connexion.BDD;
import javafx.application.Platform;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import loader.SplashScreenController;
import org.drools.model.Model;
import utilisateur.Etudiant;
import utilisateur.EtudiantListeStageController;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class PromotionSubStageController implements Initializable {

	@FXML
	private Button validationButton;

	@FXML
	private TextField nomField;

	@FXML
	private TextField filiereField;

	@FXML
	private Button modifierListeEtu;

	private TableView<Etudiant> etudiantTable;
	
	private Promotion promotion;

	@Override
	public void initialize(URL url, ResourceBundle rb) {

		validationButton.setOnAction(new EventHandler<ActionEvent>() {
			BDD bdd = new BDD();
			@Override
			public void handle(ActionEvent arg0) {
				if (promotion != null) {
					promotion.setIdFiliere(nomField.getText());
					promotion.setFiliere(filiereField.getText());
					bdd.modifierPromotion(promotion.getIdFiliere(), promotion.getFiliere());
				}
				else {
					bdd.ajouterPromotion(filiereField.getText());
					new Promotion(String.valueOf(bdd.getLastIdPromotion()+1), filiereField.getText());

				}
				((Stage) validationButton.getScene().getWindow()).close();
			}
		});
	}

	public void setPromotion(Promotion p) {
		this.promotion = p;
		this.nomField.setText(p.getIdFiliere());
		this.filiereField.setText(p.getFiliere());
	}

	@FXML
	private void modifierListeEtuAction() {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../utilisateur/EtudiantListeStage.fxml"));
			Parent root = loader.load();
			EtudiantListeStageController controller = loader.getController();
			controller.setPromotion(this.promotion);
			this.etudiantTable = controller.getEtudiantTable();
			Scene scene = new Scene(root);
			Stage subStage = new Stage();

			subStage.setTitle("Modifier la liste d'étudiants");
			subStage.initModality(Modality.WINDOW_MODAL);
			subStage.initOwner(modifierListeEtu.getScene().getWindow());
			subStage.setScene(scene);
			subStage.show();
			
			subStage.focusedProperty().addListener((observable, oldValue, newValue) -> {
				if (newValue) {
					etudiantTable.refresh();
				}
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public TextField getNomField() {
		return nomField;
	}

	public TextField getFiliereField() {
		return filiereField;
	}
}
