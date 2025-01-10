package GameImplementation;

import PlayerImplementation.*;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.List;

public class TestGame {

    public static void main(String[] args) {

        Game game = new Game();
        Player player1 = new Player("Player 1");
        // Testing boards' integrity
        player1.getTopBoard().getColorCount().put("R", 5);
        Game.getPlayers().get(0).getRightBoard().getColorCount().put("R", 2);
        
        // Set up the main GUI
        JFrame frame = new JFrame("4-Player Game");
        frame.setSize(1500, 1500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Main panel with GridBagLayout to arrange the boards
        JPanel mainPanel = new JPanel(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(10, 10, 10, 10);

        // Add the Middle Board
        constraints.gridx = 1;
        constraints.gridy = 1;
        mainPanel.add(createBoardPanel(player1.getTopBoard(), "Middle Board"), constraints);

        // Add the shared side boards (not inside player areas)
        constraints.gridx = 0;
        constraints.gridy = 0;
        mainPanel.add(createBoardPanel(Game.getSideBoards()[3], "Side Board 4"), constraints);

        constraints.gridx = 2;
        constraints.gridy = 0;
        mainPanel.add(createBoardPanel(Game.getSideBoards()[2], "Side Board 3"), constraints);

        constraints.gridx = 2;
        constraints.gridy = 2;
        mainPanel.add(createBoardPanel(Game.getSideBoards()[1], "Side Board 2"), constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        mainPanel.add(createBoardPanel(Game.getSideBoards()[0], "Side Board 1"), constraints);

        // Player 1 (Bottom Area)
        constraints.gridx = 1;
        constraints.gridy = 2;
        mainPanel.add(createPlayerArea(Game.getPlayers().get(0), 1), constraints);

        // Player 2 (Right Area)
        constraints.gridx = 2;
        constraints.gridy = 1;
        mainPanel.add(createPlayerArea(Game.getPlayers().get(1), 2), constraints);

        // Player 3 (Top Area)
        constraints.gridx = 1;
        constraints.gridy = 0;
        mainPanel.add(createPlayerArea(Game.getPlayers().get(2), 3), constraints);

        // Player 4 (Left Area)
        constraints.gridx = 0;
        constraints.gridy = 1;
        mainPanel.add(createPlayerArea(Game.getPlayers().get(3), 4), constraints);

        // Add the main panel to the frame
        frame.add(mainPanel, BorderLayout.CENTER);
        
        

        // Display the frame
        frame.setVisible(true);
    }

    // Helper method to create the player area
    private static JPanel createPlayerArea(Player player, int playerNumber) {
        JPanel playerArea = new JPanel(new BorderLayout());

        // Create the Scoreboard Panel
        JPanel scoreBoardPanel = createScoreBoardPanel(player.getScoreBoard(), "Score Board " + playerNumber);
        playerArea.add(scoreBoardPanel, BorderLayout.NORTH);

        // Create the Main Board Panel
        JPanel mainBoardPanel = createBoardPanelFromArray(player.getBoard().getBoard(), "Main Board " + playerNumber);
        playerArea.add(mainBoardPanel, BorderLayout.CENTER);

        // Create the Bottom Board Panel
        JPanel bottomBoardPanel = createBoardPanel(player.getBottomBoard(), "Bottom Board " + playerNumber);
        playerArea.add(bottomBoardPanel, BorderLayout.SOUTH);

        return playerArea;
    }

    // Helper method to create a Scoreboard Panel
    private static JPanel createScoreBoardPanel(ScoreBoard scoreBoard, String boardName) {
        JPanel scoreBoardPanel = new JPanel();
        scoreBoardPanel.setLayout(new BorderLayout());

        // Add the scoreboard title
        JLabel boardLabel = new JLabel(boardName);
        boardLabel.setHorizontalAlignment(SwingConstants.CENTER);
        scoreBoardPanel.add(boardLabel, BorderLayout.NORTH);

        // Display the tokens
        JPanel tokenPanel = new JPanel();
        tokenPanel.setLayout(new FlowLayout());
        for (List<String> permutation : scoreBoard.getScoreBoard()) {
            for (String token : permutation) {
                tokenPanel.add(new TokenLabel(token));
            }
            tokenPanel.add(Box.createHorizontalStrut(10)); // Space between permutations
        }

        scoreBoardPanel.add(tokenPanel, BorderLayout.CENTER);

        return scoreBoardPanel;
    }

    // Helper method to create a Board (Main) Panel with tokens
    private static JPanel createBoardPanelFromArray(String[][] boardArray, String boardName) {
        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new BorderLayout());

        // Add the board title
        JLabel boardLabel = new JLabel(boardName);
        boardLabel.setHorizontalAlignment(SwingConstants.CENTER);
        boardPanel.add(boardLabel, BorderLayout.NORTH);

        // Create the grid for the main board
        JPanel gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(4, 4));  // 4x4 grid for the main board

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                String token = boardArray[i][j];
                TokenLabel tokenLabel = new TokenLabel(token);
                gridPanel.add(tokenLabel);
            }
        }
        boardPanel.add(gridPanel, BorderLayout.CENTER);

