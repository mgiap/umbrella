import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class HighScoreController {

    @FXML
    private VBox HighScoreBackground;

    @FXML
    private Label first, second, third, fourth, fifth;

    private Stage stage;
    private Scene endScene;

    public void setStageAndEndScene(Stage stage, Scene endScene) {
        this.stage = stage;
        this.endScene = endScene;
    }

    @FXML
    public void initialize() {
        loadHighScores();
    }

    private void loadHighScores() {
        String filePath = "d:/vscode/UmbrellaFX/src/highscores.txt";
        Map<String, Integer> highScores = new TreeMap<>(Comparator.reverseOrder());

        // Read existing high scores
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(": ");
                if (parts.length == 2) {
                    String name = parts[0];
                    int score = Integer.parseInt(parts[1]);
                    highScores.put(name, score);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Sort high scores and get the top 5
        List<Map.Entry<String, Integer>> sortedScores = new ArrayList<>(highScores.entrySet());
        sortedScores.sort(Map.Entry.comparingByValue(Comparator.reverseOrder()));

        // Display the top 5 high scores or default values if not enough scores
        first.setText(sortedScores.size() > 0 ? "1st: " + sortedScores.get(0).getKey() + " - " + sortedScores.get(0).getValue() : "1st: ?");
        second.setText(sortedScores.size() > 1 ? "2nd: " + sortedScores.get(1).getKey() + " - " + sortedScores.get(1).getValue() : "2nd: ?");
        third.setText(sortedScores.size() > 2 ? "3rd: " + sortedScores.get(2).getKey() + " - " + sortedScores.get(2).getValue() : "3rd: ?");
        fourth.setText(sortedScores.size() > 3 ? "4th: " + sortedScores.get(3).getKey() + " - " + sortedScores.get(3).getValue() : "4th: ?");
        fifth.setText(sortedScores.size() > 4 ? "5th: " + sortedScores.get(4).getKey() + " - " + sortedScores.get(4).getValue() : "5th: ?");
    }

    @FXML
    void onBackClicked() {
        if (stage != null && endScene != null) {
            stage.setScene(endScene);
        }
    }
}