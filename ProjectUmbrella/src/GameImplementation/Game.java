package GameImplementation;

import PlayerImplementation.*;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private static int token;
    private static List<Player> players;
    private static SideBoard[] sideBoards = new SideBoard[4];
    
    // Initialize 4 SideBoards for the circular seating arrangement
    static {
        for (int i = 0; i < sideBoards.length; i++) {
            sideBoards[i] = new SideBoard();
        }
    }

    public Game() {
        // Initialize players and generator
        players = new ArrayList<>();

        // Create and assign players
        for (int i = 0; i < 4; i++) {
            // Create player and add to the list
            Player player = new Player("Player " + (i + 1), i + 1);
            players.add(player);
        }
    }

    // Display all players' information
    public void displayAllPlayersInfo() {
        for (Player player : players) {
            player.displayPlayerInfo();
            System.out.println("\n--------------------------\n");
        }
    }

    // Start the game
    public void startGame() {
        System.out.println("Game Started!\n");
        displayAllPlayersInfo();
    }

    public static List<Player> getPlayers() {
        return players;
    }
    
    public static SideBoard[] getSideBoards() {
        return sideBoards;
    }
    
    public static int getToken() {
    	return token;
    }
}
