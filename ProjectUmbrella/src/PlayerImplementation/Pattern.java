package PlayerImplementation;

public class Pattern {
    private int[][] positions;
    private boolean isCompleted;
    
    public Pattern(int[][] positions) {
        this.positions = new int[5][2];
        for (int i = 0; i < positions.length; i++) {
            this.positions[i] = positions[i].clone();
        }
        this.isCompleted = false;
    }
    
    public int[][] getPositions() {
        return positions;
    }
    
    public boolean isCompleted() {
        return isCompleted;
    }
    
    public void setCompleted(boolean completed) {
        this.isCompleted = completed;
    }

    public Pattern rotatePattern() {
        for (int i = 0; i < positions.length; i++) {
            int x = positions[i][0];
            int y = positions[i][1];
            positions[i][0] = y;
            positions[i][1] = 3 - x;
        }
        return this;
    }

    // public void displayPattern() {
    //     int[][] grid = new int[4][4]; // 4x4 grid
    //     for (int i = 0; i < positions.length - 1; i++) {
    //         grid[positions[i][0]][positions[i][1]] = 0;
    //     }
    //     int lastIndex = positions.length - 1;
    //     grid[positions[lastIndex][0]][positions[lastIndex][1]] = '*';

    //     for (int[] row : grid) {
    //         for (int cell : row) {
    //             if (cell == '*') {
    //                 System.out.print("* ");
    //             } else {
    //                 System.out.print("0 ");
    //             }
    //         }
    //         System.out.println();
    //     }
    // }
} 