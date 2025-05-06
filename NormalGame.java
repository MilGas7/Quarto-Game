public class NormalGame extends Game {
    public NormalGame(){
        player1 = new Player();
        player2 = new Player();
        board = new Board();
        player1Turn = true;
    }

    public void play(){
        boolean isQuarto = false;
        while(!isQuarto){
            board.print();
            Player currentPlayer = player1Turn ? player1 : player2;
            System.out.println("Current player is PLAYER " + (player1Turn ? "1" : "2"));
            int pieceInt = currentPlayer.choosePiece(board);

            player1Turn = !(player1Turn);
            currentPlayer = player1Turn ? player1 : player2;

            System.out.println("Current player is PLAYER " + (player1Turn ? "1" : "2"));

            int tileIndex = currentPlayer.chooseTile(board);

            board.setTile(tileIndex, pieceInt);
            if(board.isQuarto(tileIndex / Board.SIZE, tileIndex % Board.SIZE)){
                board.print();
                System.out.println("Congratulations! Player " + (player1Turn ? "1" : "2") + " wins.");
                isQuarto = true;
            }
        }
    }

}