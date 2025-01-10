package PlayerImplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PatternGenerator {
    private static final Random random = new Random();
    private static final int GRID_SIZE = 4;
    
    public static int[][] generateNewPattern() {
        int[][] positions = new int[5][2];
        generateCirclePositions(positions);
        return positions;
    }
    
    public static void generateCirclePositions(int[][] positions) {
        List<int[]> validPositions = new ArrayList<>();
        
        // Prepopulate valid positions excluding corners
        for (int x = 0; x < GRID_SIZE; x++) {
            for (int y = 0; y < GRID_SIZE; y++) {
                if ((x == 0 && y == 0) || (x == 0 && y == GRID_SIZE - 1) ||
                    (x == GRID_SIZE - 1 && y == 0) || (x == GRID_SIZE - 1 && y == GRID_SIZE - 1)) {
                    continue;
                }
                validPositions.add(new int[]{x, y});
            }
        }
        
        // Assign random positions for circles
        for (int i = 0; i < 4; i++) {
            int randomIndex = random.nextInt(validPositions.size());
            positions[i] = validPositions.get(randomIndex);
            validPositions.remove(randomIndex);
        }
        
        // Assign special point
        positions[4] = new int[]{0, 0};
    }
}
