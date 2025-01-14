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

            // Load MainScene
            FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("mainscene.fxml"));
            Parent mainRoot = mainLoader.load();
            Scene mainScene = new Scene(mainRoot);

            // Load InstructionScene
            FXMLLoader instructionLoader = new FXMLLoader(getClass().getResource("InstructionScreen.fxml"));
            Parent instructionRoot = instructionLoader.load();
            Scene instructionScene = new Scene(instructionRoot);

            // Set up IntroController with access to stage and main scene
            IntroController introController = introLoader.getController();
            introController.setStageAndMainScene(primaryStage, mainScene);
            introController.setInstructionScene(instructionScene);

            // Set up InstructionController with access to stage and intro scene
            InstructionController instructionController = instructionLoader.getController();
            instructionController.setStageAndIntroScene(primaryStage, introScene);

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