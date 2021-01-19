package loader;

import javafx.animation.FadeTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.util.Duration;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class SplashScreenController implements Initializable {

    @FXML
    private AnchorPane anchorPane;

    @FXML
    private ProgressIndicator progressIndicator1;

    @FXML
    private Label labelTitre;

    private FadeTransition fadeIn = new FadeTransition(
            Duration.millis(2000)
    );

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        fadeIn.setNode(anchorPane);
        fadeIn.setFromValue(0.0);
        fadeIn.setToValue(1.0);
        fadeIn.setCycleCount(1);
        fadeIn.setAutoReverse(false);

        anchorPane.setVisible(true);
        fadeIn.playFromStart();

        new SplashScreen().start();
    }

    class SplashScreen extends Thread{

        public void run() {
            try {
                Thread.sleep(4000);

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        Parent root = null;
                        try {
                            root = FXMLLoader.load(getClass().getResource("../connexion/Connexion.fxml"));
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                        Scene scene = new Scene(root);
                        Stage stage = new Stage();
                        stage.setScene(scene);
                        stage.show();

                        anchorPane.getScene().getWindow().hide();
                    }
                });


            } catch (InterruptedException e) {
                e.printStackTrace();

            }

        }
    }

}