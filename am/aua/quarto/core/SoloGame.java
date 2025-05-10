package am.aua.quarto.core;

import am.aua.quarto.oi.*;
import am.aua.quarto.oi.gui.*;

import javax.swing.*;

/**
 * Represents a single-player game of Quarto where the human player (Player 1)
 * plays against a randomly-moving computer (RandomPlayer).
 */
public class SoloGame extends Game {

    /**
     * Constructs a new SoloGame instance, initializing player 2
     * as a {@link RandomPlayer}.
     *
     * @param ioHandler the input/output handler (console or GUI-based)
     */
    public SoloGame(IOHandler ioHandler) {
        super(ioHandler);
        setPlayer2(new RandomPlayer());
    }

    /**
     * Starts and controls the game loop for Solo mode.
     */
    @Override
    public void play() {
        boolean isQuarto = false;

        while (!isQuarto) {
            io.showBoard(getboard());

            Player currentPlayer = getPlayer1Turn() ? getPlayer1() : getPlayer2();
            io.showMessage("Turn is " + (getPlayer1Turn() ? "YOURS" : "RANDOM PLAYER"));

            int pieceInt = currentPlayer.choosePiece(getboard(), io);

            if (io instanceof BaseQuartoGUI) {
                SwingUtilities.invokeLater(() -> ((BaseQuartoGUI) io).setSelectedPiece(pieceInt));
            }

            changePlayer1Turn();
            currentPlayer = getPlayer1Turn() ? getPlayer1() : getPlayer2();
            io.showMessage("Turn is " + (getPlayer1Turn() ? "YOURS" : "RANDOM PLAYER"));

            int tileIndex = currentPlayer.chooseTile(getboard(), io);

            getboard().setTile(tileIndex, Piece.makePiece(pieceInt));
            getboard().setPieceCount(pieceInt);

            if (getboard().isQuarto(tileIndex / Board.SIZE, tileIndex % Board.SIZE)) {
                io.showBoard(getboard());
                io.showMessage(getPlayer1Turn() ? "Congratulations!!! YOU WIN." : "Unfortunately, RANDOM PLAYER WINS.");
                isQuarto = true;
            }
        }
    }
}
