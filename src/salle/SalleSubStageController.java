package salle;

import java.net.URL;
import java.util.ResourceBundle;

import connexion.BDD;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SalleSubStageController implements Initializable {

	@FXML
	private Button validationButton;
	@FXML
	private TextField nomField;
	@FXML
	private ChoiceBox typeField;
	@FXML
	private TextField capaciteField;

	private Salle salle;

	ObservableList<Object> options;

	private void loadTypeSalle() {
		BDD bdd = new BDD();
		options = bdd.getTypeSalle();
	}

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		loadTypeSalle();
		typeField.setItems(options);

		validationButton.setOnAction(new EventHandler<ActionEvent>() {
			BDD bdd = new BDD();
			@Override
			public void handle(ActionEvent arg0) {

				int cap = 0;
				if (capaciteField.getText().matches("\\d+")) {
					cap = Integer.parseInt(capaciteField.getText());
				}

				if (salle != null) {
					salle.setNom(nomField.getText());
					salle.setCapacite(cap);
					int idType = bdd.getIdTypeFromlibelle(salle.getNom());
					int idSalle = bdd.getIdFromSalle(salle.getNom());
					bdd.modifierSalle(salle.getNom(), salle.getCapacite(), idType, idSalle);
				}
				else {
					/*
					* Modification des parametres
					*/
					new Salle(nomField.getText(), cap, (String) typeField.getValue());
					int idType = bdd.getIdTypeFromlibelle((String) typeField.getValue());
					bdd.ajouterSalle(nomField.getText(), cap, idType);
				}

				((Stage) validationButton.getScene().getWindow()).close();
			}
		});
	}


	public void setSalle(Salle s) {
		this.salle = s;
		this.nomField.setText(s.getNom());
		this.capaciteField.setText(String.valueOf(s.getCapacite()));
	}

	public void initializeTypeSalle(String type) {
		typeField.setValue(type);
	}
}
