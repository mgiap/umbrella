import javafx.util.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import PlayerImplementation.PatternQuery;
import PlayerImplementation.Player;
import PlayerImplementation.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;

public class Controller {

    @FXML
    private ImageView tok00, tok01, tok02, tok03, tok10, tok11, tok12, tok13, tok20, tok21, tok22, tok23, tok30, tok31, tok32, tok33;

    @FXML
    private ImageView token00, token01, token02, token10, token11, token12, token20, token21, token22, token30, token31, token32;

    @FXML
    private VBox topRedToken, topBlueToken, topGreenToken, topYellowToken;
    @FXML
    private VBox leftRedToken, leftBlueToken, leftGreenToken, leftYellowToken;
    @FXML
    private VBox rightRedToken, rightBlueToken, rightGreenToken, rightYellowToken;
    @FXML
    private VBox bottomRedToken, bottomBlueToken, bottomGreenToken, bottomYellowToken;

    @FXML
    private Label topRedLabel, topBlueLabel, topGreenLabel, topYellowLabel;
    @FXML
    private Label leftRedLabel, leftBlueLabel, leftGreenLabel, leftYellowLabel;
    @FXML
    private Label rightRedLabel, rightBlueLabel, rightGreenLabel, rightYellowLabel;
    @FXML
    private Label bottomRedLabel, bottomBlueLabel, bottomGreenLabel, bottomYellowLabel;

    @FXML
    private Label score0, score1, score2, score3;

    @FXML
    private Button pushBottom1, pushBottom2, pushBottom3, pushBottom4;
    @FXML
    private Button pushLeft1, pushLeft2, pushLeft3, pushLeft4;
    @FXML
    private Button pushRight1, pushRight2, pushRight3, pushRight4;
    @FXML
    private Button pushTop1, pushTop2, pushTop3, pushTop4;
    @FXML
    private Label placeDonut;
    @FXML
    private Label placeDonut1;
    @FXML
    private Button confirmButton;

    @FXML
    private HBox PatternQuerry;

    private ImageView previousImageView;
    private String selectedColor;
    private VBox selectedToken;
    private String selectedSide;
    private int selectedIndex = -1;
    boolean isPatternCompleted = false;
    HashMap<Integer, String> result = new HashMap<>();

    Player player1 = new Player("Giap");

    @FXML
    void initialize() {
        // Set the board
        setBoard(player1.getBoard().getBoard());
        initializeTokenBoards(player1);

        // Initialize the scoreboard
        List<List<String>> scoreboard = player1.getScoreBoard().getScoreBoard();
        initializeScoreboard(scoreboard);

        // Hide all push buttons initially
        hideAllPushButtons();

        // Add event handlers to push buttons
        pushTop1.setOnAction(this::handlePushTop1);
        pushTop2.setOnAction(this::handlePushTop2);
        pushTop3.setOnAction(this::handlePushTop3);
        pushTop4.setOnAction(this::handlePushTop4);
        pushLeft1.setOnAction(this::handlePushLeft1);
        pushLeft2.setOnAction(this::handlePushLeft2);
        pushLeft3.setOnAction(this::handlePushLeft3);
        pushLeft4.setOnAction(this::handlePushLeft4);
        pushRight1.setOnAction(this::handlePushRight1);
        pushRight2.setOnAction(this::handlePushRight2);
        pushRight3.setOnAction(this::handlePushRight3);
        pushRight4.setOnAction(this::handlePushRight4);
        pushBottom1.setOnAction(this::handlePushBottom1);
        pushBottom2.setOnAction(this::handlePushBottom2);
        pushBottom3.setOnAction(this::handlePushBottom3);
        pushBottom4.setOnAction(this::handlePushBottom4);

        // Add event handlers for confirm button
        confirmButton.setOnMousePressed(_ -> confirmButton.getStyleClass().add("selected-confirm-button"));
        confirmButton.setOnMouseReleased(_ -> confirmButton.getStyleClass().remove("selected-confirm-button"));

        player1.getPatternQuery().displayAllPatterns();

        checkPatternAndEnableScoreboard();

        drawPatternQuerry();
    }

