import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class InstructionController {

    private Stage stage;
    private Scene introScene;

    public void setStageAndIntroScene(Stage stage, Scene introScene) {
        this.stage = stage;
        this.introScene = introScene;
    }

    @FXML
    void onBackClicked(ActionEvent event) {
        if (stage != null && introScene != null) {
            stage.setScene(introScene);
        }
    }
}