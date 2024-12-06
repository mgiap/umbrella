package GameImplementation;

import PlayerImplementation.*;

public class TestGame {
    public static void main(String[] args) {
        // Initialize the game
        Game game = new Game();

        // Get the list of players
        for (Player player : game.getPlayers()) {
            // Display initial info for each player
            player.displayPlayerInfo();
            System.out.println("\n--------------------------\n");
        }

        // Simulate modifying side boards
        System.out.println("Modifying side boards...\n");

        // Player 1 modifies their right board
        Player player1 = game.getPlayers().get(0);
        player1.getRightBoard().getColorCount().put("R", 5);

        // Player 2 modifies their left board (which is the same as Player 1's right board)
        Player player2 = game.getPlayers().get(1);
        player2.getLeftBoard().getColorCount().put("B", 3);
        
        Player.getMiddleBoard().getColorCount().put("R", 10);

        // Verify if the changes are reflected for both Player 1's right board and Player 2's left board
        System.out.println("Player 1's Right Board after modification: " + player1.getRightBoard().getColorCount());
        System.out.println("Player 2's Left Board after modification: " + player2.getLeftBoard().getColorCount());

        // Verify shared board connection integrity
        System.out.println("\nVerifying shared board connection integrity...");
        assert player1.getRightBoard().getColorCount().equals(player2.getLeftBoard().getColorCount())
            : "Shared boards are not linked correctly!";
        
        System.out.println("Shared board connection integrity verified!\n");
        
        game.startGame();
    }
}
