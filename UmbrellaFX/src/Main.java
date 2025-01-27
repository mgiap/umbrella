import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        try {
            // Load custom fonts
            Font.loadFont(getClass().getResource("/fonts/PixelifySans-Regular.ttf").toExternalForm(), 16);
            Font.loadFont(getClass().getResource("/fonts/PixelifySans-SemiBold.ttf").toExternalForm(), 16);
            Font.loadFont(getClass().getResource("/fonts/RobotoMono-Regular.ttf").toExternalForm(), 16);

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