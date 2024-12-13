package PlayerImplementation;

import BoardImplementation.Board;
import BoardImplementation.BoardStyle;

public class TestPatternExchange {
    public static void main(String[] args) {
        testPatternAddAndRemove();
    }

    private static void testPatternAddAndRemove() {
        // Setup
        Board board = new Board(BoardStyle.STYLE1); // Assuming STYLE1 is a valid board style
        // {"R", "B", "G", "Y"},
        // {"Y", "R", "B", "G"},
        // {"G", "Y", "R", "B"},
        // {"B", "G", "Y", "R"}
        SideBoard leftBoard = new SideBoard();
        SideBoard rightBoard = new SideBoard();

        // Create two players
        Player player1 = new Player("Player One", 1, board, leftBoard, rightBoard);
        Player player2 = new Player("Player Two", 2, board, rightBoard, leftBoard);

        // Add patterns to player1
        Pattern pattern3 = new Pattern(new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 0}, {0, 0}});
        Pattern pattern2 = new Pattern(PatternGenerator.generateNewPattern());
        Pattern pattern1 = new Pattern(PatternGenerator.generateNewPattern());
        player1.getPatternQuery().addPattern(0, pattern1);
        player1.getPatternQuery().addPattern(1, pattern2);
        player1.getPatternQuery().addPattern(pattern3);
        player1.getPatternQuery().addPattern(pattern3);
        player1.getPatternQuery().addPattern(pattern3);
        
        player1.getPatternQuery().displayAllPatterns();

        Pattern patternRemoved = player1.getPatternQuery().removePattern(0);
        System.out.println("After remove:");
        player1.getPatternQuery().displayAllPatterns();
        
        // Add patterns to player2
        // System.out.println("After remove:");
        // player1.removePattern(2);
        // // Display initial state
        // player1.displayPatternQuery();

        // Remove pattern from player1
        // Pattern removedPattern = player1.getPatternQuery().removePattern(0);

        // Display final state
    }
}
