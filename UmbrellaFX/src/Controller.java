import java.util.List;
import java.util.Map;

import PlayerImplementation.Player;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
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
    private ChoiceBox<Integer> rowColumnChoiceBox;

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

    private Color selectedColor;
    private VBox selectedToken;
    private String selectedSide;

    @FXML
    void initialize() {
        Player player1 = new Player("Giap", 2);

        // Set the board
        setBoard(player1.getBoard().getBoard());
        initializeTokenBoards(player1);

        // Initialize the row/column choice box
        rowColumnChoiceBox.getItems().addAll(1, 2, 3, 4);
        rowColumnChoiceBox.setValue(1); // Default value

        // Initialize the scoreboard
        List<List<String>> scoreboard = player1.getScoreBoard().getScoreBoard();
        initializeScoreboard(scoreboard);
    }

    private void initializeTokenBoards(Player player) {
        Map<String, Integer> topTokens = player.getTopBoard().getColorCount();
        Map<String, Integer> bottomTokens = player.getBottomBoard().getColorCount();
        Map<String, Integer> leftTokens = player.getLeftBoard().getColorCount();
        Map<String, Integer> rightTokens = player.getRightBoard().getColorCount();

        initializeTokenBoard(topTokens, topRedLabel, topBlueLabel, topGreenLabel, topYellowLabel);
        initializeTokenBoard(bottomTokens, bottomRedLabel, bottomBlueLabel, bottomGreenLabel, bottomYellowLabel);
        initializeTokenBoard(leftTokens, leftRedLabel, leftBlueLabel, leftGreenLabel, leftYellowLabel);
        initializeTokenBoard(rightTokens, rightRedLabel, rightBlueLabel, rightGreenLabel, rightYellowLabel);
    }

    private void initializeTokenBoard(Map<String, Integer> tokens, Label redLabel, Label blueLabel, Label greenLabel, Label yellowLabel) {
        redLabel.setText(String.valueOf(tokens.getOrDefault("R", 0)));
        blueLabel.setText(String.valueOf(tokens.getOrDefault("B", 0)));
        greenLabel.setText(String.valueOf(tokens.getOrDefault("G", 0)));
        yellowLabel.setText(String.valueOf(tokens.getOrDefault("Y", 0)));
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

    @FXML
    void onConfirmPush(ActionEvent event) {
        if (selectedColor == null) {
            System.out.println("No color selected");
            return;
        }

        int index = rowColumnChoiceBox.getValue() - 1;

        switch (selectedSide) {
            case "top":
                pushTop(index);
                break;
            case "left":
                pushLeft(index);
                break;
            case "right":
                pushRight(index);
                break;
            case "bottom":
                pushBottom(index);
                break;
            default:
                System.out.println("Invalid side");
                break;
        }

        reduceTokenQuantity(selectedToken);
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
}