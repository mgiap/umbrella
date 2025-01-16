package BoardImplementation;

public class Board {
	
	private String[][] board;
	

    public Board(String[][] style) {
        this.board = style;
    }

    public void printBoard() {
        for (String[] row : board) {
            for (String cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

	public String[][] getBoard() {
		return board;
	}
}
