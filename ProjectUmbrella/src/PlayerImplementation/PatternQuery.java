package PlayerImplementation;

import PlayerImplementation.Pattern;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PatternQuery {
    private List<Pattern>[] patternSlots;  // Array of pattern lists
    private static final int SLOT_COUNT = 4;
    
    public PatternQuery() {
        // Initialize array of pattern lists
        patternSlots = new List[SLOT_COUNT];
        for (int i = 0; i < SLOT_COUNT; i++) {
            patternSlots[i] = new ArrayList<>();
        }
        // Pattern pattern1 = new Pattern(PatternGenerator.generateNewPattern());
        // Pattern pattern2 = new Pattern(PatternGenerator.generateNewPattern());
        // Pattern pattern3 = new Pattern(PatternGenerator.generateNewPattern());
        // Pattern pattern4 = new Pattern(PatternGenerator.generateNewPattern());
        // Pattern pattern12 = new Pattern(PatternGenerator.generateNewPattern());
        // this.addPattern(0, pattern1);
        // this.addPattern(0, pattern12);
        // this.addPattern(1, pattern2.rotatePattern());
        // this.addPattern(2, pattern3.rotatePattern().rotatePattern());
        // this.addPattern(3, pattern4.rotatePattern().rotatePattern().rotatePattern());   
    }

    
    // Add a pattern to a specific slot
    public void addPattern(int slotIndex, Pattern pattern) {
        if (slotIndex >= 0 && slotIndex < SLOT_COUNT) {
            patternSlots[slotIndex].add(pattern);
        }
    }
    
    // Remove pattern from specific slot and position
    public Pattern removePattern(int slotIndex, int positionInSlot) {
        if (slotIndex >= 0 && slotIndex < SLOT_COUNT && 
            positionInSlot >= 0 && positionInSlot < patternSlots[slotIndex].size()) {
            return patternSlots[slotIndex].remove(positionInSlot);
        }
        return null;
    }

    public void printFirstPatternsInSlots() {
        System.out.println("Patterns in slots:");
        for (int slot = 0; slot < SLOT_COUNT; slot++) {
            if (!patternSlots[slot].isEmpty()) {
                System.out.println("\nSlot " + slot + ":");
                Pattern pattern = patternSlots[slot].get(0);
                printPatternGrid(pattern);
            }
        }
    }

    private void printPatternGrid(Pattern pattern) {
        int[][] grid = new int[4][4];
        int[][] positions = pattern.getPositions();

        // Place regular points (first 4 points)
        for (int i = 0; i < 4; i++) {
            int x = positions[i][0];
            int y = positions[i][1];
            if (x >= 0 && x < 4 && y >= 0 && y < 4) {
                grid[x][y] = 1;
            }
        }

        // Place special point (last point)
        int specialX = positions[4][0];
        int specialY = positions[4][1];
        if (specialX >= 0 && specialX < 4 && specialY >= 0 && specialY < 4) {
            grid[specialX][specialY] = 2;
        }

        // Print the grid
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (grid[i][j] == 2) {
                    System.out.print("* ");
                } else if (grid[i][j] == 1) {
                    System.out.print("o ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
    }

    // Display a specific pattern in a slot
    public void displayPattern(int slotIndex, int patternIndex) {
        if (slotIndex >= 0 && slotIndex < SLOT_COUNT && 
            !patternSlots[slotIndex].isEmpty() && 
            patternIndex >= 0 && patternIndex < patternSlots[slotIndex].size()) {
            
            System.out.println("\nPattern " + patternIndex + " in Slot " + slotIndex + ":");
            Pattern pattern = patternSlots[slotIndex].get(patternIndex);
            printPatternGrid(pattern);
        } else {
            System.out.println("Pattern not found in slot " + slotIndex);
        }
    }

    // Display all patterns in all slots
    public void displayAllPatterns() {
        System.out.println("All Patterns in Query:");
        for (int slot = 0; slot < SLOT_COUNT; slot++) {
            if (!patternSlots[slot].isEmpty()) {
                System.out.println("\nSlot " + slot + ":");
                for (int i = 0; i < patternSlots[slot].size(); i++) {
                    System.out.println("Pattern " + i + ":");
                    Pattern pattern = patternSlots[slot].get(i);
                    printPatternGrid(pattern);
                }
            }
        }
    }

    // Method to get patterns in a specific slot
    public List<Pattern> getPatternsInSlot(int slotIndex) {
        return patternSlots[slotIndex];
    }

    public void addPattern(Pattern pattern) {
        for (int slot = 0; slot < SLOT_COUNT; slot++) {
            if (patternSlots[slot].isEmpty()) {
                patternSlots[slot].add(pattern);
                System.out.println("Pattern added to slot " + slot);
                return;
            }
        }
        
        System.out.println("Choose your pattern slot");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        patternSlots[choice].add(pattern);
        scanner.close();
        return;
    }

    public Pattern removePattern(int removePosition) {
        if (removePosition >= 0 && removePosition < 4) {
            List<Pattern> patterns = patternSlots[removePosition];
            if (!patterns.isEmpty()) {
                return patterns.remove(0); // Remove and return the first pattern
            }
        }
        return null; // Return null if no pattern is found
    }


    
} 
