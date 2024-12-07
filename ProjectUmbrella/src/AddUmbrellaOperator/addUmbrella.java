import java.util.List;
import java.util.Scanner;
import AddUmbrellaFromTheLEFTSideBoard.AddUmbrellaFromTheLEFTSideBoard;
import AddUmbrellaFromTheRIGHTSideBoard.AddUmbrellaFromTheRIGHTSideBoard;
import AddUmbrellaFromTheBottomBoard.AddUmbrellaFromTheBottomBoard;
import AddUmbrellaFromTheCentreBoard.AddUmbrellaFromTheCentreBoard;
public class AddUmbrella {
    public static void main(String[] args) {
      
        Scanner scanner = new Scanner(System.in);

        // Switch to assign boards based on player
        switch (Player) {
            case 1:
                LeftBoard = SideBoard4;
                RightBoard = SideBoard1;
                Bottom = Bottom1;
                break;
            case 2:
                LeftBoard = SideBoard1;
                RightBoard = SideBoard2;
                Bottom = Bottom2;
                break;
            case 3:
                LeftBoard = SideBoard2;
                RightBoard = SideBoard3;
                Bottom = Bottom3;
                break;
            case 4:
                LeftBoard = SideBoard3;
                RightBoard = SideBoard4;
                Bottom = Bottom4;
                break;
        }

        int choice = scanner.nextInt();

        // Switch to perform the selected operation
        switch (choice) {
            case 1:
                AddUmbrellaFromTheLEFTSideBoard addLeft = new AddUmbrellaFromTheLEFTSideBoard();
                addLeft.addUmbrellaFromTheLeftSideBoard(Board, LeftBoard, RightBoard);
                break;

            case 2:
                AddUmbrellaFromTheRIGHTSideBoard addRight = new AddUmbrellaFromTheRIGHTSideBoard();
                addRight.addUmbrellaFromTheRightSideBoard(Board, LeftBoard, RightBoard);
                break;

            case 3:
                AddUmbrellaFromTheBottomBoard addBottom = new AddUmbrellaFromTheBottomBoard();
                addBottom.addUmbrellaFromTheBottomBoard(Board, Bottom);
                break;

            case 4:
                AddUmbrellaFromTheCentreBoard addCentre = new AddUmbrellaFromTheCentreBoard();
                addCentre.addUmbrellaFromTheCentreBoard(Board, CentreBoard, SightBoardLeft);
                break;
        }

    }
}
