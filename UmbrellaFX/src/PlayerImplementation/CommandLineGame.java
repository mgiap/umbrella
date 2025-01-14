package PlayerImplementation;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class CommandLineGame {

    // Main method to start the game
    public static void main(String[] args) {

        // Create 4 players with the boards and the scoreboard
        Player player1 = new Player("Player 1");
        Player player2 = new Player("Player 2");
        Player player3 = new Player("Player 3");
        Player player4 = new Player("Player 4");

        // Start the game
        startGame(player1, player2, player3, player4);
    }

    // Start the game with 4 players
    public static void startGame(Player player1, Player player2, Player player3, Player player4) {
        Scanner scanner = new Scanner(System.in);
        Player[] players = { player1, player2, player3, player4 };
        int currentPlayerIndex = 0;
        String command;

        while (true) {
            // Clear the screen and display the game state
            clearScreen();

            // Print the current state for the current player
            printBoardState(players[currentPlayerIndex]);

            // Display the current player's turn
            System.out.println("\nIt's " + players[currentPlayerIndex].getName() + "'s turn!");

            // Ask for user input
            System.out.print("\nEnter command (e.g., addFromLeft G 1 or exit): ");
            command = scanner.nextLine().trim();

            // Exit condition
            if (command.equalsIgnoreCase("exit")) {
                System.out.println("Exiting the game.");
                break;
            }

            // Execute the command for the current player
            executeCommand(command, players[currentPlayerIndex]);
            
            // Check the player's patterns
            HashMap<Integer, String> result = players[currentPlayerIndex].checkPattern();
            
            if (!result.isEmpty()) {
            	Pattern exchangePattern = players[currentPlayerIndex].chooseTokenToPut(result);
            	
            	players[(currentPlayerIndex + 1) % 4].getPatternQuery().addPattern(exchangePattern);
            }

            // Switch to the next player
            currentPlayerIndex = (currentPlayerIndex + 1) % 4;
        }

        scanner.close();
    }

    // Method to clear the console screen
    private static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    // Method to print the current state of the boards for a given player
    private static void printBoardState(Player player) {
        System.out.println("--- Current Board State ---");
        // Print visible pattern
        player.getPatternQuery().printFirstPatternsInSlots();
        
        // Print Score Board
        player.getScoreBoard().printScoreBoard();

        // Print Left Board
        System.out.println("Left Board:");
        player.getLeftBoard().printBoard();

        // Print Right Board
        System.out.println("\nRight Board:");
        player.getRightBoard().printBoard();

        // Print Middle Board
        System.out.println("\nMiddle Board:");
        player.getTopBoard().printBoard();

        // Print Bottom Board
        System.out.println("\nBottom Board:");
        player.getBottomBoard().printBoard();

        // Print Main Board
        System.out.println("\nMain Board:");
        player.getBoard().printBoard();
    }

    // Method to execute a command from the user for a specific player
    private static void executeCommand(String command, Player player) {
        String[] parts = command.split(" ");

        if (parts.length != 3) {
            System.out.println("Invalid command format. Example: addFromLeft G 1");
            return;
        }

        String action = parts[0];
        String token = parts[1];
        int position;

        try {
            position = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            System.out.println("Invalid position. Please enter a number.");
            return;
        }

        // Perform the action based on the command
        switch (action.toLowerCase()) {
            case "addfromleft":
                player.addFromLeft(token, position);
                break;
            case "addfromright":
                player.addFromRight(token, position);
                break;
            case "addfrommiddle":
                player.addFromTop(token, position);
                break;
            case "addfrombottom":
                player.addFromBottom(token, position);
                break;
            default:
                System.out.println("Unknown action: " + action);
                break;
        }
    }
}
