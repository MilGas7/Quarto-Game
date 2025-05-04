import java.util.Scanner;

public class Game{

    Player player1;
    Player player2;
    Board board;
    boolean player1Turn;

    public Game(){
        player1 = new Player();
        player2 = new Player();
        board = new Board();
        player1Turn = true;
    }

    public void play(){
        Scanner keyboard = new Scanner(System.in);
        int pieceInt = -1;
        int row = -1;
        int column = -1;
        boolean isQuarto = false;
        while(!isQuarto){
            board.print();
            Player currentPlayer = player1Turn ? player1 : player2;

            boolean flagPiece = true;
            while(flagPiece){
                try{
                    System.out.println("Player " + (player1Turn ? "1" : "2") + ", choose a piece (1-16): ");
                    pieceInt = keyboard.nextInt();
                    currentPlayer.choosePiece(pieceInt);
                    board.checkPiece(pieceInt);
                    flagPiece = false;
                }
                catch(NoSuchPieceException|PieceRepeatException e){
                    System.out.println(e.getMessage());
                }
            }

            player1Turn = !(player1Turn);
            currentPlayer = player1Turn ? player1 : player2;

            boolean flagIndex = true;
            while(flagIndex){
                try{
                    System.out.println("Player " + (player1Turn ? "1" : "2") + " enter position to place your piece(row and column):");
                    row = keyboard.nextInt();
                    column = keyboard.nextInt();
                    board.checkIndex(row * Board.SIZE + column);
                    flagIndex = false;
                }
                catch(PositionOutOfBoardException|NonEmptyTileException e){
                    System.out.println(e.getMessage());
                }
            }
            board.setTile(row * Board.SIZE + column, pieceInt);
            if(board.isQuarto(row, column)){
                board.print();
                System.out.println("Congratulations! Player " + (player1Turn ? "1" : "2") + " wins.");
                isQuarto = true;
            }
        }
    }

}