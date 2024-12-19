package PlayerImplementation;

public class TestPlayer {

    public static void main(String[] args) {

        // Create a player with the boards and the scoreboard
        Player player1 = new Player("Player 1", 1);
        
        player1.getTopBoard().printBoard();
        player1.getBottomBoard().printBoard();
        player1.getLeftBoard().printBoard();
        player1.getRightBoard().printBoard();
    }

}
