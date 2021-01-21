package salle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;

public class SalleModifierEventHandler implements EventHandler<ActionEvent> {

    private final Salle salle;

    public SalleModifierEventHandler(Salle salle) {
        this.salle = salle;
    }

    @Override
    public void handle(ActionEvent arg0) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("SalleSubStage.fxml"));
            Parent root = loader.load();
            SalleSubStageController controller = loader.getController();
            controller.setSalle(this.salle);
            Scene scene = new Scene(root);
            Stage subStage = new Stage();

            subStage.setTitle("Ajouter une salle");
            subStage.initModality(Modality.WINDOW_MODAL);
            subStage.initOwner(salle.getModifier().getScene().getWindow());
            subStage.setScene(scene);
            subStage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