        return boardPanel;
    }

    // Helper method to create a generic Board Panel with colored tokens and their quantities
    private static JPanel createBoardPanel(TokenBoard board, String boardName) {
        JPanel boardPanel = new JPanel();
        boardPanel.setLayout(new BorderLayout());

        // Add the board title
        JLabel boardLabel = new JLabel(boardName);
        boardLabel.setHorizontalAlignment(SwingConstants.CENTER);
        boardPanel.add(boardLabel, BorderLayout.NORTH);

        // Panel to display color counts with tokens
        JPanel colorCountPanel = new JPanel();
        colorCountPanel.setLayout(new GridLayout(0, 2, 10, 10)); // Two columns: Token + Count

        // Get the color counts from the board
        HashMap<String, Integer> colorCounts = board.getColorCount();
        for (String color : colorCounts.keySet()) {
            int count = colorCounts.get(color);

            // Create a panel for each color row
            JPanel rowPanel = new JPanel();
            rowPanel.setLayout(new FlowLayout(FlowLayout.LEFT));

            // Add the colored token
            JLabel tokenLabel = new JLabel();
            tokenLabel.setPreferredSize(new Dimension(20, 20)); // Small circle size
            tokenLabel.setOpaque(true);
            tokenLabel.setBackground(getTokenColor(color));
            tokenLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            
            // Add a label with the count
            JLabel countLabel = new JLabel("× " + count);

            // Add the token and count to the row
            rowPanel.add(tokenLabel);
            rowPanel.add(countLabel);

            // Add the row panel to the main color count panel
            colorCountPanel.add(rowPanel);
        }

        boardPanel.add(colorCountPanel, BorderLayout.CENTER);

        return boardPanel;
    }

    // Helper method to convert a token string into a Color
    private static Color getTokenColor(String token) {
        switch (token) {
            case "R": return Color.RED;
            case "B": return Color.BLUE;
            case "G": return Color.GREEN;
            case "Y": return Color.YELLOW;
            default: return Color.GRAY; // Default for unknown tokens
        }
    }


    // Custom JLabel to display colored tokens
    static class TokenLabel extends JLabel {
        private String token;

        public TokenLabel(String token) {
            this.token = token;
            setPreferredSize(new Dimension(20, 20));
            setOpaque(true);
            setHorizontalAlignment(SwingConstants.CENTER);
            setVerticalAlignment(SwingConstants.CENTER);
            setBackground(getTokenColor(token));
            setBorder(BorderFactory.createLineBorder(Color.BLACK));
            setText(token); // Display token text
        }

        private Color getTokenColor(String token) {
            if ("R".equals(token)) {
                return Color.RED;
            } else if ("B".equals(token)) {
                return Color.BLUE;
            } else if ("G".equals(token)) {
                return Color.GREEN;
            } else if ("Y".equals(token)) {
                return Color.YELLOW;
            } else {
                return Color.WHITE;
            }
        }
    }
}
