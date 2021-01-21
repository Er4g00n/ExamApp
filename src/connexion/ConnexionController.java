package connexion;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Duration;
import notification.GestionNotification;
import tray.animations.AnimationType;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;


import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;

public class ConnexionController implements Initializable{

    @FXML
    private TextField txtEmail;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Label userEmail;

    @FXML
    public void login(ActionEvent actionEvent) {
        if (txtEmail.getText().toString().equals("") || txtPassword.getText().toString().equals("")){
            GestionNotification.notification("Vous devez remplir tous les champs !", "WARNING", 1.0);
            return;
        }

        try {
            BDD bdd = new BDD();
            boolean checkLogin = bdd.checkLogin(txtEmail.getText().toString(), txtPassword.getText().toString());
            txtPassword.setText("");
            if (checkLogin != true){
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("../application/Sample.fxml"));
                    Stage stage = (Stage) (Stage)((Node)actionEvent.getSource()).getScene().getWindow();
                    Scene scene = new Scene(loader.load());
                    stage.setScene(scene);

                }catch (IOException io){
                    io.printStackTrace();
                }
            }


        } catch (Exception e){

        }

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

}
