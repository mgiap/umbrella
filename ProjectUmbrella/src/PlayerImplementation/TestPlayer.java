package PlayerImplementation;

import BoardImplementation.*;

public class TestPlayer {

    public static void main(String[] args) {
        
        // Create SideBoards (simulating shared boards)
        SideBoard board1 = new SideBoard();
        SideBoard board2 = new SideBoard();

        // Create a player with the boards and the scoreboard
        Player player1 = new Player("Player 1", 1, new Board(BoardStyle.STYLE1), board1, board2);
    }
}


