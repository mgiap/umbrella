import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class EndScreenController {

    @FXML
    private Label scoreLabel;

    @FXML
    private Label congratulationsLabel;

    private Stage stage;
    private Scene mainScene;

    public void setStageAndMainScene(Stage stage, Scene mainScene) {
        this.stage = stage;
        this.mainScene = mainScene;
    }

    public void setScore(int score) {
        scoreLabel.setText("Your Score: " + score);
    }

    @FXML
    void onPlayAgainClicked(ActionEvent event) {
        // Switch back to the main game scene
        if (stage != null && mainScene != null) {
            stage.setScene(mainScene);
        }
    }
}
