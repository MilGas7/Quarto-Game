package am.aua.quarto.core;

import java.util.Random;
import am.aua.quarto.core.exceptions.*;
import am.aua.quarto.oi.*;

public class RandomPlayer extends Player {

    @Override
    public int choosePiece (Board board, IOHandler io){
        Random randomGenerator = new Random();
        boolean flag = false;
        int pieceInt = -1;
        while(!flag){
            try{
                pieceInt = randomGenerator.nextInt(16) + 1;
                board.checkPiece(pieceInt);
                flag = true;
            }
            catch(NoSuchPieceException|PieceRepeatException e){
                System.out.println(e.getMessage());
            }
        }
        io.showMessage("Chosen piece has characteristics: " + new Piece(Piece.makePiece(pieceInt)));
        return pieceInt;
    }

    @Override
    public int chooseTile (Board board, IOHandler io){
        Random randomGenerator = new Random();
        boolean flag = false;
        int row = -1;
        int col = -1;
        while(!flag){
            try{
                row = randomGenerator.nextInt(Board.SIZE);
                col = randomGenerator.nextInt(Board.SIZE);
                board.checkIndex(row * Board.SIZE + col);
                flag = true;
            }
            catch(NonEmptyTileException|PositionOutOfBoardException e){
                System.out.println(e.getMessage());
            }
        }
        return row * Board.SIZE + col;
    }
}