package am.aua.quarto.core;

import java.util.Random;

import am.aua.quarto.core.exceptions.*;
import am.aua.quarto.oi.*;

/**
 * Represents a computer-controlled player that makes random moves
 * in the Quarto game.
 */
public class RandomPlayer extends Player {

    /**
     * Randomly selects a valid and available piece to give to the opponent.
     *
     * @param board the current game board
     * @param io    the input/output handler (used for display only)
     * @return the index (0–15) of the randomly selected piece
     */
    @Override
    public int choosePiece(Board board, IOHandler io) {
        Random randomGenerator = new Random();
        boolean flag = false;
        int pieceInt = -1;
        while (!flag) {
            try {
                pieceInt = randomGenerator.nextInt(16);
                board.checkPiece(pieceInt);
                flag = true;
            } catch (NoSuchPieceException | PieceRepeatException e) {
                System.out.println(e.getMessage());
            }
        }
        io.showMessage("Chosen piece has characteristics: " + new Piece(Piece.makePiece(pieceInt)));
        return pieceInt;
    }

    /**
     * Randomly selects a valid and empty tile on the board to place a piece.
     *
     * @param board the current game board
     * @param io    the input/output handler (used for display only)
     * @return the linear index (0–15) of the randomly chosen tile
     */
    @Override
    public int chooseTile(Board board, IOHandler io) {
        Random randomGenerator = new Random();
        boolean flag = false;
        int row = -1;
        int col = -1;
        while (!flag) {
            try {
                row = randomGenerator.nextInt(Board.SIZE);
                col = randomGenerator.nextInt(Board.SIZE);
                board.checkIndex(row * Board.SIZE + col);
                flag = true;
            } catch (NonEmptyTileException | PositionOutOfBoardException e) {
                System.out.println(e.getMessage());
            }
        }
        return row * Board.SIZE + col;
    }
}