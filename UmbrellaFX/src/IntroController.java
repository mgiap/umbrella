import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class IntroController {

    private Stage stage; // Reference to the stage to switch scenes
    private Scene mainScene; // Reference to the main game scene

    public void setStageAndMainScene(Stage stage, Scene mainScene) {
        this.stage = stage;
        this.mainScene = mainScene;
    }

    @FXML
    void onStartGameClicked(ActionEvent event) {
        // Switch to the main game scene
        if (stage != null && mainScene != null) {
            stage.setScene(mainScene);
        }
    }

    @FXML
    public void onInstructionsClicked(ActionEvent event) {
        Alert instructionsAlert = new Alert(AlertType.INFORMATION);
        instructionsAlert.setTitle("Game Instructions");
        instructionsAlert.setHeaderText("How to Play Umbrella Board Game");
        instructionsAlert.setContentText("""
            1. Each player starts with tokens of different colors.
            2. Push tokens into rows or columns to create patterns.
            3. Aim to score points by aligning tokens in specific arrangements.
            4. Use strategy to block your opponents and maximize your score.
            5. The player with the highest score at the end wins!

            Good luck and have fun!
        """);
        instructionsAlert.showAndWait();
    }
}






