package AddUmbrellaFromTheLEFTSideBoard;

import java.util.List;
import java.util.Scanner;

public class AddUmbrellaFromTheLEFTSideBoard {

    public void addUmbrellaFromTheLeftSideBoard(char[][] Board, 
                                                List<Character> LeftBoard, 
                                                List<Character> RightBoard) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user to input the umbrella character to move
        System.out.println("Enter the umbrella character to move:");
        char umbrella = scanner.next().charAt(0); // Correctly capture a single character from input

        // Validate if the umbrella exists in the LeftBoard
        if (!LeftBoard.contains(umbrella)) {
            System.out.println("The umbrella does not exist in the Left SideBoard. Try again.");
            return;
        }

        // Ask the user for the row to add the umbrella
        System.out.println("Enter the row number (1-4) to move the umbrella:");
        int PlayerChoice = scanner.nextInt();

        // Validate the player's row choice
        if (PlayerChoice < 1 || PlayerChoice > 4) {
            System.out.println("Invalid row choice. Please select a number between 1 and 4.");
            return;
        }

        // Remove the umbrella from the LeftBoard
        LeftBoard.remove(Character.valueOf(umbrella));

        // Get the umbrella to be removed from the selected row
        char RemoveUmbrella = Board[PlayerChoice - 1][0]; // First element of the chosen row

        // Perform the operation based on PlayerChoice using a switch-case
        switch (PlayerChoice) {
            case 1:
                for (int i = 3; i > 0; i--) { // Shift elements in row 0 (left to right)
                    Board[0][i] = Board[0][i - 1];
                }
                Board[0][0] = umbrella; // Place the umbrella at the start of row 0
                break;

            case 2:
                for (int i = 3; i > 0; i--) { // Shift elements in row 1
                    Board[1][i] = Board[1][i - 1];
                }
                Board[1][0] = umbrella;
                break;

            case 3:
                for (int i = 3; i > 0; i--) { // Shift elements in row 2
                    Board[2][i] = Board[2][i - 1];
                }
                Board[2][0] = umbrella;
                break;

            case 4:
                for (int i = 3; i > 0; i--) { // Shift elements in row 3
                    Board[3][i] = Board[3][i - 1];
                }
                Board[3][0] = umbrella;
                break;

            default:
                System.out.println("Invalid row selection.");
        }

        // Add the removed umbrella to the Right SideBoard
        RightBoard.add(RemoveUmbrella);

        // Debugging: Print the updated board and sideboards for verification
        System.out.println("Updated Board:");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(Board[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Left SideBoard: " + LeftBoard);
        System.out.println("Right SideBoard: " + RightBoard);
    }
}
