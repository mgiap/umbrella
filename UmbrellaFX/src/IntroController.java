import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class IntroController {

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    void onStartGameClicked(ActionEvent event) {
        try {
            // Load NameScene
            FXMLLoader nameLoader = new FXMLLoader(getClass().getResource("/NameScreen.fxml"));
            Parent nameRoot = nameLoader.load();
            Scene nameScene = new Scene(nameRoot);

            // Load MainScene
            FXMLLoader mainLoader = new FXMLLoader(getClass().getResource("/mainscene.fxml"));
            Parent mainRoot = mainLoader.load();
            Scene mainScene = new Scene(mainRoot);

            // Set up NameController with access to stage, main scene, and main controller
            NameController nameController = nameLoader.getController();
            nameController.setStageAndMainScene(stage, mainScene, mainLoader.getController());

            // Set primary stage in the main controller
            Controller mainController = mainLoader.getController();
            mainController.setPrimaryStage(stage);

            // Switch to the name scene
            stage.setScene(nameScene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onFullInstructionsClicked(ActionEvent event) {
        try {
            // Load InstructionScene
            FXMLLoader instructionLoader = new FXMLLoader(getClass().getResource("/InstructionScreen.fxml"));
            Parent instructionRoot = instructionLoader.load();
            Scene instructionScene = new Scene(instructionRoot);

            // Set up InstructionController with access to stage and intro scene
            InstructionController instructionController = instructionLoader.getController();
            instructionController.setStageAndIntroScene(stage, stage.getScene());

            // Switch to the instruction scene
            stage.setScene(instructionScene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}