    private void handlePushTop1(ActionEvent event) {
        resetPushButtonStyles();
        setSelectedIndex(0);
        updatePushButtonStyle((Button) event.getSource());
    }

    private void handlePushTop2(ActionEvent event) {
        resetPushButtonStyles();
        setSelectedIndex(1);
        updatePushButtonStyle((Button) event.getSource());
    }

    private void handlePushTop3(ActionEvent event) {
        resetPushButtonStyles();
        setSelectedIndex(2);
        updatePushButtonStyle((Button) event.getSource());
    }

    private void handlePushTop4(ActionEvent event) {
        resetPushButtonStyles();
        setSelectedIndex(3);
        updatePushButtonStyle((Button) event.getSource());
    }

    private void handlePushLeft1(ActionEvent event) {
        resetPushButtonStyles();
        setSelectedIndex(0);
        updatePushButtonStyle((Button) event.getSource());
    }

    private void handlePushLeft2(ActionEvent event) {
        resetPushButtonStyles();
        setSelectedIndex(1);
        updatePushButtonStyle((Button) event.getSource());
    }

    private void handlePushLeft3(ActionEvent event) {
        resetPushButtonStyles();
        setSelectedIndex(2);
        updatePushButtonStyle((Button) event.getSource());
    }

    private void handlePushLeft4(ActionEvent event) {
        resetPushButtonStyles();
        setSelectedIndex(3);
        updatePushButtonStyle((Button) event.getSource());
    }

    private void handlePushRight1(ActionEvent event) {
        resetPushButtonStyles();
        setSelectedIndex(0);
        updatePushButtonStyle((Button) event.getSource());
    }

    private void handlePushRight2(ActionEvent event) {
        resetPushButtonStyles();
        setSelectedIndex(1);
        updatePushButtonStyle((Button) event.getSource());
    }

    private void handlePushRight3(ActionEvent event) {
        resetPushButtonStyles();
        setSelectedIndex(2);
        updatePushButtonStyle((Button) event.getSource());
    }

    private void handlePushRight4(ActionEvent event) {
        resetPushButtonStyles();
        setSelectedIndex(3);
        updatePushButtonStyle((Button) event.getSource());
    }

    private void handlePushBottom1(ActionEvent event) {
        resetPushButtonStyles();
        setSelectedIndex(0);
        updatePushButtonStyle((Button) event.getSource());
    }

    private void handlePushBottom2(ActionEvent event) {
        resetPushButtonStyles();
        setSelectedIndex(1);
        updatePushButtonStyle((Button) event.getSource());
    }

    private void handlePushBottom3(ActionEvent event) {
        resetPushButtonStyles();
        setSelectedIndex(2);
        updatePushButtonStyle((Button) event.getSource());
    }

    private void handlePushBottom4(ActionEvent event) {
        resetPushButtonStyles();
        setSelectedIndex(3);
        updatePushButtonStyle((Button) event.getSource());
    }

    private void updatePushButtonStyle(Button button) {
        button.getStyleClass().removeAll("unselected-push-button");
        button.getStyleClass().add("selected-push-button");
    }

