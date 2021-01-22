package connexion;

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
import org.mindrot.jbcrypt.BCrypt;
import promotion.Promotion;

import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class EnregistrementController implements Initializable {

    @FXML
    private TextField nomField;

    @FXML
    private TextField prenomField;

    @FXML
    private TextField emailField;

    @FXML
    private TextField mdpField;

    @FXML
    private Button validationButton;

    @FXML
    private TextField typePersonnelField;

    BDD bdd = new BDD();

    @FXML
    public void register(){
        bdd.ajouterUtilisateur(nomField.getText(), prenomField.getText(), emailField.getText(), mdpField.getText(), typePersonnelField.getText());
        ((Stage) validationButton.getScene().getWindow()).close();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
