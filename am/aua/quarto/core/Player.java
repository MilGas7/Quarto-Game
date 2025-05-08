package am.aua.quarto.core;

import am.aua.quarto.core.exceptions.*;
import am.aua.quarto.oi.*;

public class Player{

    public int choosePiece(Board board, IOHandler io) {
        boolean flag = false;
        int pieceInt = -1; //Value will be changed after
        while (!flag) {
            try {
                String input = io.getInput("Choose a piece (0-15):");
                pieceInt = Integer.parseInt(input);
                board.checkPiece(pieceInt);
                flag = true;
            }
            catch (NoSuchPieceException | PieceRepeatException e) {
                io.showMessage(e.getMessage());
            }
            catch (NumberFormatException e) {
                io.showMessage("Invalid input. Please enter an integer between 0 and 15.");
            }
        }
        io.showMessage("Chosen piece has characteristics: " + new Piece(Piece.makePiece(pieceInt)));
        return pieceInt;
    }

    public int chooseTile(Board board, IOHandler io) {
        boolean flag = false;
        int row = -1, col = -1;
        while (!flag) {
            try {
                String input = io.getInput("Choose a tile (row column):");
                String[] parts = input.trim().split(" ");
                if (parts.length != 2) throw new NumberFormatException();

                row = Integer.parseInt(parts[0]);
                col = Integer.parseInt(parts[1]);

                int index = row * Board.SIZE + col;
                board.checkIndex(index);
                flag = true;
            }
            catch (NonEmptyTileException | PositionOutOfBoardException e) {
                io.showMessage(e.getMessage());
            }
            catch (NumberFormatException e) {
                io.showMessage("Invalid input. Please enter two integers separated by a space.");
            }
        }
        return row * Board.SIZE + col;
    }

    
}