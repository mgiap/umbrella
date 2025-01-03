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
0.Objective:
Collect 5 raindrop tokens and reach the center of the board before the timer runs out.
1.Setup
-Place your piece at the starting point.
-Shuffle Raindrop Cards and scatter Raindrop Tokens on the board.
-Set a timer (e.g., 20 minutes).
2.How to Play
-Roll the die and move your piece.
-Collect tokens by landing on their spaces.
-Draw a Raindrop Card after each turn and follow its effect.
-Reach the center with 5 tokens before time runs out.
3.Win/Lose
-Win: Reach the center with 5 tokens before the timer ends.
-Lose: Time runs out or you fail to collect enough tokens.
-Stay dry and good luck! 🌧️
        """);
        instructionsAlert.showAndWait();
    }
}






