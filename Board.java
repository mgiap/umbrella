package BoardImplementation;

import java.util.HashMap;

public class Board {
	
	private ScoreBoard scoreBoard;
	private String[][] board;
	private HashMap<String, Integer> bottom;

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
}
