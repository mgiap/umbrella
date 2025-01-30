package PlayerImplementation;

// Pattern class for game piece configurations - Author: Hoang Quang Nhat
public class Pattern {
    private int[][] positions;
    private boolean isBlack;

    // Constructor initializes positions and color state
    public Pattern(int[][] positions, boolean isBlack) {
        this.positions = positions;
        this.isBlack = isBlack;
    }

    // Returns stored position coordinates
    public int[][] getPositions() {
        return positions;
    }

    // Returns true if pattern is black or not (flip or not flip)
    public boolean isBlack() {
        return isBlack;
    }

    // Rotate pattern 90 degrees clockwise
    public Pattern rotatePattern() {
        int[][] newPositions = new int[positions.length][2];
        for (int i = 0; i < positions.length; i++) {
            newPositions[i][0] = positions[i][1];
            newPositions[i][1] = 3 - positions[i][0];
        }
        return new Pattern(newPositions, isBlack);
    }
}