    private void resetPushButtonStyles() {
        pushTop1.getStyleClass().removeAll("selected-push-button");
        pushTop1.getStyleClass().add("unselected-push-button");
        pushTop2.getStyleClass().removeAll("selected-push-button");
        pushTop2.getStyleClass().add("unselected-push-button");
        pushTop3.getStyleClass().removeAll("selected-push-button");
        pushTop3.getStyleClass().add("unselected-push-button");
        pushTop4.getStyleClass().removeAll("selected-push-button");
        pushTop4.getStyleClass().add("unselected-push-button");
        pushLeft1.getStyleClass().removeAll("selected-push-button");
        pushLeft1.getStyleClass().add("unselected-push-button");
        pushLeft2.getStyleClass().removeAll("selected-push-button");
        pushLeft2.getStyleClass().add("unselected-push-button");
        pushLeft3.getStyleClass().removeAll("selected-push-button");
        pushLeft3.getStyleClass().add("unselected-push-button");
        pushLeft4.getStyleClass().removeAll("selected-push-button");
        pushLeft4.getStyleClass().add("unselected-push-button");
        pushRight1.getStyleClass().removeAll("selected-push-button");
        pushRight1.getStyleClass().add("unselected-push-button");
        pushRight2.getStyleClass().removeAll("selected-push-button");
        pushRight2.getStyleClass().add("unselected-push-button");
        pushRight3.getStyleClass().removeAll("selected-push-button");
        pushRight3.getStyleClass().add("unselected-push-button");
        pushRight4.getStyleClass().removeAll("selected-push-button");
        pushRight4.getStyleClass().add("unselected-push-button");
        pushBottom1.getStyleClass().removeAll("selected-push-button");
        pushBottom1.getStyleClass().add("unselected-push-button");
        pushBottom2.getStyleClass().removeAll("selected-push-button");
        pushBottom2.getStyleClass().add("unselected-push-button");
        pushBottom3.getStyleClass().removeAll("selected-push-button");
        pushBottom3.getStyleClass().add("unselected-push-button");
        pushBottom4.getStyleClass().removeAll("selected-push-button");
        pushBottom4.getStyleClass().add("unselected-push-button");
    }

    private void setSelectedIndex(int index) {
        selectedIndex = index;
    }

    private void initializeTokenBoards(Player player) {
        Map<String, Integer> topTokens = player.getTopBoard().getColorCount();
        Map<String, Integer> bottomTokens = player.getBottomBoard().getColorCount();
        Map<String, Integer> leftTokens = player.getLeftBoard().getColorCount();
        Map<String, Integer> rightTokens = player.getRightBoard().getColorCount();

        initializeTokenBoard(topTokens, topRedToken, topRedLabel, topBlueToken, topBlueLabel, topGreenToken, topGreenLabel, topYellowToken, topYellowLabel);
        initializeTokenBoard(bottomTokens, bottomRedToken, bottomRedLabel, bottomBlueToken, bottomBlueLabel, bottomGreenToken, bottomGreenLabel, bottomYellowToken, bottomYellowLabel);
        initializeTokenBoard(leftTokens, leftRedToken, leftRedLabel, leftBlueToken, leftBlueLabel, leftGreenToken, leftGreenLabel, leftYellowToken, leftYellowLabel);
        initializeTokenBoard(rightTokens, rightRedToken, rightRedLabel, rightBlueToken, rightBlueLabel, rightGreenToken, rightGreenLabel, rightYellowToken, rightYellowLabel);
    }

    private void initializeTokenBoard(Map<String, Integer> tokens, VBox redToken, Label redLabel, VBox blueToken, Label blueLabel, VBox greenToken, Label greenLabel, VBox yellowToken, Label yellowLabel) {
        setTokenQuantity(tokens.getOrDefault("R", 0), redToken, redLabel);
        setTokenQuantity(tokens.getOrDefault("B", 0), blueToken, blueLabel);
        setTokenQuantity(tokens.getOrDefault("G", 0), greenToken, greenLabel);
        setTokenQuantity(tokens.getOrDefault("Y", 0), yellowToken, yellowLabel);
    }

    private void setTokenQuantity(int quantity, VBox token, Label label) {
        if (quantity > 0) {
            label.setText(String.valueOf(quantity));
        } else {
            if (token.getParent() instanceof Pane) {
                Pane parent = (Pane) token.getParent();
                parent.getChildren().remove(token);
            }
        }
    }

