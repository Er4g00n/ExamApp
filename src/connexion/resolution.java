package connexion;

import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class resolution extends Application {

    @Override
    public void start(Stage primaryStage) {
        //Get primary screen bounds
        Rectangle2D screenBounds = Screen.getPrimary().getBounds();
        System.out.println(screenBounds.getHeight());
        System.out.println(screenBounds.getWidth());
        System.exit(0);
    }
}