package AddUmbrellaFromTheRIGHTSideBoard;

import java.util.List;
import java.util.Scanner;

public class AddUmbrellaFromTheRIGHTSideBoard {

    // Method to add an umbrella from the right side board
    public void addUmbrellaFromTheRightSideBoard(char[][] Board, 
                                                 List<Character> LeftBoard, 
                                                 List<Character> RightBoard) {
        Scanner scanner = new Scanner(System.in);

        // Ask user to input the umbrella character they want to move
        System.out.println("Enter the umbrella character to move:");
        char umbrella = scanner.next().charAt(0); // Correct method to get a single character input

        // Check if the umbrella exists in the RightBoard
        if (!RightBoard.contains(umbrella)) {
            System.out.println("The umbrella does not exist in the Right SideBoard. Try again.");
            return;
        }

        // Ask the user for the row they want to move the umbrella to
        System.out.println("Enter the row number (1-4) to move the umbrella:");
        int PlayerChoice = scanner.nextInt();

        // Validate the row choice
        if (PlayerChoice < 1 || PlayerChoice > 4) {
            System.out.println("Invalid row choice. Please enter a number between 1 and 4.");
            return;
        }

        // Remove the umbrella from the RightBoard
        RightBoard.remove(Character.valueOf(umbrella));

        // Get the umbrella to be removed from the selected row
        char RemoveUmbrella = Board[PlayerChoice - 1][3]; // PlayerChoice is 1-indexed, array is 0-indexed

        // Use a switch-case for the selected row to perform the movement
        switch (PlayerChoice) {
            case 1:
                // Shift all elements in row 0 (first row) to the left
                for (int i = 0; i < 3; i++) {
                    Board[0][i] = Board[0][i + 1];
                }
                Board[0][3] = umbrella; // Add the new umbrella to the end of the row
                break;

            case 2:
                for (int i = 0; i < 3; i++) {
                    Board[1][i] = Board[1][i + 1];
                }
                Board[1][3] = umbrella;
                break;

            case 3:
                for (int i = 0; i < 3; i++) {
                    Board[2][i] = Board[2][i + 1];
                }
                Board[2][3] = umbrella;
                break;

            case 4:
                for (int i = 0; i < 3; i++) {
                    Board[3][i] = Board[3][i + 1];
                }
                Board[3][3] = umbrella;
                break;

            default:
                System.out.println("Invalid row selection.");
        }

        // Add the removed umbrella to the Left SideBoard
        LeftBoard.add(RemoveUmbrella);

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
