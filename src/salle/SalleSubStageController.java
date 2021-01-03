package salle;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SalleSubStageController implements Initializable {

	@FXML
	private Button validationButton;
	@FXML
	private TextField nomField;
	@FXML
	private TextField dispoField;
	@FXML
	private TextField capaciteField;

	private Salle salle;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		validationButton.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent arg0) {
				int cap = 0;
				if (capaciteField.getText().matches("\\d+")) {
					cap = Integer.parseInt(capaciteField.getText());
				}

				if (salle != null) {
					salle.setNom(nomField.getText());
					salle.setDispo(dispoField.getText());
					salle.setCapacite(cap);
				}
				else {
					new Salle(nomField.getText(), cap, dispoField.getText());
				}

				((Stage) validationButton.getScene().getWindow()).close();
			}
		});
	}


	public void setSalle(Salle s) {
		this.salle = s;
		this.nomField.setText(s.getNom());
		this.dispoField.setText(s.getDispo());
		this.capaciteField.setText(String.valueOf(s.getCapacite()));
	}

}
