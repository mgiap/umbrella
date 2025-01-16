import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Load IntroScene
            FXMLLoader introLoader = new FXMLLoader(getClass().getResource("IntroScreen.fxml"));
            Parent introRoot = introLoader.load();
            Scene introScene = new Scene(introRoot);

            // Set up IntroController with access to stage
            IntroController introController = introLoader.getController();
            introController.setStage(primaryStage);

            // Set initial scene to the intro scene
            primaryStage.setTitle("Umbrella Board Game");
            primaryStage.setScene(introScene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}