    private void initializeScoreboard(List<List<String>> scoreboard) {
        ImageView[][] tokens = {
            {token00, token01, token02},
            {token10, token11, token12},
            {token20, token21, token22},
            {token30, token31, token32}
        };
    
        Label[] scoreLabels = {score0, score1, score2, score3};
    
        for (int i = 0; i < scoreboard.size(); i++) {
            List<String> grid = scoreboard.get(i);
            for (int j = 0; j < grid.size(); j++) {
                tokens[i][j].setVisible(true);
                tokens[i][j].setImage(convertStringToImage(grid.get(j))); // Set to a colored image
            }
            for (int j = grid.size(); j < tokens[i].length; j++) {
                tokens[i][j].setVisible(false);
            }
    
            // Set the score label based on the number of colors in the grid
            if (grid.size() == 2) {
                scoreLabels[i].setText("+3");
            } else if (grid.size() == 3) {
                scoreLabels[i].setText("+5");
            }
        }
    }

    @FXML
    private void handleTokenClick(MouseEvent event) {
        // Check if a pattern is completed
        if (isPatternCompleted) {
            placeDonut1.setVisible(true);

            // Create a Timeline to hide the warning after 5 seconds
            Timeline timeline = new Timeline(new KeyFrame(
                Duration.seconds(5),
                _ -> placeDonut1.setVisible(false)
            ));
            timeline.play();
            return;
        }

        resetPushButtonStyles();
        selectedIndex = -1;

        selectedToken = (VBox) event.getSource();

        ImageView imageView = (ImageView) selectedToken.getChildren().get(0);
        selectedColor = getColorFromImage(imageView.getImage());
        selectedSide = getSide(selectedToken);
        System.out.println("Selected color: " + selectedColor + " from " + selectedSide);

        // Reset the scale of the previously selected image
        if (previousImageView != null) {
            scaleImage(previousImageView, 1.0);
        }

        // Scale the image
        scaleImage(imageView, 1.3);

        // Store the current imageView as the previous one
        previousImageView = imageView;

        // Show the appropriate push buttons
        showPushButtons(selectedSide);
    }

    private void scaleImage(ImageView imageView, double scale) {
        imageView.setScaleX(scale);
        imageView.setScaleY(scale);
    }

    private String getColorFromImage(Image image) {
        String url = image.getUrl();
        if (url.contains("red.gif")) {
            return "R";
        } else if (url.contains("blue.gif")) {
            return "B";
        } else if (url.contains("green.gif")) {
            return "G";
        } else if (url.contains("yellow.gif")) {
            return "Y";
        } else {
            return "";
        }
    }

    private String getSide(VBox token) {
        if (token == topRedToken || token == topBlueToken || token == topGreenToken || token == topYellowToken) {
            return "top";
        } else if (token == leftRedToken || token == leftBlueToken || token == leftGreenToken || token == leftYellowToken) {
            return "left";
        } else if (token == rightRedToken || token == rightBlueToken || token == rightGreenToken || token == rightYellowToken) {
            return "right";
        } else if (token == bottomRedToken || token == bottomBlueToken || token == bottomGreenToken || token == bottomYellowToken) {
            return "bottom";
        }
        return "";
    }

    private void showPushButtons(String side) {
        hideAllPushButtons();
        switch (side) {
            case "top":
                pushTop1.setVisible(true);
                pushTop2.setVisible(true);
                pushTop3.setVisible(true);
                pushTop4.setVisible(true);
                break;
            case "left":
                pushLeft1.setVisible(true);
                pushLeft2.setVisible(true);
                pushLeft3.setVisible(true);
                pushLeft4.setVisible(true);
                break;
            case "right":
                pushRight1.setVisible(true);
                pushRight2.setVisible(true);
                pushRight3.setVisible(true);
                pushRight4.setVisible(true);
                break;
            case "bottom":
                pushBottom1.setVisible(true);
                pushBottom2.setVisible(true);
                pushBottom3.setVisible(true);
                pushBottom4.setVisible(true);
                break;
        }
    }

    private void hideAllPushButtons() {
        pushTop1.setVisible(false);
        pushTop2.setVisible(false);
        pushTop3.setVisible(false);
        pushTop4.setVisible(false);
        pushLeft1.setVisible(false);
        pushLeft2.setVisible(false);
        pushLeft3.setVisible(false);
        pushLeft4.setVisible(false);
        pushRight1.setVisible(false);
        pushRight2.setVisible(false);
        pushRight3.setVisible(false);
        pushRight4.setVisible(false);
        pushBottom1.setVisible(false);
        pushBottom2.setVisible(false);
        pushBottom3.setVisible(false);
        pushBottom4.setVisible(false);
    }

