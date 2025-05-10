package am.aua.quarto.core;

import am.aua.quarto.core.exceptions.*;
import am.aua.quarto.oi.*;

/**
 * Represents a player in the Quarto game.
 */
public class Player {

    /**
     * Prompts the player to choose a valid piece for the opponent to place.
     * The player is repeatedly prompted until a valid, available piece is chosen.
     *
     * @param board the current game board
     * @param io    the input/output handler for user interaction
     * @return the integer index of the chosen piece (0–15)
     */
    public int choosePiece(Board board, IOHandler io) {
        boolean flag = false;
        int pieceInt = -1; //Value will be changed after
        while (!flag) {
            try {
                String input = io.getInput("Choose a piece:");
                pieceInt = Integer.parseInt(input);
                board.checkPiece(pieceInt);
                flag = true;
            } catch (NoSuchPieceException | PieceRepeatException e) {
                io.showMessage(e.getMessage());
            } catch (NumberFormatException e) {
                io.showMessage("Invalid input. Please enter an integer between 0 and 15.");
            }
        }
        io.showMessage("Chosen piece has characteristics: " + new Piece(Piece.makePiece(pieceInt)));
        return pieceInt;
    }

    /**
     * Prompts the player to choose a tile to place the current piece.
     * <p>
     * The player is repeatedly prompted until a valid, empty tile is selected.
     *
     * @param board the current game board
     * @param io    the input/output handler for user interaction
     * @return the linear index (0–15) of the chosen board tile
     */
    public int chooseTile(Board board, IOHandler io) {
        boolean flag = false;
        int row = -1, col = -1;
        while (!flag) {
            try {
                String input = io.getInput("Choose a tile:");
                String[] parts = input.trim().split(" ");
                if (parts.length != 2) throw new NumberFormatException();

                row = Integer.parseInt(parts[0]);
                col = Integer.parseInt(parts[1]);

                board.checkIndex(row, col);
                flag = true;
            } catch (NonEmptyTileException | PositionOutOfBoardException e) {
                io.showMessage(e.getMessage());
            } catch (NumberFormatException e) {
                io.showMessage("Invalid input. Please enter two integers separated by a space.");
            }
        }
        return row * Board.SIZE + col;
    }


}