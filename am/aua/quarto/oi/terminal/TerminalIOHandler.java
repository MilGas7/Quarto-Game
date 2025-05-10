package am.aua.quarto.oi.terminal;

import am.aua.quarto.oi.*;
import am.aua.quarto.core.*;

import java.util.Scanner;

/**
 * TerminalIOHandler is an implementation of the {@link IOHandler} interface
 * that handles input and output operations via the command line (terminal).
 */
public class TerminalIOHandler implements IOHandler {

    /**
     * Displays a message to the terminal.
     *
     * @param message the message to be shown
     */
    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    /**
     * Prompts the user with a message and reads a line of input from the terminal.
     */
    @Override
    public String getInput(String prompt) {
        System.out.println(prompt);
        Scanner keyboard = new Scanner(System.in);
        return keyboard.nextLine();
    }

    /**
     * Displays the game board in the terminal.
     */
    @Override
    public void showBoard(Board board) {
        if (board instanceof StarBoard) {
            StarBoardTerminalPrinter.printBoard((StarBoard) board);
        } else {
            BoardTerminalPrinter.printBoard(board);
        }
    }
}
