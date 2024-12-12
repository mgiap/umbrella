package PlayerImplementation;

public class TestPatternQuery {
    public static void main(String[] args) {
        // Player player = new Player();
        // System.out.println("Displaying all patterns in all slots:");
        // player.getPatternQuery().displayAllPatterns();
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
        List<String> results = player.checkPattern();

        // Assert
        if (results.contains("R")) {
            System.out.println("Test Passed: R color detected.");
        }
        if (results.contains("B")) {
            System.out.println("Test Passed: B color detected.");
        }
        if (results.contains("G")) {
            System.out.println("Test Passed: G color detected.");
        }if (results.contains("Y")) {
            System.out.println("Test Passed: Y color detected.");
        } 
        if (results.isEmpty()) {
            System.out.println("Test Failed: Correct color not detected.");
        }
    }
}

}
