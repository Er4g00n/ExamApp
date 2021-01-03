package promotion;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import promotion.Promotion;

public class PromotionModifierEventHandler implements EventHandler<ActionEvent> {

	private Promotion promotion;

	public PromotionModifierEventHandler(Promotion promotion) {
		this.promotion = promotion;
	}

	@Override
	public void handle(ActionEvent arg0) {

		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("PromotionSubStage.fxml"));
			Parent root = loader.load();
			PromotionSubStageController controller = loader.getController();
			controller.setPromotion(this.promotion);
			Scene scene = new Scene(root);
			Stage subStage = new Stage();

			subStage.setTitle("Ajouter une promotion");
			subStage.initModality(Modality.WINDOW_MODAL);
			subStage.initOwner(promotion.getModifier().getScene().getWindow());
			subStage.setScene(scene);
			subStage.show();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
