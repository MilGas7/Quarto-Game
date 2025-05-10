package am.aua.quarto.core;

import am.aua.quarto.oi.*;

/**
 * Represents the standard two-player version of the Quarto game.
 */
public class DuelGame extends Game {
    /**
     * Constructs a new {@code DuelGame} instance with the specified IO handler.
     *
     * @param ioHandler the IO handler used for user interaction and display.
     */
    public DuelGame(IOHandler ioHandler) {
        super(ioHandler);
    }

    /**
     * Executes the main gameplay loop for the Duel mode.
     */
    @Override
    public void play() {
        boolean isQuarto = false;

        while (!isQuarto) {
            io.showBoard(getboard());

            Player currentPlayer = getPlayer1Turn() ? getPlayer1() : getPlayer2();
            io.showMessage("Current player is PLAYER " + (getPlayer1Turn() ? "1" : "2"));
            int pieceInt = currentPlayer.choosePiece(getboard(), io);
            changePlayer1Turn();

            currentPlayer = getPlayer1Turn() ? getPlayer1() : getPlayer2();
            io.showMessage("Current player is PLAYER " + (getPlayer1Turn() ? "1" : "2"));
            int tileIndex = currentPlayer.chooseTile(getboard(), io);
            getboard().setTile(tileIndex, Piece.makePiece(pieceInt));
            getboard().setPieceCount(pieceInt);

            if (getboard().isQuarto(tileIndex / Board.SIZE, tileIndex % Board.SIZE)) {
                io.showBoard(getboard());
                io.showMessage("Congratulations! Player " + (getPlayer1Turn() ? "1" : "2") + " wins.");
                isQuarto = true;
            }
        }
    }
}