    @FXML
    void onConfirmPush(ActionEvent event) {
        if (selectedColor == null) {
            System.out.println("No color selected");
            return;
        }

        if (selectedIndex < 0 || selectedIndex > 3) {
            System.out.println("Invalid index: " + selectedIndex);
            return;
        }

        switch (selectedSide) {
            case "top":
                player1.addFromTop(selectedColor, selectedIndex + 1);
                break;
            case "left":
                player1.addFromLeft(selectedColor, selectedIndex + 1);
                break;
            case "right":
                player1.addFromRight(selectedColor, selectedIndex + 1);
                break;
            case "bottom":
                player1.addFromBottom(selectedColor, selectedIndex + 1);
                break;
            default:
                System.out.println("Invalid side");
                break;
        }

        setBoard(player1.getBoard().getBoard());

        reduceTokenQuantity(selectedToken);

        player1.getBoard().printBoard();

        // Hide all push buttons after the push
        hideAllPushButtons();

        selectedColor = null;

        // Reset the scale of the previously selected image
        if (previousImageView != null) {
            scaleImage(previousImageView, 1.0);
            previousImageView = null;
        }

        // Maybe we can check if the player has finished a pattern here
        checkPatternAndEnableScoreboard();
    }

    private void reduceTokenQuantity(VBox token) {
        Label label = (Label) token.getChildren().get(1);
        int quantity = Integer.parseInt(label.getText());
        if (quantity > 0) {
            quantity--;
            if (quantity == 0) {
                if (token.getParent() instanceof Pane) {
                    Pane parent = (Pane) token.getParent();
                    parent.getChildren().remove(token);
                }
            } else {
                label.setText(String.valueOf(quantity));
            }
        }
    }

