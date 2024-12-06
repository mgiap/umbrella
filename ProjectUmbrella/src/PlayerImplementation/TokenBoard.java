package PlayerImplementation;

import java.util.HashMap;

public class TokenBoard {
	// HashMap to store color counts
    private HashMap<String, Integer> colorCount;

    // Constructor to initialize the HashMap with default values
    public TokenBoard() {
        colorCount = new HashMap<>();
        
        // Initialize the HashMap with the given colors and values
        colorCount.put("R", 1);
        colorCount.put("B", 1);
        colorCount.put("Y", 1);
        colorCount.put("G", 1);
    }

    // Getter for the color count
    public HashMap<String, Integer> getColorCount() {
        return colorCount;
    }
}
