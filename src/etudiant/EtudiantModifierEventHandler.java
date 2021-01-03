package etudiant;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import promotion.Promotion;

public class EtudiantModifierEventHandler implements EventHandler<ActionEvent> {

	private Etudiant etudiant;
	
	public EtudiantModifierEventHandler(Etudiant etudiant) {
		this.etudiant = etudiant;
	}
	
	@Override
	public void handle(ActionEvent arg0) {

		//promotion.supprimerEtudiant(this.etudiant);
		
		//Parent root;
		try {
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("EtudiantSubStage.fxml"));
			Parent root = loader.load();
			EtudiantSubStageController controller = loader.getController();
			controller.setEtudiant(this.etudiant);
			//controller.setPromotion(this.promotion);
			//root = FXMLLoader.load(getClass().getResource("EtudiantSubStage.fxml"));
			Scene scene = new Scene(root);
			Stage subStage = new Stage();

//			((TextField) root.lookup("#etuNom")).setText(this.etudiant.getNom());
//			((TextField) root.lookup("#etuPrenom")).setText(this.etudiant.getPrenom());
//			((TextField) root.lookup("#etuNum")).setText(this.etudiant.getNumEtudiant());

			subStage.setTitle("Ajouter un étudiant");
			subStage.initModality(Modality.WINDOW_MODAL);
			subStage.initOwner(etudiant.getModifier().getScene().getWindow());
			subStage.setScene(scene);
			subStage.show();

			//subStage.setOnCloseRequest(event -> this.promotion.ajouterEtudiant(this.etudiant));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