    public void setBoard(String[][] board) {
        ImageView[][] images = {
            {tok00, tok01, tok02, tok03},
            {tok10, tok11, tok12, tok13},
            {tok20, tok21, tok22, tok23},
            {tok30, tok31, tok32, tok33}
        };

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                images[i][j].setImage(convertStringToImage(board[i][j]));
            }
        }
    }

    private Image convertStringToImage(String color) {
        switch (color) {
            case "R":
                return new Image(getClass().getResource("red.gif").toExternalForm());
            case "B":
                return new Image(getClass().getResource("blue.gif").toExternalForm());
            case "G":
                return new Image(getClass().getResource("green.gif").toExternalForm());
            case "Y":
                return new Image(getClass().getResource("yellow.gif").toExternalForm());
            default:
                return null; // Fallback image
        }
    }

    @FXML
    void handleTokenClicked(MouseEvent event) {
        // Get the clicked ImageView
        ImageView token = (ImageView) event.getSource();
        String colorString = getColorFromImage(token.getImage());

        // filepath: /d:/vscode/UmbrellaFX/src/Controller.java
        if (isPatternCompleted && result.values().contains(colorString)) {
            token.setImage(new Image("heart.gif"));

            int slot = getIndexFromValue(colorString, result);
            result.remove(slot);

            // Remove the pattern
            player1.getPatternQuery().removePattern(slot);
            Pattern newPattern = player1.getPatternQuery().removePattern(slot);
            player1.getPatternQuery().addPattern(newPattern);
            drawPatternQuerry();

            if (result.isEmpty()) {
                isPatternCompleted = false;
                placeDonut.setVisible(false);
            }
        }
    }

    private int getIndexFromValue(String value, HashMap<Integer, String> map) {
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            if (entry.getValue().equals(value)) {
                return entry.getKey();
            }
        }
        return -1;
    }

    // Method to check pattern and update the flag
    public void checkPatternAndEnableScoreboard() {
        result = player1.checkPattern();
        System.out.println(result);
        
        if (!result.isEmpty()) {
            isPatternCompleted = true;
            placeDonut.setVisible(true);
        }
        else {
            isPatternCompleted = false;
        }
    }

    @FXML
    public void drawPatternQuerry() {
        PatternQuerry.getChildren().clear();

        PatternQuery ptq = player1.getPatternQuery();
        for (int slot = 0; slot < 4; slot++) {
            List<Pattern> patternSlots = ptq.getPatternsInSlot(slot);
            if (!patternSlots.isEmpty()) {
                Pattern pattern = patternSlots.get(0);
                int[][] points = pattern.getPositions();
                Image gridImage = createGridImage(points, pattern.isBlack());
                ImageView imageView = new ImageView(gridImage);
                PatternQuerry.getChildren().add(imageView);
            }
            else {
                //add empty box
                Image gridImage = EmptyBox();
                ImageView imageView = new ImageView(gridImage);
                PatternQuerry.getChildren().add(imageView);
            }
        }
    }

    private Image createGridImage(int[][] points, boolean isBlack) {
        int gridSize = 4;
        int cellSize = 15;
        int padding = 10; // Padding around the grid
        Canvas canvas = new Canvas(gridSize * cellSize + padding * 2, gridSize * cellSize + padding * 2);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        if(isBlack){
            gc.setFill(Color.BLACK);
            gc.fillRect(padding, padding, gridSize * cellSize, gridSize * cellSize);
            
            // Draw boundary
            gc.setStroke(Color.BLACK);
            gc.setLineWidth(2);
            gc.strokeRect(padding, padding, gridSize * cellSize, gridSize * cellSize);

            // Draw grid
            gc.setStroke(Color.WHITE);
            gc.setLineWidth(1);
            for (int i = 0; i <= gridSize; i++) {
                gc.strokeLine(padding + i * cellSize, padding, padding + i * cellSize, padding + gridSize * cellSize);
                gc.strokeLine(padding, padding + i * cellSize, padding + gridSize * cellSize, padding + i * cellSize);
            }

            // Plot points
            for (int i = 0; i < points.length; i++) {
                int y = padding + points[i][0] * cellSize + cellSize / 2;
                int x = padding + points[i][1] * cellSize + cellSize / 2;
                if (i == points.length - 1) {
                    gc.setFill(Color.RED);
                    gc.fillText("*", x - 5, y + 5);
                } else {
                    gc.setFill(Color.WHITE);
                    gc.fillOval(x - 5, y - 5, 10, 10);
                }
            }

            // Create a snapshot of the canvas
            return canvas.snapshot(null, null);
        }

        // Draw boundary
        gc.setStroke(Color.GRAY);
        gc.setLineWidth(2);
        gc.strokeRect(padding, padding, gridSize * cellSize, gridSize * cellSize);

        // Draw grid
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(1);
        for (int i = 0; i <= gridSize; i++) {
            gc.strokeLine(padding + i * cellSize, padding, padding + i * cellSize, padding + gridSize * cellSize);
            gc.strokeLine(padding, padding + i * cellSize, padding + gridSize * cellSize, padding + i * cellSize);
        }

        // Plot points
        for (int i = 0; i < points.length; i++) {
            int y = padding + points[i][0] * cellSize + cellSize / 2;
            int x = padding + points[i][1] * cellSize + cellSize / 2;
            if (i == points.length - 1) {
                gc.setFill(Color.RED);
                gc.fillText("*", x - 5, y + 5);
            } else {
                gc.setFill(Color.BLACK);
                gc.fillOval(x - 5, y - 5, 10, 10);
            }
        }

        // Create a snapshot of the canvas
        return canvas.snapshot(null, null);
    }

    
    private Image EmptyBox() {
        int gridSize = 4;
        int cellSize = 15;
        int padding = 10; // Padding around the grid
        Canvas canvas = new Canvas(gridSize * cellSize + padding * 2, gridSize * cellSize + padding * 2);
        return canvas.snapshot(null, null);
    }
}
