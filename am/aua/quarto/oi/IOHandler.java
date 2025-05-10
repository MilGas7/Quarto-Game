package am.aua.quarto.oi;

import am.aua.quarto.core.*;

/**
 * IOHandler is an interface that abstracts the input/output operations
 */
public interface IOHandler {

    /**
     * Displays a message to the user.
     *
     * @param message the message to be shown
     */
    public void showMessage(String message);

    /**
     * Prompts the user for input and returns the response.
     *
     * @param prompt the message prompting the user for input
     * @return the input entered by the user
     */
    public String getInput(String prompt);

    /**
     * Displays the current state of the game board.
     *
     * @param board the game board to be displayed
     */
    public void showBoard(Board board);
}
