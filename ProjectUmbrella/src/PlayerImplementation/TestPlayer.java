package PlayerImplementation;

import BoardImplementation.Board;
import BoardImplementation.BoardStyle;

import java.util.List;

public class TestPlayer {

    public static void main(String[] args) {
        // Generate the random scoreboard using the Generator from PlayerImplementation package
        List<List<String>> permutations = Generator.generateRandomPermutationsArray();
        ScoreBoard scoreBoard = new ScoreBoard(permutations);
        
        // Create a player with the generated scoreboard and BoardStyle.STYLE1
        Player player1 = new Player("Player 1", 1, new Board(BoardStyle.STYLE1), scoreBoard);
        
        // Display player information
        player1.displayPlayerInfo();
    }
}
