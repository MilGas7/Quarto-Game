package am.aua.quarto.oi.gui;

import am.aua.quarto.core.*;
import am.aua.quarto.oi.IOHandler;

/**
 * The {@code SoloQuartoGUI} class is a graphical user interface for the solo mode of the Quarto game.
 */
public class SoloQuartoGUI extends BaseQuartoGUI implements IOHandler {

    private SoloGame game;

    /**
     * Constructs a new SoloQuartoGUI instance and automatically starts the solo game.
     */
    public SoloQuartoGUI() {
        super();
        startGame();
    }

    /**
     * Initializes and starts the solo game in a separate thread.
     */
    private void startGame() {
        this.game = new SoloGame(this);
        new Thread(() -> game.play()).start();
    }

    /**
     * Updates the visual representation of the game board.
     *
     * @param board the current game board state to display
     */
    @Override
    public void showBoard(Board board) {
        updateBoard(board);
    }

    /**
     * Displays a message in the GUI.
     *
     * @param message the message to display
     */
    @Override
    public void showMessage(String message) {
        updateMessage(message);

        if (message.contains("YOU WIN") || message.contains("RANDOM PLAYER WINS")) {
            showEndGameDialog(message, this::startGame);
        }
    }

    @Override
    public String getInput(String prompt) {
        return super.getInput(prompt); // already GUI-interactive
    }
}
