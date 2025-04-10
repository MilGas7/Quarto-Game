import java.util.Scanner;

public class Game{

    Player player1;
    Player player2;
    Board board;
    char currentPlayerPiece;
    boolean player1Turn;

    public Game(){
        player1 = new Player();
        player2 = new Player();
        board = new Board();
        player1Turn = true;
    }

    public void play(){
        Scanner keyboard = new Scanner(System.in);
        char pieceChar;
        int position;
        boolean isQuarto = false;
        while(!isQuarto){
            board.print();
            Player currentPlayer = player1Turn ? player1 : player2;
            System.out.println("Player " + (player1Turn ? "1" : "2") + ", choose a piece (a-p): ");
            String inputString = keyboard.nextLine();

            if (inputString.length() == 0) {
                System.out.println("Invalid input. Please enter a character.");
                continue;
            }
            pieceChar = inputString.charAt(0);

            if (pieceChar < 'a' || pieceChar > 'p') {
                System.out.println("Invalid piece. Choose a character between a-p.");
                continue;
            }

            player1Turn = changeOfBoolean(player1Turn);
            currentPlayer = player1Turn ? player1 : player2;

            currentPlayer.choosePiece(pieceChar);

            System.out.println("Player " + (player1Turn ? "1" : "2") + " enter position to place your piece:");
            position = keyboard.nextInt();
            keyboard.nextLine();

            if (position < 0 || position >= Board.SIZE * Board.SIZE || board.getTile(position) != ' ') {
                System.out.println("Invalid position. Try again.");
                continue;
            }
            board.setTile(position, pieceChar);
            int row = position / board.SIZE;
            int col = position % board.SIZE;
            char[] charColumn = new char[board.SIZE];
            char[] charRow = new char[board.SIZE];
            for(int i = 0; i < board.SIZE; i++){
                charColumn[i] = board.getTile(row * board.SIZE + i);
                charRow[i] = board.getTile(i * board.SIZE + col);
            }
            if(Piece.isQuarto(new Piece(Board.makePiece(charColumn[0])), new Piece(Board.makePiece(charColumn[1])), new Piece(Board.makePiece(charColumn[2])), new Piece(Board.makePiece(charColumn[3])) ))
                isQuarto = true;
            if(Piece.isQuarto(new Piece(Board.makePiece(charRow[0])), new Piece(Board.makePiece(charRow[1])), new Piece(Board.makePiece(charRow[2])), new Piece(Board.makePiece(charRow[3])) ))
                isQuarto = true;
        }
    }

    public static boolean changeOfBoolean(boolean turn){
        turn = !turn;
        return turn;
    }


}