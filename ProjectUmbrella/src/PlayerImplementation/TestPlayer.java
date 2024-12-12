package PlayerImplementation;

import BoardImplementation.*;

public class TestPlayer {

    public static void main(String[] args) {

        // Create a player with the boards and the scoreboard
        Player player1 = new Player("Player 1", 1);
        player1.getPatternQuery().displayAllPatterns();
    }
}


