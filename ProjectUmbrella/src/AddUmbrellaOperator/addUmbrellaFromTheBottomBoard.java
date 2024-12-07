package AddUmbrellaFromTheBottomBoard;

import java.util.List;
import java.util.Scanner;

public class AddUmbrellaFromTheBottomBoard {

    public void addUmbrellaFromTheBottomBoard(char[][] Board, 
                                               List<Character> Bottom, 
                                               List<Character> CentreBoard) {
        Scanner scanner = new Scanner(System.in);

        // Ask the user to input the umbrella character to move
        System.out.println("Enter the umbrella character to move:");
        char umbrella = scanner.next().charAt(0);

        // Check if the provided umbrella exists in the Bottom list
        if (!Bottom.contains(umbrella)) {
            System.out.println("The umbrella does not exist in the Bottom list.");
            return;
        }

        // Remove the umbrella from the Bottom list
        Bottom.remove(Character.valueOf(umbrella));

        // Ask the user for the column to move the umbrella
        System.out.println("Enter the column number (1-4) to move the umbrella:");
        int PlayerChoice = scanner.nextInt();

        // Validate the input for column choice
        if (PlayerChoice < 1 || PlayerChoice > 4) {
            System.out.println("Invalid column choice. Please select a number between 1 and 4.");
            return;
        }

        // Identify the umbrella to remove from the selected column
        char RemoveUmbrella = Board[3][PlayerChoice - 1]; // Bottom-most element in the chosen column

        // Perform the shift operation for the given column
        switch (PlayerChoice) {
            case 1:
                for (int i = 3; i > 0; i--) { // Shift elements from bottom to top in column 0
                    Board[i][0] = Board[i - 1][0];
                }
                Board[0][0] = umbrella;
                break;

            case 2:
                for (int i = 3; i > 0; i--) { // Shift elements from bottom to top in column 1
                    Board[i][1] = Board[i - 1][1];
                }
                Board[0][1] = umbrella;
                break;

            case 3:
                for (int i = 3; i > 0; i--) { // Shift elements from bottom to top in column 2
                    Board[i][2] = Board[i - 1][2];
                }
                Board[0][2] = umbrella;
                break;

            case 4:
                for (int i = 3; i > 0; i--) { // Shift elements from bottom to top in column 3
                    Board[i][3] = Board[i - 1][3];
                }
                Board[0][3] = umbrella;
                break;

            default:
                System.out.println("Invalid column choice.");
        }

        // Add the removed umbrella to the Centre Board
        CentreBoard.add(RemoveUmbrella);

        // Debugging: Print the updated board and sideboards for verification
        System.out.println("Updated Board:");
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(Board[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Bottom Board: " + Bottom);
        System.out.println("Centre Board: " + CentreBoard);
    }
}
