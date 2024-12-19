package PlayerImplementation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TokenBoardGenerator {
    public static TokenBoard[] generateTokenBoards() {
        // Create a list with 20 tokens: 5 Red (R), 5 Blue (B), 5 Green (G), 5 Yellow (Y)
        List<String> tokens = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            tokens.add("R");
            tokens.add("B");
            tokens.add("G");
            tokens.add("Y");
        }

        // Shuffle the tokens randomly
        Collections.shuffle(tokens);

        // Initialize 4 TokenBoards
        TokenBoard[] tokenBoards = new TokenBoard[4];
        for (int i = 0; i < 4; i++) {
            tokenBoards[i] = new TokenBoard();
        }

        // Distribute tokens across the 4 TokenBoards
        for (int i = 0; i < tokens.size(); i++) {
            String token = tokens.get(i);
            tokenBoards[i % 4].addToken(token); // Round-robin distribution
        }

        return tokenBoards;
    }
}
