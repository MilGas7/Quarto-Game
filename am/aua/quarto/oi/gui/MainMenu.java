package am.aua.quarto.oi.gui;

import javax.swing.*;
import java.awt.*;

/**
 * The {@code MainMenu} class represents the starting window of the Quarto game.
 * It provides two primary options: start the game or view instructions.
 */
public class MainMenu extends JFrame {

    /**
     * Constructs a new MainMenu window.
     */
    public MainMenu() {
        super("Quarto - Main Menu");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(10, 10));
        setSize(400, 300);
        setLocationRelativeTo(null);

        JLabel title = new JLabel("QUARTO", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 36));
        add(title, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(2, 1, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        JButton playButton = new JButton("Play");
        playButton.setFont(new Font("Arial", Font.PLAIN, 24));
        playButton.addActionListener(e -> openGameModeSelector());

        JButton instructionsButton = new JButton("Instructions");
        instructionsButton.setFont(new Font("Arial", Font.PLAIN, 24));
        instructionsButton.addActionListener(e -> showInstructions());

        buttonPanel.add(playButton);
        buttonPanel.add(instructionsButton);
        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    /**
     * Opens the game mode selection window and closes the main menu.
     */
    private void openGameModeSelector() {
        SwingUtilities.invokeLater(() -> {
            this.dispose();
            new GameModeSelector();
        });
    }

    /**
     * Displays a dialog with a brief summary of the Quarto game rules.
     */
    private void showInstructions() {
        String instructions = "Quarto Game Rules:\n\n" +
                "1. Players take turns choosing a piece for their opponent to place\n" +
                "2. The goal is to place 4 pieces in a row with at least one common attribute\n" +
                "3. Attributes: color, size, shape, and hole presence\n" +
                "4. First to create a Quarto (4 in a row) wins!";

        JOptionPane.showMessageDialog(this, instructions, "Instructions", JOptionPane.INFORMATION_MESSAGE);
    }
}
