package Umbrella;

import javax.swing.*;
import java.awt.*;

public class PatternRotate extends JFrame {
    private static final int CELL_SIZE = 60;
    private static final int GRID_SIZE = 4;
    private int[][] positions;
    private static final int ROTATIONS_NEEDED = 4;
    private int rotationCount = 0;

    public PatternRotate() {
        setTitle("Pattern Rotation");
        setSize(GRID_SIZE * CELL_SIZE + 50, GRID_SIZE * CELL_SIZE + 50);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        positions = new int[][]{
            {0, 2}, // Circle 1
            {1, 1}, // Circle 2
            {2, 1}, // Circle 3
            {3, 1}, // Circle 4
            {0, 0}  // Special point
        };
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        // Draw grid with custom color
        g2d.setColor(new Color(200, 200, 240));
        for (int i = 0; i <= GRID_SIZE; i++) {
            g2d.setStroke(new BasicStroke(2));
            g2d.drawLine(25, i * CELL_SIZE + 25, GRID_SIZE * CELL_SIZE + 25, i * CELL_SIZE + 25);
            g2d.drawLine(i * CELL_SIZE + 25, 25, i * CELL_SIZE + 25, GRID_SIZE * CELL_SIZE + 25);
        }

        // Draw circles and special point
        for (int i = 0; i < positions.length; i++) {
            int x = positions[i][0] * CELL_SIZE + 25;
            int y = positions[i][1] * CELL_SIZE + 25;
            
            if (i == positions.length - 1) {
                // Special point as a star
                drawStar(g2d, x + CELL_SIZE/2, y + CELL_SIZE/2, 15);
            } else {
                // Black circles
                g2d.setColor(Color.BLACK);
                g2d.setStroke(new BasicStroke(2));
                g2d.fillOval(x + 10, y + 10, CELL_SIZE - 20, CELL_SIZE - 20);
            }
        }
    }

    // Helper method to draw a star
    private void drawStar(Graphics2D g2d, int x, int y, int size) {
        int[] xpoints = new int[10];
        int[] ypoints = new int[10];
        
        for (int i = 0; i < 10; i++) {
            double angle = i * Math.PI / 5;
            int r = (i % 2 == 0) ? size : size/2;
            xpoints[i] = (int)(x + r * Math.cos(angle));
            ypoints[i] = (int)(y + r * Math.sin(angle));
        }
        
        g2d.setColor(Color.RED);
        g2d.fillPolygon(xpoints, ypoints, 10);
        g2d.setColor(Color.YELLOW);
        g2d.setStroke(new BasicStroke(2));
        g2d.drawPolygon(xpoints, ypoints, 10);
    }

    public static void rotatePositions(int[][] positions, int n) {
        for (int i = 0; i < positions.length; i++) {
            int x = positions[i][0];
            int y = positions[i][1];
            positions[i][0] = y;
            positions[i][1] = n - 1 - x;
        }
    }

    public static void main(String[] args) {
        PatternRotate frame = new PatternRotate();
        frame.setVisible(true);

        // Rotate with delay
        Timer timer = new Timer(1000, e -> {
            rotatePositions(frame.positions, GRID_SIZE);
            frame.repaint();
            frame.rotationCount++;
            
            // Stop after desired number of rotations
            if (frame.rotationCount >= ROTATIONS_NEEDED) {
                ((Timer)e.getSource()).stop();
            }
        });
        timer.setRepeats(true);
        timer.setInitialDelay(1000);
        timer.start();
    }
}