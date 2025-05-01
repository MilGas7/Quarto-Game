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
            keyboard.nextLine();

            if (row < 0 || row >= Board.SIZE || column < 0 ||
                    column >= Board.SIZE || board.getTile(row * Board.SIZE + column) != null) {
                System.out.println("Invalid position. Try again.");
                continue;
            }
            board.setTile(row * Board.SIZE + column, new Piece(Piece.makePiece(pieceInt)));
            Piece[] pieceColumn = new Piece[board.SIZE];
            Piece[] pieceRow = new Piece[board.SIZE];
            for(int i = 0; i < board.SIZE; i++){
                pieceColumn[i] = board.getTile(row * board.SIZE + i);
                pieceRow[i] = board.getTile(i * board.SIZE + column);
            }
            if(Piece.isQuarto(new Piece(pieceColumn[0]), new Piece(pieceColumn[1]), new Piece(pieceColumn[2]), new Piece(pieceColumn[3]) ))
                isQuarto = true;
            if(Piece.isQuarto(new Piece(pieceRow[0]), new Piece(pieceRow[1]), new Piece(pieceRow[2]), new Piece(pieceRow[3]) ))
                isQuarto = true;
        }
    }

    public static boolean changeOfBoolean(boolean turn){
        turn = !turn;
        return turn;
    }


}