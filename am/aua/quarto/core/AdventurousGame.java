package am.aua.quarto.core;

import am.aua.quarto.core.exceptions.*;
import am.aua.quarto.oi.*;

/**
 * Represents an adventurous version of the Quarto game.
 * Inherits from the base {@link Game} class.
 */
public class AdventurousGame extends Game {

    /**
     * Constructs an {@code AdventurousGame} instance with the given I/O handler.
     * Sets the board to a {@link StarBoard}, which includes star tiles.
     *
     * @param ioHandler the I/O handler for user interaction.
     */
    public AdventurousGame(IOHandler ioHandler) {
        super(ioHandler);
        setBoard(new StarBoard());
    }

    /**
     * Gets the game board as a {@link StarBoard}.
     *
     * @return the current game board cast to a {@code StarBoard}.
     */
    public StarBoard getBoard() {
        return (StarBoard) super.getboard();
    }

    /**
     * Starts and manages the main game loop for the adventurous game mode.
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

            ChangeablePiece piece = ChangeablePiece.fromPiece(Piece.makePiece(pieceInt));
            getBoard().setTile(tileIndex, piece);
            getboard().setPieceCount(pieceInt);

            // Handle star logic
            if (getBoard().hasStar(tileIndex)) {
                boolean flag = false;
                io.showBoard(getboard());
                while (!flag) {
                    try {
                        String traitName = io.getInput("Tile has a STAR! Give a trait to change (Color, Size, Shape, Hole):")
                                .split(" ")[0];
                        piece.changeTrait(traitName);
                        getBoard().setTile(tileIndex, piece);
                        flag = true;
                    } catch (TraitNotFoundException e) {
                        io.showMessage(e.getMessage());
                    }
                }
            }

            if (getboard().isQuarto(tileIndex / Board.SIZE, tileIndex % Board.SIZE)) {
                io.showBoard(getboard());
                io.showMessage("Congratulations! Player " + (getPlayer1Turn() ? "1" : "2") + " wins.");
                isQuarto = true;
            }
        }
    }
}
