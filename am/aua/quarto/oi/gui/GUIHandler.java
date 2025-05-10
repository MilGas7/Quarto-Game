package am.aua.quarto.oi.gui;

import am.aua.quarto.oi.*;
import am.aua.quarto.core.*;

/**
 * The {@code GUIHandler} class serves as an implementation of the {@link IOHandler}
 */
public class GUIHandler implements IOHandler {
    private BaseQuartoGUI gui;

    /**
     * Constructs a {@code GUIHandler} with the specified GUI instance.
     *
     * @param gui The GUI implementation (e.g., {@link DuelQuartoGUI}, {@link SoloQuartoGUI}) to handle input/output.
     */
    public GUIHandler(BaseQuartoGUI gui) {
        this.gui = gui;
    }

    /**
     * Displays a message to the user using the GUI.
     *
     * @param message The message string to show.
     */
    @Override
    public void showMessage(String message) {
        gui.updateMessage(message);
    }

    /**
     * Retrieves user input via the GUI, blocking until an input is available.
     *
     * @param prompt The prompt or instruction to display to the user.
     * @return The input string received from the user.
     */
    @Override
    public String getInput(String prompt) {
        return gui.getInput(prompt);
    }

    /**
     * Updates the game board display in the GUI.
     *
     * @param board The current state of the game board.
     */
    @Override
    public void showBoard(Board board) {
        gui.updateBoard(board);
    }
}
