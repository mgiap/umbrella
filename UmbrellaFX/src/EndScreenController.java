import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class EndScreenController {

    @FXML
    private Label scoreLabel;

    @FXML
    private Label congratulationsLabel;

    private Stage stage;
    private Scene highScoreScene;

    public void setStageAndScenes(Stage stage, Scene highScoreScene) {
        this.stage = stage;
        this.highScoreScene = highScoreScene;
    }

    public void setScore(int score) {
        scoreLabel.setText("Your Score: " + score);
    }

    @FXML
    void onPlayAgainClicked(ActionEvent event) {
        try {
            // Reload IntroScene
            FXMLLoader introLoader = new FXMLLoader(getClass().getResource("/IntroScreen.fxml"));
            Parent introRoot = introLoader.load();
            Scene introScene = new Scene(introRoot);

            // Set up IntroController with access to stage and scenes
            IntroController introController = introLoader.getController();
            introController.setStage(stage);

            // Switch back to the intro scene
            stage.setScene(introScene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onViewHighScoresClicked(ActionEvent event) {
        // Switch to the high scores scene
        if (stage != null && highScoreScene != null) {
            stage.setScene(highScoreScene);
        }
    }
}