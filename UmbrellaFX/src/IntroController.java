import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class IntroController {

    private Stage stage; // Reference to the stage to switch scenes
    private Scene mainScene; // Reference to the main game scene
    private Scene instructionsScene; // Reference to the instructions scene

    public void setStageAndMainScene(Stage stage, Scene mainScene) {
        this.stage = stage;
        this.mainScene = mainScene;
        // Apply stylesheet to the main scene
        mainScene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
    }

    public void setInstructionScene(Scene instructionsScene) {
        this.instructionsScene = instructionsScene;
    }

    @FXML
    void onStartGameClicked(ActionEvent event) {
        // Switch to the main game scene
        if (stage != null && mainScene != null) {
            stage.setScene(mainScene);
        }
    }

    @FXML
    void onFullInstructionsClicked(ActionEvent event) {
        // Switch to the instructions scene
        if (stage != null && instructionsScene != null) {
            stage.setScene(instructionsScene);
        }
    }
}