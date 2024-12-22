import java.util.List;
import java.util.Map;

import PlayerImplementation.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class Controller {

    @FXML
    private Circle cir00, cir01, cir02, cir03, cir10, cir11, cir12, cir13, cir20, cir21, cir22, cir23, cir30, cir31, cir32, cir33;

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
    private Circle token00, token01, token02, token10, token11, token12, token20, token21, token22, token30, token31, token32;

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

    private Color selectedColor;
    private VBox selectedToken;
    private String selectedSide;
    private int selectedIndex = -1;

    Player player1 = new Player("Giap", 2);

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
    }

    private void handlePushTop1(ActionEvent event) {
        setSelectedIndex(0);
    }

    private void handlePushTop2(ActionEvent event) {
        setSelectedIndex(1);
    }

    private void handlePushTop3(ActionEvent event) {
        setSelectedIndex(2);
    }

    private void handlePushTop4(ActionEvent event) {
        setSelectedIndex(3);
    }

    private void handlePushLeft1(ActionEvent event) {
        setSelectedIndex(0);
    }

    private void handlePushLeft2(ActionEvent event) {
        setSelectedIndex(1);
    }

    private void handlePushLeft3(ActionEvent event) {
        setSelectedIndex(2);
    }

    private void handlePushLeft4(ActionEvent event) {
        setSelectedIndex(3);
    }

    private void handlePushRight1(ActionEvent event) {
        setSelectedIndex(0);
    }

    private void handlePushRight2(ActionEvent event) {
        setSelectedIndex(1);
    }

    private void handlePushRight3(ActionEvent event) {
        setSelectedIndex(2);
    }

    private void handlePushRight4(ActionEvent event) {
        setSelectedIndex(3);
    }

    private void handlePushBottom1(ActionEvent event) {
        setSelectedIndex(0);
    }

    private void handlePushBottom2(ActionEvent event) {
        setSelectedIndex(1);
    }

    private void handlePushBottom3(ActionEvent event) {
        setSelectedIndex(2);
    }

    private void handlePushBottom4(ActionEvent event) {
        setSelectedIndex(3);
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
        Circle[][] tokens = {
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
                tokens[i][j].setFill(convertStringToColor(grid.get(j)));
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
        if (selectedToken != null) {
            selectedToken.getStyleClass().remove("selected-token");
        }

        selectedToken = (VBox) event.getSource();
        selectedToken.getStyleClass().add("selected-token");

        Circle circle = (Circle) selectedToken.getChildren().get(0);
        selectedColor = (Color) circle.getFill();
        selectedSide = getSide(selectedToken);
        System.out.println("Selected color: " + selectedColor + " from " + selectedSide);

        // Show the appropriate push buttons
        showPushButtons(selectedSide);
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
                pushTop(selectedIndex);
                player1.addFromTop(convertColorToString(selectedColor), selectedIndex + 1);
                break;
            case "left":
                pushLeft(selectedIndex);
                player1.addFromLeft(convertColorToString(selectedColor), selectedIndex + 1);
                break;
            case "right":
                pushRight(selectedIndex);
                player1.addFromRight(convertColorToString(selectedColor), selectedIndex + 1);
                break;
            case "bottom":
                pushBottom(selectedIndex);
                player1.addFromBottom(convertColorToString(selectedColor), selectedIndex + 1);
                break;
            default:
                System.out.println("Invalid side");
                break;
        }

        reduceTokenQuantity(selectedToken);

        player1.getBoard().printBoard();

        // Hide all push buttons after the push
        hideAllPushButtons();
    }

    private void pushLeft(int row) {
        Circle[] circles = getRow(row);

        // Shift colors to the right
        for (int i = 3; i > 0; i--) {
            circles[i].setFill(circles[i - 1].getFill());
        }
        circles[0].setFill(selectedColor);
    }

    private void pushRight(int row) {
        Circle[] circles = getRow(row);

        // Shift colors to the left
        for (int i = 0; i < 3; i++) {
            circles[i].setFill(circles[i + 1].getFill());
        }
        circles[3].setFill(selectedColor);
    }

    private void pushTop(int col) {
        Circle[] circles = getColumn(col);

        // Shift colors up
        for (int i = 3; i > 0; i--) {
            circles[i].setFill(circles[i - 1].getFill());
        }
        circles[0].setFill(selectedColor);
    }

    private void pushBottom(int col) {
        Circle[] circles = getColumn(col);

        // Shift colors down
        for (int i = 0; i < 3; i++) {
            circles[i].setFill(circles[i + 1].getFill());
        }
        circles[3].setFill(selectedColor);
    }

    private Circle[] getRow(int row) {
        switch (row) {
            case 0: return new Circle[]{cir00, cir01, cir02, cir03};
            case 1: return new Circle[]{cir10, cir11, cir12, cir13};
            case 2: return new Circle[]{cir20, cir21, cir22, cir23};
            case 3: return new Circle[]{cir30, cir31, cir32, cir33};
            default: throw new IllegalArgumentException("Invalid row index");
        }
    }

    private Circle[] getColumn(int col) {
        switch (col) {
            case 0: return new Circle[]{cir00, cir10, cir20, cir30};
            case 1: return new Circle[]{cir01, cir11, cir21, cir31};
            case 2: return new Circle[]{cir02, cir12, cir22, cir32};
            case 3: return new Circle[]{cir03, cir13, cir23, cir33};
            default: throw new IllegalArgumentException("Invalid column index");
        }
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
        Circle[][] circles = {
            {cir00, cir01, cir02, cir03},
            {cir10, cir11, cir12, cir13},
            {cir20, cir21, cir22, cir23},
            {cir30, cir31, cir32, cir33}
        };

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                circles[i][j].setFill(convertStringToColor(board[i][j]));
            }
        }
    }

    private Color convertStringToColor(String color) {
        switch (color) {
            case "R":
                return Color.RED;
            case "B":
                return Color.BLUE;
            case "G":
                return Color.GREEN;
            case "Y":
                return Color.YELLOW;
            default:
                return Color.BLACK; // Fallback color
        }
    }

    private String convertColorToString(Color color) {
        if (color.equals(Color.RED)) {
            return "R";
        } else if (color.equals(Color.BLUE)) {
            return "B";
        } else if (color.equals(Color.GREEN)) {
            return "G";
        } else if (color.equals(Color.YELLOW)) {
            return "Y";
        } else {
            return "";
        }
    }
}
