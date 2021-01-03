package examen;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ExamenModifierEventHandler implements EventHandler<ActionEvent> {

	private Examen examen;

	public ExamenModifierEventHandler(Examen examen) {
		this.examen = examen;
	}

	@Override
	public void handle(ActionEvent arg0) {
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("ExamenSubStage.fxml"));
			Parent root = loader.load();
			ExamenSubStageController controller = loader.getController();
			controller.setExamen(this.examen);
			Scene scene = new Scene(root);
			Stage subStage = new Stage();

			subStage.setTitle("Ajouter un examen");
			subStage.initModality(Modality.WINDOW_MODAL);
			subStage.initOwner(examen.getModifier().getScene().getWindow());
			subStage.setScene(scene);
			subStage.show();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
