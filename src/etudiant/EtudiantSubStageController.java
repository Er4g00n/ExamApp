package etudiant;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import promotion.Promotion;

public class EtudiantSubStageController implements Initializable {

	@FXML
	private Button validationButton;
	@FXML
	private TextField nomField;
	@FXML
	private TextField PrenomField;
	@FXML
	private TextField numEtuField;

	private Etudiant etudiant;
	private Promotion promotion;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		validationButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {

				if (etudiant != null) {
					etudiant.setNom(nomField.getText());
					etudiant.setPrenom(PrenomField.getText());
					etudiant.setNumEtudiant(numEtuField.getText());
					System.out.println("Modifier");
				}
				else {
					Etudiant e = new Etudiant(numEtuField.getText(), nomField.getText(), PrenomField.getText());
					promotion.ajouterEtudiant(e);
					System.out.println("Créer");
				}

				((Stage) validationButton.getScene().getWindow()).close();
			}
		});
	}


	public void setEtudiant(Etudiant etu) {
		this.etudiant = etu;
		this.nomField.setText(etu.getNom());
		this.PrenomField.setText(etu.getPrenom());
		this.numEtuField.setText(etu.getNumEtudiant());

	}
	
	public void setPromotion(Promotion p) {
		this.promotion = p;
	}

}
