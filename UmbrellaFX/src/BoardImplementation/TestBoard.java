package BoardImplementation;

public class TestBoard {

	 public static void main(String[] args) {
        // Create a board with STYLE1
        Board board1 = new Board(BoardStyle.style[0]);
        System.out.println("Board 1:");
        board1.printBoard();

        // Create a board with STYLE3
        Board board3 = new Board(BoardStyle.style[2]);
        System.out.println("\nBoard 3:");
        board3.printBoard();
	 }

}
