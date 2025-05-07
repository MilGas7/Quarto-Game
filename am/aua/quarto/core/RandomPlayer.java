package am.aua.quarto.core;
import java.util.Random;
import am.aua.quarto.core.exceptions.*;

public class RandomPlayer extends Player {

    public int choosePiece (Board board){
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
        System.out.println("Chosen piece has characteristics: " + new Piece(Piece.makePiece(pieceInt)));
        return pieceInt;
    }

    public int chooseTile (Board board){
        Random randomGenerator = new Random();
        boolean flag = false;
        int row = -1;
        int col = -1;
        while(!flag){
            try{
                row = randomGenerator.nextInt(4);
                col = randomGenerator.nextInt(4);
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