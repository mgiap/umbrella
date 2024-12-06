package GameImplementation;

import PlayerImplementation.*;
import BoardImplementation.*;

import java.util.ArrayList;
import java.util.List;

public class Game {
    protected static List<Player> players;
    private Generator generator;

    public Game() {
        // Initialize players and generator
        players = new ArrayList<>();
        generator = new Generator();

        // Initialize the 4 different Board styles
        Board board1 = new Board(BoardStyle.STYLE1);
        Board board2 = new Board(BoardStyle.STYLE2);
        Board board3 = new Board(BoardStyle.STYLE3);
        Board board4 = new Board(BoardStyle.STYLE4);

        // Initialize 4 SideBoards for the circular seating arrangement
        SideBoard[] sideBoards = new SideBoard[4];
        for (int i = 0; i < 4; i++) {
            sideBoards[i] = new SideBoard();
        }

        // Create and assign players
        for (int i = 0; i < 4; i++) {
            // Assign board style
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

            // Assign side boards with circular logic
            SideBoard leftBoard = sideBoards[i];
            SideBoard rightBoard = sideBoards[(i + 1) % 4];

            // Generate a scoreboard for the player
            ScoreBoard scoreBoard = new ScoreBoard(generator.generateRandomPermutationsArray());

            // Create player and add to the list
            Player player = new Player("Player " + (i + 1), i + 1, board, scoreBoard, leftBoard, rightBoard);
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

    public List<Player> getPlayers() {
        return players;
    }
}
