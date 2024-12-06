package PlayerImplementation;

import BoardImplementation.Board;
import BoardImplementation.BoardStyle;

import java.util.List;

public class TestPlayer {

    public static void main(String[] args) {
        // Generate the random scoreboard using the Generator from PlayerImplementation package
        Generator generator = new Generator();
        List<List<String>> permutations = generator.generateRandomPermutationsArray();

        // Create ScoreBoard for the players
        ScoreBoard scoreBoard1 = new ScoreBoard(permutations);
        ScoreBoard scoreBoard2 = new ScoreBoard(generator.generateRandomPermutationsArray());

        // Create SideBoards (simulating shared boards)
        SideBoard board1 = new SideBoard();
        SideBoard board2 = new SideBoard();
        SideBoard board3 = new SideBoard();
        SideBoard board4 = new SideBoard();

        // Create players
        Player player1 = new Player("Player 1", 1, new Board(BoardStyle.STYLE1), scoreBoard1, board1, board2);
        Player player2 = new Player("Player 2", 2, new Board(BoardStyle.STYLE2), scoreBoard2, board2, board3);
        Player player3 = new Player("Player 3", 3, new Board(BoardStyle.STYLE3), scoreBoard1, board3, board4);
        Player player4 = new Player("Player 4", 4, new Board(BoardStyle.STYLE4), scoreBoard2, board4, board1);

        // Modify a value in player1's right board (board2) and check its effect on player2's left board
        System.out.println("Before modification:");
        System.out.println("Player 1's Right Board (Board 2): " + player1.getRightBoard().getColorCount());
        System.out.println("Player 2's Left Board (Board 2): " + player2.getLeftBoard().getColorCount());

        // Modify the board
        player1.getRightBoard().getColorCount().put("R", 5); // Change the count of "R" in the right board (Board 2)
        player1.getLeftBoard().getColorCount().put("B", 2);

        System.out.println("\nAfter modification:");
        System.out.println("Player 1's Right Board (Board 2): " + player1.getRightBoard().getColorCount());
        System.out.println("Player 2's Left Board (Board 2): " + player2.getLeftBoard().getColorCount());

        // Verify circular linkage
        System.out.println("\nCircular verification:");
        System.out.println("Player 4's Right Board (Board 1): " + player4.getRightBoard().getColorCount());
        System.out.println("Player 1's Left Board (Board 1): " + player1.getLeftBoard().getColorCount());
    }
}
