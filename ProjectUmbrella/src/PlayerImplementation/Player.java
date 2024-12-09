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
}
