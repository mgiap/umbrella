package PlayerImplementation;

import BoardImplementation.Board;
import java.util.HashMap;

public class Player {
    private String name;
    private int id;
    private Board board;
    private ScoreBoard scoreBoard;
    private int scores;
    private HashMap<String, Integer> bottom;
    private int[][] patterns = new int[5][2];  // Leaving patterns as is, not needed right now.

    // Constructor to initialize the player with basic information
    public Player(String name, int id, Board board, ScoreBoard scoreBoard) {
        this.name = name;
        this.id = id;
        this.board = board;
        this.scoreBoard = scoreBoard;
        this.scores = 0;  // Initial score is 0
        this.bottom = new HashMap<>();  // Initializing the HashMap for bottom
    }

    // Getter and setter methods for the player class
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public Board getBoard() { return board; }
    public void setBoard(Board board) { this.board = board; }
    public ScoreBoard getScoreBoard() { return scoreBoard; }
    public void setScoreBoard(ScoreBoard scoreBoard) { this.scoreBoard = scoreBoard; }
    public int getScores() { return scores; }
    public void setScores(int scores) { this.scores = scores; }
    public HashMap<String, Integer> getBottom() { return bottom; }
    public void setBottom(HashMap<String, Integer> bottom) { this.bottom = bottom; }

    // Method to display all the info of the player
    public void displayPlayerInfo() {
        System.out.println("Player Info:");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Scores: " + scores);

        if (board != null) {
            board.printBoard();
        } else {
            System.out.println("Board: No board assigned.");
        }

        if (scoreBoard != null) {
            scoreBoard.printScoreBoard();
        } else {
            System.out.println("ScoreBoard: No scoreboard assigned.");
        }
        
        // Print the size of each permutation in the scoreboard
        printScoreBoardSize();
    }
    
    // Method to print the size of each permutation in the scoreboard
    public void printScoreBoardSize() {
        System.out.println("\nSizes of each permutation in the scoreboard:");
        for (int size : scoreBoard.getPermutationSizes()) {
            System.out.println(size);
        }
    }
}
