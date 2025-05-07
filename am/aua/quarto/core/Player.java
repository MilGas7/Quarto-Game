package am.aua.quarto.core;
import am.aua.quarto.core.exceptions.*;
import java.util.Scanner;

public class Player{

    public int choosePiece (Board board){
        Scanner keyboard = new Scanner(System.in);
        boolean flag = false;
        int pieceInt = -1; //just needed, value be changed after
        while(!flag){
            try{
                System.out.println("Choose a piece (1-16): ");
                pieceInt = keyboard.nextInt();
                board.checkPiece(pieceInt);
                flag = true;
            }
            catch(NoSuchPieceException|PieceRepeatException e){
                System.out.println(e.getMessage());
            }
        }
        System.out.println("Chosen piece have characteristics: " + new Piece(Piece.makePiece(pieceInt)));
        return pieceInt;
    }

    public int chooseTile (Board board){
        Scanner keyboard = new Scanner(System.in);
        boolean flag = false;
        int row = -1; //just needed, value be changed after
        int col = -1;
        while(!flag){
            try{
                System.out.println("Choose a tile(row column): ");
                row = keyboard.nextInt();
                col = keyboard.nextInt();
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