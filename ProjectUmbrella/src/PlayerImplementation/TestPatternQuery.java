package PlayerImplementation;

import BoardImplementation.Board;
import BoardImplementation.BoardStyle;
import java.util.List;
import java.util.Map;

public class TestPatternQuery {
    public static void main(String[] args) {
        testCheckPattern();
    }

    private static void testCheckPattern() {
        // Setup
        Board board = new Board(BoardStyle.STYLE1); // Assuming STYLE1 is a valid board style
        SideBoard leftBoard = new SideBoard();
        SideBoard rightBoard = new SideBoard();
        Player player = new Player("Test Player", 1, board, leftBoard, rightBoard);

        // Assuming PatternQuery is correctly set up in the Player constructor
        // Manually add patterns to the PatternQuery for testing
        Pattern pattern = new Pattern(new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 0}, {0, 0}});
        player.getPatternQuery().addPattern(0, pattern); // Add pattern to slot 0
        Pattern pattern1 = new Pattern(new int[][]{{0, 2}, {1, 3}, {2, 0}, {3, 1}, {0, 0}});
        player.getPatternQuery().addPattern(1, pattern1); // Add pattern to slot 0
        // {"R", "B", "G", "Y"},
        // {"Y", "R", "B", "G"},
        // {"G", "Y", "R", "B"},
        // {"B", "G", "Y", "R"}
        // Act
        player.displayPatternQuery();
        Map<Integer, String> results = player.checkPattern();

        // Assert
        for (Map.Entry<Integer, String> entry : results.entrySet()) {
            if ("R".equals(entry.getValue())) {
                System.out.println("Test Passed: R color detected on slot " + entry.getKey());
            }
            if ("B".equals(entry.getValue())) {
                System.out.println("Test Passed: B color detected on slot " + entry.getKey());
            }
            if ("G".equals(entry.getValue())) {
                System.out.println("Test Passed: G color detected on slot " + entry.getKey());
            }
            if ("Y".equals(entry.getValue())) {
                System.out.println("Test Passed: Y color detected on slot " + entry.getKey());
            }
        }
        if (results.isEmpty()) {
            System.out.println("Test Failed: Correct color not detected.");
        }
    }
}
