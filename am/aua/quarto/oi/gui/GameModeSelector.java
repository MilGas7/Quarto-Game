package am.aua.quarto.oi.gui;

import am.aua.quarto.core.DuelGame;
import am.aua.quarto.core.Game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The {@code GameModeSelector} class displays a graphical user interface for
 * selecting between different game modes in the Quarto game: Duel, Solo, or Adventurous.
 */
public class GameModeSelector extends JFrame {

    /**
     * Constructs a new GameModeSelector window and initializes the UI components.
     */
    public GameModeSelector() {
        super("Select Game Mode");
        initializeUI();
    }

    /**
     * Initializes the user interface layout and components.
     * Sets up the title label and game mode selection buttons.
     */
    private void initializeUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(400, 300);
        setLocationRelativeTo(null);

        JLabel title = new JLabel("Select Game Mode", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 24));
        add(title, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(20, 50, 20, 50));

        String[] modes = {"Duel Game", "Solo Game", "Adventurous Game"};
        for (String mode : modes) {
            JButton button = new JButton(mode);
            button.setFont(new Font("Arial", Font.PLAIN, 18));
            button.addActionListener(new ModeSelectionListener(mode));
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);
        setVisible(true);
    }

    /**
     * A private inner class that handles game mode button selections.
     */
    private class ModeSelectionListener implements ActionListener {
        private final String mode;

        public ModeSelectionListener(String mode) {
            this.mode = mode;
        }

        /**
         * Responds to button click events by launching the corresponding game mode GUI
         * and initializing the game logic.
         *
         * @param e The ActionEvent triggered by the button click.
         */

        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();

            switch (mode) {
                case "Duel Game": {
                    BaseQuartoGUI gui = new DuelQuartoGUI();
                    GUIHandler handler = new GUIHandler(gui);
                    gui.setVisible(true);
                    new Thread(() -> {
                        try {
                            Game game = new DuelGame(handler);
                            game.play();
                        } catch (Exception ex) {
                            ex.printStackTrace();
                            JOptionPane.showMessageDialog(gui, "Game error: " + ex.getMessage(),
                                    "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }).start();
                    break;
                }

                case "Solo Game": {
                    SoloQuartoGUI gui = new SoloQuartoGUI();
                    gui.setVisible(true);
                    break;
                }

                case "Adventurous Game": {
                    AdventurousQuartoGUI gui = new AdventurousQuartoGUI();
                    gui.setVisible(true);
                    break;
                }

                default:
                    throw new IllegalStateException("Unexpected value: " + mode);
            }
        }
    }
}
