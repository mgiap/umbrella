import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


public class IntroController {

    private Stage stage; // Reference to the stage to switch scenes
    private Scene mainScene; // Reference to the main game scene

    
    public void setStageAndMainScene(Stage stage, Scene mainScene) {
        this.stage = stage;
        this.mainScene = mainScene;
        // Apply stylesheet to the main scene
        mainScene.getStylesheets().add(getClass().getResource("styles.css").toExternalForm());
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
I. Objective
- Place and manage umbrellas on the board to clear as many spaces as possible while following the rules.

II. Scoring
- Each placed umbrella = 1 point, each disappeared umbrella = 2 points.

III. Game End
- Ends when no more umbrellas can be placed. Aim for the highest score.

Enjoy and beat your high score!
        """);
        instructionsAlert.getDialogPane().setStyle("-fx-font-size: 14px; -fx-font-family: 'Times new roman'; -fx-text-fill: #333;");
        instructionsAlert.showAndWait();
    }

    @FXML
    public void onFullInstructionsClicked(ActionEvent event) {
        VBox instructionsBox = new VBox();
        instructionsBox.setStyle("-fx-padding: 20; -fx-spacing: 10; -fx-background-color: rgba(255, 255, 255, 0.8);");
        
        Label instructionsLabel = new Label("""
I. Objective
- Place and manage umbrellas on the board to clear as many spaces as possible while following the rules.

II. Setup
- Use a grid-style board (e.g., 5x5).
- Have tokens/pieces to represent umbrellas. Start with an empty board.

III. Scoring
- Each placed umbrella = 1 point.
- Each disappeared umbrella = 2 points.

IV. Game End
- Ends when no more umbrellas can be placed. Aim for the highest score.

V. Tips
- Plan for chain reactions to maximize scores.
- Avoid isolating spaces.

Enjoy and beat your high score!
        """);
        instructionsLabel.setStyle("-fx-font-size: 16px; -fx-font-family: 'Times new roman'; -fx-text-fill: #333;");
        
        instructionsBox.getChildren().add(instructionsLabel);
        
        Scene instructionsScene = new Scene(instructionsBox, 800, 600);
        Stage instructionsStage = new Stage();
        instructionsStage.setTitle("Full Instructions");
        instructionsStage.setScene(instructionsScene);
        instructionsStage.show();
    }
}