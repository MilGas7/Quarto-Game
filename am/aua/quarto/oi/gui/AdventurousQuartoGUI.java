package am.aua.quarto.oi.gui;

import am.aua.quarto.core.*;
import am.aua.quarto.oi.IOHandler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * GUI implementation for the Adventurous mode of the Quarto game.
 */
public class AdventurousQuartoGUI extends BaseQuartoGUI implements IOHandler {

    private AdventurousGame game;

    /**
     * Constructs a new GUI for the Adventurous Quarto game and starts the game in a new thread.
     */
    public AdventurousQuartoGUI() {
        super();
        this.game = new AdventurousGame(this);
        new Thread(() -> game.play()).start();
    }

    /**
     * Updates the board UI to reflect the current state of the given {@link Board}.
     *
     * @param board the board to display
     */
    @Override
    public void showBoard(Board board) {
        updateBoard(board);
    }

    /**
     * Displays a message to the user.
     *
     * @param message the message to be shown
     */
    @Override
    public void showMessage(String message) {
        updateMessage(message);

        if (message.contains("wins")) {
            showEndGameDialog(message, () -> {
                this.game = new AdventurousGame(this);
                new Thread(() -> game.play()).start();
            });
        }
    }

    /**
     * Prompts the user for input.
     *
     * @param prompt the prompt string
     * @return the user's selected input
     */
    @Override
    public String getInput(String prompt) {
        if (prompt.startsWith("Tile has a STAR!")) {
            return showTraitSelectionDialog();
        }
        return super.getInput(prompt);
    }

    /**
     * Displays a dialog that allows the player to select one of the four piece traits
     * (Color, Size, Shape, Hole) to change, used when placing on a star tile.
     *
     * @return the selected trait as a String
     */
    private String showTraitSelectionDialog() {
        JDialog dialog = new JDialog(this, "Change Trait", true);
        dialog.setLayout(new BorderLayout());
        dialog.setSize(300, 200);
        dialog.setLocationRelativeTo(this);

        JPanel panel = new JPanel(new GridLayout(5, 1));
        JLabel label = new JLabel("Select trait to change:");
        panel.add(label);

        JRadioButton colorBtn = new JRadioButton("Color");
        JRadioButton sizeBtn = new JRadioButton("Size");
        JRadioButton shapeBtn = new JRadioButton("Shape");
        JRadioButton holeBtn = new JRadioButton("Hole");

        ButtonGroup group = new ButtonGroup();
        group.add(colorBtn);
        group.add(sizeBtn);
        group.add(shapeBtn);
        group.add(holeBtn);

        panel.add(colorBtn);
        panel.add(sizeBtn);
        panel.add(shapeBtn);
        panel.add(holeBtn);

        JButton okButton = new JButton("OK");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();
            }
        });

        dialog.add(panel, BorderLayout.CENTER);
        dialog.add(okButton, BorderLayout.SOUTH);

        colorBtn.setSelected(true);

        dialog.setVisible(true);

        if (colorBtn.isSelected()) return "Color";
        if (sizeBtn.isSelected()) return "Size";
        if (shapeBtn.isSelected()) return "Shape";
        return "Hole";
    }
}