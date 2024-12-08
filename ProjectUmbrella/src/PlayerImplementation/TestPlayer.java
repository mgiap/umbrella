package PlayerImplementation;

import BoardImplementation.Board;
import BoardImplementation.BoardStyle;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestPlayer {

    public static void main(String[] args) {

        // Create ScoreBoard for the players
        ScoreBoard scoreBoard1 = new ScoreBoard();
        
        // Create SideBoards (simulating shared boards)
        SideBoard board1 = new SideBoard();
        SideBoard board2 = new SideBoard();

        // Create a player with the boards and the scoreboard
        Player player1 = new Player("Player 1", 1, new Board(BoardStyle.STYLE1), scoreBoard1, board1, board2);

        // Create a Middle Board (similar to TokenBoard)
        TokenBoard middleBoard = new TokenBoard();

        // Set up the main GUI
        JFrame frame = new JFrame("Single Player Game");
        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Player's name and score (example)
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        JLabel playerInfo = new JLabel("Player 1 - Score: 0", SwingConstants.CENTER);
        topPanel.add(playerInfo, BorderLayout.CENTER);
        frame.add(topPanel, BorderLayout.NORTH);

        // Panel for all boards (Main, Left, Right, Bottom, Middle, Score)
        JPanel boardsPanel = new JPanel();
        boardsPanel.setLayout(new GridBagLayout()); // Using GridBagLayout for flexible positioning

        // Create constraints for GridBagLayout
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.CENTER;

        // Middle Board
        constraints.gridwidth = 3; // Spanning 3 columns (Left, Main, Right)
        constraints.gridx = 0;
        constraints.gridy = 0;
        boardsPanel.add(createBoardPanel(middleBoard, "Middle"), constraints);

        // Score Board
        constraints.gridy = 1; // Below the Middle Board
        constraints.gridwidth = 3;
        boardsPanel.add(createScoreBoardPanel(player1.getScoreBoard()), constraints);

        // Left Board
        constraints.gridwidth = 1;
        constraints.gridx = 0;
        constraints.gridy = 2; // Below the ScoreBoard
        constraints.insets = new Insets(0, 0, 0, 20); // Add space to the right (20px) of the Left Board
        boardsPanel.add(createBoardPanel(player1.getLeftBoard(), "Left"), constraints);

        // Main Board
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.insets = new Insets(0, 0, 0, 0); // Reset insets for the Main Board
        boardsPanel.add(createBoardPanelFromArray(player1.getBoard().getBoard(), "Main"), constraints);

        // Right Board
        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.insets = new Insets(0, 20, 0, 0); // Add space to the left (20px) of the Right Board
        boardsPanel.add(createBoardPanel(player1.getRightBoard(), "Right"), constraints);

        // Bottom Board
        constraints.gridx = 1;
        constraints.gridy = 3; // Below the Main Board
        constraints.insets = new Insets(0, 0, 0, 0); // Reset insets for Bottom Board
        boardsPanel.add(createBoardPanel(player1.getBottomBoard(), "Bottom"), constraints);

        frame.add(boardsPanel, BorderLayout.CENTER);



        // Display the window
        frame.setVisible(true);
    }

    // Helper method to create a Board (Main) Panel with a color grid
    private static JPanel createBoardPanelFromArray(String[][] boardArray, String boardName) {
        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new BorderLayout());

        // Add the board title
        JLabel boardLabel = new JLabel(boardName + " Board");
        boardLabel.setHorizontalAlignment(SwingConstants.CENTER);
        boardPanel.add(boardLabel, BorderLayout.NORTH);

        // Create the grid for the main board
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(4, 4));  // 4x4 grid for the main board

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                String token = boardArray[i][j];
                // Create a TokenLabel to represent the token
                TokenLabel tokenLabel = new TokenLabel(token);
                gridPanel.add(tokenLabel);
            }
        }
        boardPanel.add(gridPanel, BorderLayout.CENTER);

        return boardPanel;
    }

    // Helper method to create a Side Board (HashMap) Panel
    private static JPanel createBoardPanel(TokenBoard sideBoard, String boardName) {
        JPanel sideBoardPanel = new JPanel();
        sideBoardPanel.setLayout(new BorderLayout());

        // Add the side board title
        JLabel boardLabel = new JLabel(boardName + " Side Board");
        boardLabel.setHorizontalAlignment(SwingConstants.CENTER);
        sideBoardPanel.add(boardLabel, BorderLayout.NORTH);

        // Create a panel to display color counts from the side board (HashMap)
        JPanel colorPanel = new JPanel();
        colorPanel.setLayout(new GridLayout(4, 1));  // 4 colors: R, Y, G, B

        HashMap<String, Integer> colorCount = sideBoard.getColorCount();
        for (Map.Entry<String, Integer> entry : colorCount.entrySet()) {
            String color = entry.getKey();
            Integer count = entry.getValue();

            // Create a label for each color and count
            TokenLabel tokenLabel = new TokenLabel(color, count);
            colorPanel.add(tokenLabel);
        }

        sideBoardPanel.add(colorPanel, BorderLayout.CENTER);

        return sideBoardPanel;
    }

    // Custom JLabel to display colored token
    static class TokenLabel extends JLabel {
        private String token;
        private int count;

        // Constructor for creating a token with count
        public TokenLabel(String token) {
            this.token = token;
            this.count = 1; // Default count if not specified
            setPreferredSize(new Dimension(50, 50));
            setHorizontalAlignment(SwingConstants.CENTER);
            setVerticalAlignment(SwingConstants.CENTER);
            setOpaque(true);
            setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }

        // Constructor for creating a label with a color and count
        public TokenLabel(String token, int count) {
            this.token = token;
            this.count = count;
            setPreferredSize(new Dimension(50, 50));
            setHorizontalAlignment(SwingConstants.CENTER);
            setVerticalAlignment(SwingConstants.CENTER);
            setOpaque(true);
            setBorder(BorderFactory.createLineBorder(Color.BLACK));
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            // Set the color based on the token
            switch (token) {
                case "R":
                    g.setColor(Color.RED);
                    break;
                case "B":
                    g.setColor(Color.BLUE);
                    break;
                case "G":
                    g.setColor(Color.GREEN);
                    break;
                case "Y":
                    g.setColor(Color.YELLOW);
                    break;
                default:
                    g.setColor(Color.WHITE); // Default to white if the token is unknown
                    break;
            }

            // Draw a filled circle in the middle of the label
            g.fillOval(10, 10, 30, 30);  // Position and size of the circle

            // Draw the count next to the token
            g.setColor(Color.BLACK);
            g.drawString(String.valueOf(count), 35, 25);
        }
    }
    
 // Helper method to create a compact ScoreBoard panel
    private static JPanel createScoreBoardPanel(ScoreBoard scoreBoard) {
        JPanel scorePanel = new JPanel();
        scorePanel.setLayout(new BorderLayout());

        // ScoreBoard title
        JLabel scoreBoardLabel = new JLabel("Scoreboard");
        scoreBoardLabel.setHorizontalAlignment(SwingConstants.CENTER);
        scorePanel.add(scoreBoardLabel, BorderLayout.NORTH);

        // Compact panel for tokens
        JPanel compactPanel = new JPanel();
        compactPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5)); // Centered flow layout

        // Add each permutation as tokens with separators
        for (List<String> permutation : scoreBoard.getPermutations()) {
            for (String token : permutation) {
                TokenLabel tokenLabel = new TokenLabel(token); // Colored token
                tokenLabel.setPreferredSize(new Dimension(20, 20)); // Smaller size for compact display
                compactPanel.add(tokenLabel);
            }

            // Separator for " | " between groups
            JLabel separator = new JLabel(" | ");
            separator.setFont(new Font("Arial", Font.BOLD, 12));
            compactPanel.add(separator);
        }

        scorePanel.add(compactPanel, BorderLayout.CENTER);
        return scorePanel;
    }

}
