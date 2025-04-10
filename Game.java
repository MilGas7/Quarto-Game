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
        while(true){
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

            player1Turn = !player1Turn;
        }
    }

    public static boolean changeOfBoolean(boolean turn){
        turn = !turn;
        return turn;
    }
}