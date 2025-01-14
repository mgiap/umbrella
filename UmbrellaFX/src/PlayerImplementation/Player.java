package PlayerImplementation;

import BoardImplementation.Board;
import BoardImplementation.BoardStyle;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class Player {
    private String name;
    private int id;
    private Board board;
    private ScoreBoard scoreBoard;
    private int scores;
    private TokenBoard topBoard;   // Changed middleBoard to topBoard
    private TokenBoard bottomBoard; // Unique to each player
    private TokenBoard leftBoard;     // Unique to each player
    private TokenBoard rightBoard;    // Unique to each player
    private PatternQuery patternQuery;
    private HashMap<String, Integer> colorRemain = new HashMap<>();

    public Player(String name) {
        this.name = name;
        // Random ID generation
        Random random = new Random();
        this.id = random.nextInt(4) + 1; // Random ID
        this.board = new Board(BoardStyle.style[id - 1]);
        this.scoreBoard = new ScoreBoard();
        this.scores = 0; // Initial score is 0
        this.patternQuery = new PatternQuery();
        TokenBoard[] tokenBoards = TokenBoardGenerator.generateTokenBoards();
        this.topBoard = tokenBoards[0];
        this.bottomBoard = tokenBoards[1];
        this.leftBoard = tokenBoards[2];
        this.rightBoard = tokenBoards[3];

        // Loop through the color counts and add to the colorRemain map
        for (List<String> permutation : scoreBoard.getScoreBoard()) {
            for (String color : permutation) {
                if (colorRemain.containsKey(color)) {
                    colorRemain.put(color, colorRemain.get(color) + 1);
                } else {
                    colorRemain.put(color, 1);
                }
            }
        }
    }

    public void displayPlayerInfo() {
        System.out.println("Player Info:");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Scores: " + scores);

        // Display board and scoreboard information
        System.out.println("Board: " + board); // Assuming Board has a toString implementation
        this.getScoreBoard().printScoreBoard();

        // Display individual boards
        System.out.println("Bottom Board: " + bottomBoard.getColorCount());
        System.out.println("Left Board: " + leftBoard.getColorCount());
        System.out.println("Right Board: " + rightBoard.getColorCount());

        // Display shared top board
        System.out.println("Top Board: " + topBoard.getColorCount()); // Changed middleBoard to topBoard

        // Display the colorRemain map
        System.out.println("Color Remain: " + colorRemain);
    }
    
    // Getter for MainBoard
    public Board getBoard() {
        return board;
    }
    
    // Getter for TopBoard
    public TokenBoard getTopBoard() {
        return topBoard; // Changed middleBoard to topBoard
    }

    // Getter for BottomBoard
    public TokenBoard getBottomBoard() {
        return bottomBoard;
    }

    // Getter for LeftBoard
    public TokenBoard getLeftBoard() {
        return leftBoard;
    }

    // Getter for RightBoard
    public TokenBoard getRightBoard() {
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

    public PatternQuery getPatternQuery() {
        return patternQuery;
    }

    public void displayPatternQuery(){
        patternQuery.printFirstPatternsInSlots();
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

    // Method to add umbrella from Top Board
    public void addFromTop(String umbrella, int column) {
        HashMap<String, Integer> sourceCounts = topBoard.getColorCount();
        HashMap<String, Integer> targetCounts = bottomBoard.getColorCount();

        // Validate and update the source board
        int count = sourceCounts.get(umbrella);
        if (count <= 0) {
            System.out.println("Error: The umbrella is not in the Top Board!");
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
        HashMap<String, Integer> targetCounts = topBoard.getColorCount();

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

    // Check first pattern in all slot
    public HashMap<Integer, String> checkPattern() {
        HashMap<Integer, String> results = new HashMap<>();
        String[][] boardData = board.getBoard(); // Assuming boardData does not change per slot

        for (int slot = 0; slot < 4; slot++) {
            if (!patternQuery.getPatternsInSlot(slot).isEmpty()) {
                Pattern pattern = patternQuery.getPatternsInSlot(slot).get(0);
                int[][] positions = pattern.getPositions();

                // Check if all positions have the same color using your logic
                if (boardData[positions[0][0]][positions[0][1]].equals(boardData[positions[1][0]][positions[1][1]]) &&
                    boardData[positions[1][0]][positions[1][1]].equals(boardData[positions[2][0]][positions[2][1]]) &&
                    boardData[positions[2][0]][positions[2][1]].equals(boardData[positions[3][0]][positions[3][1]]) &&
                    colorRemain.get(boardData[positions[0][0]][positions[0][1]]) > 0) {
                    // Map the slot number to the color
                    results.put(slot, boardData[positions[0][0]][positions[0][1]]);
                }
            }
        }

        return results;
    }

    public void calculateScores() {
        int maxColorCount = calculateMaxScoresBaseOnColorAppearTheMost();
        scores += maxColorCount;

        for (int i = 0; i < 4; i++) {
            boolean finishAll = true; // Set flag to check if all the tokens of a slot are occupied
            List<String> tokens = this.scoreBoard.getScoreBoard().get(i);
            for (String token : tokens) {
                if (token.equals("T")) {
                    scores += 2;
                } else {
                    finishAll = false; // if there is at least one token not occupied
                }
            }

            if (finishAll) {
                if (tokens.size() == 3) {
                    scores += 5;
                } else if (tokens.size() == 2) {
                    scores += 3;
                }
            }
        }
    }

    public int calculateMaxScoresBaseOnColorAppearTheMost() {
        HashMap<String, Integer> colorCount = new HashMap<>();
        String[][] boardData = board.getBoard();

        // Count the occurrences of each color on the board
        for (int i = 0; i < boardData.length; i++) {
            for (int j = 0; j < boardData[i].length; j++) {
                String color = boardData[i][j];
                colorCount.put(color, colorCount.getOrDefault(color, 0) + 1);
            }
        }

        // Find the maximum count of any color
        int maxCount = 0;
        for (int count : colorCount.values()) {
            if (count > maxCount) {
                maxCount = count;
            }
        }

        return maxCount;
    }

    public void chooseTokenToPut(int slot, String color) {
        List<String> tokens = this.getScoreBoard().getScoreBoard().get(slot);
        for (int i = 0; i < tokens.size(); i++) {
            if (tokens.get(i).equals(color)) {
                tokens.set(i, "T");
                break;
            }
        }
    }

    public int getId() {
        return id;
    }

    public HashMap<String, Integer> getColorRemain() {
        return colorRemain;
    }
}
