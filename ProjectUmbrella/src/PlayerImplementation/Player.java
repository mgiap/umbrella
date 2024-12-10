package PlayerImplementation;

import BoardImplementation.Board;
import java.util.HashMap;

public class Player {
    private String name;
    private int id;
    private Board board;
    private ScoreBoard scoreBoard;
    private int scores;
    private static MiddleBoard middleBoard = new MiddleBoard(); // Shared among all players
    private BottomBoard bottomBoard; // Unique to each player
    private SideBoard leftBoard;     // Unique to each player
    private SideBoard rightBoard;    // Unique to each player

    // Constructor
    public Player(String name, int id, Board board, SideBoard leftBoard, SideBoard rightBoard) {
        this.name = name;
        this.id = id;
        this.board = board;
        this.scoreBoard = new ScoreBoard();
        this.scores = 0; // Initial score is 0
        this.bottomBoard = new BottomBoard(); // Each player gets their own BottomBoard
        this.leftBoard = leftBoard;
        this.rightBoard = rightBoard;
    }

    public void displayPlayerInfo() {
        System.out.println("Player Info:");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Scores: " + scores);

        // Display board and scoreboard information
        System.out.println("Board: " + board); // Assuming Board has a toString implementation
        System.out.println("ScoreBoard: " + scoreBoard);

        // Display individual boards
        System.out.println("Bottom Board: " + bottomBoard.getColorCount());
        System.out.println("Left Board: " + leftBoard.getColorCount());
        System.out.println("Right Board: " + rightBoard.getColorCount());

        // Display shared MiddleBoard
        System.out.println("Middle Board: " + middleBoard.getColorCount());
    }
    
    // Getter for MainBoard
    public Board getBoard() {
        return board;
    }
    
    // Getter for MiddleBoard
    public static MiddleBoard getMiddleBoard() {
        return middleBoard;
    }

    // Getter for BottomBoard
    public BottomBoard getBottomBoard() {
        return bottomBoard;
    }

    // Getter for LeftBoard
    public SideBoard getLeftBoard() {
        return leftBoard;
    }

    // Getter for RightBoard
    public SideBoard getRightBoard() {
        return rightBoard;
    }
    
    // Getter for name
    public String getName() {
        return name;
    }
    
    // Getter for scores
    public int getScores() {
        return scores;
    }
    
    // Getter for scoreBoard
    public ScoreBoard getScoreBoard() {
        return scoreBoard;
    }

    // Method to add umbrella from Left Board
    public void addFromLeft(String umbrella, int row) {
        HashMap<String, Integer> sourceCounts = leftBoard.getColorCount();
        HashMap<String, Integer> targetCounts = rightBoard.getColorCount();

        // Validate and update the source board
        int count = sourceCounts.get(umbrella);
        if (count <= 0) {
            System.out.println("Error: The umbrella is not in the Left Board!");
            return;
        }
        sourceCounts.put(umbrella, count - 1);

        row--; // Adjust for 0-based index
        String removedUmbrella = board.getBoard()[row][3];

        // Shift umbrellas in the row
        for (int i = 3; i > 0; i--) {
            board.getBoard()[row][i] = board.getBoard()[row][i - 1];
        }
        board.getBoard()[row][0] = umbrella;

        // Update the target board
        targetCounts.put(removedUmbrella, targetCounts.get(removedUmbrella) + 1);
    }

    // Method to add umbrella from Right Board
    public void addFromRight(String umbrella, int row) {
        HashMap<String, Integer> sourceCounts = rightBoard.getColorCount();
        HashMap<String, Integer> targetCounts = leftBoard.getColorCount();

        // Validate and update the source board
        int count = sourceCounts.get(umbrella);
        if (count <= 0) {
            System.out.println("Error: The umbrella is not in the Right Board!");
            return;
        }
        sourceCounts.put(umbrella, count - 1);

        row--; // Adjust for 0-based index
        String removedUmbrella = board.getBoard()[row][0];

        // Shift umbrellas in the row
        for (int i = 0; i < 3; i++) {
            board.getBoard()[row][i] = board.getBoard()[row][i + 1];
        }
        board.getBoard()[row][3] = umbrella;

        // Update the target board
        targetCounts.put(removedUmbrella, targetCounts.get(removedUmbrella) + 1);
    }

    // Method to add umbrella from Middle Board
    public void addFromMiddle(String umbrella, int column) {
        HashMap<String, Integer> sourceCounts = middleBoard.getColorCount();
        HashMap<String, Integer> targetCounts = bottomBoard.getColorCount();

        // Validate and update the source board
        int count = sourceCounts.get(umbrella);
        if (count <= 0) {
            System.out.println("Error: The umbrella is not in the Middle Board!");
            return;
        }
        sourceCounts.put(umbrella, count - 1);

        column--; // Adjust for 0-based index
        String removedUmbrella = board.getBoard()[3][column];

        // Shift umbrellas in the column
        for (int i = 3; i > 0; i--) {
            board.getBoard()[i][column] = board.getBoard()[i - 1][column];
        }
        board.getBoard()[0][column] = umbrella;

        // Update the target board
        targetCounts.put(removedUmbrella, targetCounts.get(removedUmbrella) + 1);
    }

    // Method to add umbrella from Bottom Board
    public void addFromBottom(String umbrella, int column) {
        HashMap<String, Integer> sourceCounts = bottomBoard.getColorCount();
        HashMap<String, Integer> targetCounts = middleBoard.getColorCount();

        // Validate and update the source board
        int count = sourceCounts.get(umbrella);
        if (count <= 0) {
            System.out.println("Error: The umbrella is not in the Bottom Board!");
            return;
        }
        sourceCounts.put(umbrella, count - 1);

        column--; // Adjust for 0-based index
        String removedUmbrella = board.getBoard()[0][column];

        // Shift umbrellas in the column
        for (int i = 0; i < 3; i++) {
            board.getBoard()[i][column] = board.getBoard()[i + 1][column];
        }
        board.getBoard()[3][column] = umbrella;

        // Update the target board
        targetCounts.put(removedUmbrella, targetCounts.get(removedUmbrella) + 1);
    }
}
