import java.util.Scanner;

public class Game{

    Player player1;
    Player player2;
    Board board;
    Piece currentPlayerPiece;
    boolean player1Turn;

    public Game(){
        player1 = new Player();
        player2 = new Player();
        board = new Board();
        player1Turn = true;
    }

    public void play(){
        Scanner keyboard = new Scanner(System.in);
        int pieceInt;
        int row;
        int column;
        boolean isQuarto = false;
        while(!isQuarto){
            board.print();
            Player currentPlayer = player1Turn ? player1 : player2;
            System.out.println("Player " + (player1Turn ? "1" : "2") + ", choose a piece (1-16): ");

            pieceInt = keyboard.nextInt();

            if (pieceInt < 1 || pieceInt > 16) {
                System.out.println("Invalid piece. Choose an integer between 1-16.");
                continue;
            }

            player1Turn = !(player1Turn);
            currentPlayer = player1Turn ? player1 : player2;

            currentPlayer.choosePiece(pieceInt);

            System.out.println("Player " + (player1Turn ? "1" : "2") + " enter position to place your piece(row and column):");
            row = keyboard.nextInt();
            column = keyboard.nextInt();
            if (row < 0 || row >= Board.SIZE || column < 0 ||
                    column >= Board.SIZE || board.getTile(row * Board.SIZE + column) != null) {
                System.out.println(board.getTile(row * Board.SIZE + column) != null);
                System.out.println("Invalid position. Try again.");
                continue;
            }
            board.setTile(row * Board.SIZE + column, new Piece(Piece.makePiece(pieceInt)));

            if(Piece.isQuarto(board.getTile(row * board.SIZE + 0), board.getTile(row * board.SIZE + 1), board.getTile(row * board.SIZE + 1), board.getTile(row * board.SIZE + 1) ))
                isQuarto = true;
            if(Piece.isQuarto(board.getTile(0 * board.SIZE + column), board.getTile(1 * board.SIZE + column), board.getTile(2 * board.SIZE + column), board.getTile(3 * board.SIZE + column) ))
                isQuarto = true;
            if(row == column && Piece.isQuarto(board.getTile(0 * board.SIZE + 0), board.getTile(1 * board.SIZE + 1), board.getTile(2 * board.SIZE + 2), board.getTile(3 * board.SIZE + 3) ))
                isQuarto = true;
            if(row == board.SIZE - column && Piece.isQuarto(board.getTile(0 * board.SIZE + board.SIZE - 0), board.getTile(1 * board.SIZE + board.SIZE - 1), board.getTile(2 * board.SIZE + board.SIZE - 2), board.getTile(3 * board.SIZE + board.SIZE - 3) ))
                isQuarto = true;
        }
    }

}