package am.aua.quarto.core;
import am.aua.quarto.core.exceptions.*;

public class Board{

    public static final int SIZE = 4;
    private Piece[] tiles;
    private boolean[] pieceCount;

    public Board(){
        tiles = new Piece[SIZE * SIZE];
        for (int i = 0; i < tiles.length; i++) {
            tiles[i] = null;
        }
        pieceCount = new boolean[16]; //number of possible piece type
        for(int i = 0; i < pieceCount.length; i++)
            pieceCount[i] = false;
    }

    public Board(Board original){
        if (original == null){
            System.out.println("Fatal error.");
            System.exit(0);
        }
        this.tiles = new Piece[SIZE * SIZE];
        this.pieceCount = new boolean[16];
        for(int i = 0; i < tiles.length; i++)
            this.tiles[i] = original.tiles[i];
        for(int i = 0; i < pieceCount.length; i++)
            this.pieceCount[i] = original.pieceCount[i];
    }

    public Piece getTile(int index) {
        return tiles[index];
    }

    public void setTile(int index, int pieceInt) {
        tiles[index] = new Piece(Piece.makePiece(pieceInt));
        pieceCount[pieceInt] = true;
    }

    public void checkIndex(int index){
        if(index < 0 || index >= SIZE * SIZE)
            throw new PositionOutOfBoardException("Row and column are out of board.");
        if(tiles[index] != null)
            throw new NonEmptyTileException("Tile of row " + (index / SIZE) + " and column " + (index % SIZE) + " is not empty");
    }

    public void checkPiece(int pieceInt){
        if(pieceInt <= 0 || pieceInt > 16)
            throw new NoSuchPieceException("There is no such piece.");
        if(pieceCount[pieceInt])
            throw new PieceRepeatException("You already had such a piece.");
    }

    public void print() {
        System.out.print("   ");
        for(int i = 0; i < SIZE; i ++){
            System.out.print("    " + i + "  ");
        }
        System.out.println();
        for (int row = 0; row < SIZE; row++) {
            System.out.print("    ");
            for(int i = 0; i < SIZE; i ++){
                System.out.print("-------");
            }
            System.out.print("-\n" + row + "   ");
            for (int col = 0; col < SIZE; col++) {
                if(tiles[row * SIZE + col] == null){
                    System.out.print("|      ");
                }
                else{
                    System.out.print("| " + tiles[row * SIZE + col].getNameOfPiece().toString() + " ");
                }
            }
            System.out.println("|");
            System.out.print("    ");
            for(int i = 0; i < SIZE; i ++){
                System.out.print("-------");
            }
            System.out.println("-");
        }
    }

    public boolean isQuarto(int row, int col){ //row and column of lastly putted piece
        if(Piece.haveCommonAttribute(getTile(row * SIZE + 0), getTile(row * SIZE + 1), getTile(row * SIZE + 2), getTile(row * SIZE + 3) ))
            return true;
        if(Piece.haveCommonAttribute(getTile(0 * SIZE + col), getTile(1 * SIZE + col), getTile(2 * SIZE + col), getTile(3 * SIZE + col) ))
            return true;
        if(row == col && Piece.haveCommonAttribute(getTile(0 * SIZE + 0), getTile(1 * SIZE + 1), getTile(2 * SIZE + 2), getTile(3 * SIZE + 3) ))
            return true;
        if(row == SIZE - col - 1 && Piece.haveCommonAttribute(getTile(0 * SIZE + SIZE - 1), getTile(1 * SIZE + SIZE - 2), getTile(2 * SIZE + SIZE - 3), getTile(3 * SIZE + SIZE - 4) ))
            return true;
        return false;
    }
}