package optaplanner;

import java.net.URL;
import java.util.ResourceBundle;

import connexion.BDD;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class ExamenSubStageController implements Initializable {

	@FXML
	private Button validationButton;
	@FXML
	private TextField nomField;
	@FXML
	private ChoiceBox<Object> filiereBox;
	@FXML
	private TextField dureeField;
	@FXML
	private ChoiceBox<Object> salleField;
	@FXML
	private ChoiceBox<Object> typeExamenField;
	@FXML
	private DatePicker dateField;



	private Examen examen;

	BDD bdd = new BDD();

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		filiereBox.setItems(bdd.getFiliere());
		salleField.setItems(bdd.getSalle());
		typeExamenField.setItems(bdd.getTypeExamens());


		validationButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
		public void handle(ActionEvent arg0) {
				if (examen != null) {
//					examen.setCode(nomField.getText());
//					examen.setFiliere(filiereBox.getValue());
//					examen.setDuree(dureeField.getText());
					System.out.println("Modify");
				}
				else {
					bdd.ajouterExamen(nomField.getText(), Integer.parseInt(dureeField.getText()), bdd.nomToIdSalle(String.valueOf(salleField.getValue())),
							bdd.nomToExamenType(String.valueOf(typeExamenField.getValue())), String.valueOf(dateField.getValue()), bdd.nomToIDFiliere(String.valueOf(filiereBox.getValue())));

				}
				((Stage) validationButton.getScene().getWindow()).close();
			}
		});
	}

	public void setExamen(Epreuve e) {
//		this.examen = e;
//		this.nomField.setText(e.getNom());
//		this.dureeField.setText(e.getDuree());
//		this.filiereBox.setValue(e.getFiliere());
	}

}
