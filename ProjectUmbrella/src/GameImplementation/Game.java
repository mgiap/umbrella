package GameImplementation;

import PlayerImplementation.Generator;
import PlayerImplementation.Player;
import PlayerImplementation.ScoreBoard;
import BoardImplementation.Board;
import BoardImplementation.BoardStyle;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players;
    private Generator generator; // Generator to create random ScoreBoards

    public Game() {
        // Initialize the players list and the generator
        players = new ArrayList<>();
        generator = new Generator();

        // Manually define the 4 different Board styles
        Board board1 = new Board(BoardStyle.STYLE1);  // Using STYLE1 from BoardStyle
        Board board2 = new Board(BoardStyle.STYLE2);  // Using STYLE2 from BoardStyle
        Board board3 = new Board(BoardStyle.STYLE3);  // Using STYLE3 from BoardStyle
        Board board4 = new Board(BoardStyle.STYLE4);  // Using STYLE4 from BoardStyle

        // Add players with different boards and scoreboards
        for (int i = 0; i < 4; i++) {
            // Assign each player a unique board style
            Board board = null;
            switch (i) {
                case 0:
                    board = board1;
                    break;
                case 1:
                    board = board2;
                    break;
                case 2:
                    board = board3;
                    break;
                case 3:
                    board = board4;
                    break;
            }

            // Using the generator to create the ScoreBoard
            ScoreBoard scoreBoard = new ScoreBoard(generator.generateRandomPermutationsArray());

            // Create the player with the board and scoreBoard
            Player player = new Player("Player " + (i + 1), i + 1, board, scoreBoard);
            players.add(player);
        }
    }

    // Method to display information of all players
    public void displayAllPlayersInfo() {
        for (Player player : players) {
            player.displayPlayerInfo();
            System.out.println("\n--------------------------\n");
        }
    }

    // Method to start the game (for now, just display info)
    public void startGame() {
        System.out.println("Game Started!\n");
        displayAllPlayersInfo(); // Display information of all players
    }

    public List<Player> getPlayers() {
        return players;
    }
}
