package PlayerImplementation;

import java.util.HashMap;

public class TokenBoard {
	// HashMap to store color counts
    private HashMap<String, Integer> colorCount;

    // Constructor to initialize the HashMap with default values
    public TokenBoard() {
        colorCount = new HashMap<>();
        
        // Initialize the HashMap with the given colors and values
        colorCount.put("R", 0);
        colorCount.put("B", 0);
        colorCount.put("Y",0);
        colorCount.put("G", 0);
    }

    // Getter for the color count
    public HashMap<String, Integer> getColorCount() {
        return colorCount;
    }

    public void addToken(String color) {
        colorCount.put(color, colorCount.get(color) + 1);
    }
    
    public void printBoard() {
        System.out.println("TokenBoard Status:");
        for (String color : colorCount.keySet()) {
            System.out.println(color + ": " + colorCount.get(color));
        }
    }
}
