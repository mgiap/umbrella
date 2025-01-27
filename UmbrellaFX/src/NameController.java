import PlayerImplementation.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class NameController {

    @FXML
    private TextField nameTextField;

    @FXML
    private Button okButton;

    private Stage stage;
    private Scene mainScene;
    private Controller mainController;

    public void setStageAndMainScene(Stage stage, Scene mainScene, Controller mainController) {
        this.stage = stage;
        this.mainScene = mainScene;
        this.mainController = mainController;
    }

    @FXML
    public void initialize() {
        // Set the OK button to be invisible initially
        okButton.setVisible(false);

        // Add a listener to the TextField to make the OK button visible when the TextField is not empty
        nameTextField.textProperty().addListener((e, r, newValue) -> {
            okButton.setVisible(!newValue.trim().isEmpty());
        });
    }

    @FXML
    void OnOkClicked(ActionEvent event) {
        String playerName = nameTextField.getText();
        Player player = new Player(playerName);

        try {
            // Set the player in the existing mainController
            mainController.setPlayer(player);

            // Switch to the main scene
            stage.setScene(mainScene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}