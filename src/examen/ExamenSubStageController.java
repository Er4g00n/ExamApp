package examen;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import promotion.Promotion;

public class ExamenSubStageController implements Initializable {

	@FXML
	private Button validationButton;
	@FXML
	private TextField nomField;
	@FXML
	private TextField dureeField;
	@FXML
	private ChoiceBox<Promotion> filiereBox;

	private Examen examen;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		filiereBox.setItems(Promotion.getPromotions());
		validationButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				if (examen != null) {
					examen.setCode(nomField.getText());
					//examen.setFiliere(filiereBox.getValue());
					//examen.setDuree(dureeField.getText());
				}
				else {
					new Examen(nomField.getText(), filiereBox.getValue(), dureeField.getText());
				}
				((Stage) validationButton.getScene().getWindow()).close();
			}
		});
	}

	public void setExamen(Examen e) {
		this.examen = e;
		this.nomField.setText(e.getNom());
		this.dureeField.setText(e.getDuree());
		this.filiereBox.setValue(e.getFiliere());
	}

}
