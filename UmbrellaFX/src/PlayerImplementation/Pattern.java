package PlayerImplementation;

public class Pattern {
    private int[][] positions;
    private boolean isBlack;

    public Pattern(int[][] positions, boolean isBlack) {
        this.positions = positions;
        this.isBlack = isBlack;
    }

    public int[][] getPositions() {
        return positions;
    }

    public boolean isBlack() {
        return isBlack;
    }

    public Pattern rotatePattern() {
        int[][] newPositions = new int[positions.length][2];
        for (int i = 0; i < positions.length; i++) {
            newPositions[i][0] = positions[i][1];
            newPositions[i][1] = 3 - positions[i][0];
        }
        return new Pattern(newPositions, isBlack);
    }
}