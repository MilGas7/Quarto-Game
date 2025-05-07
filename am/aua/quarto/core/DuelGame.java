package am.aua.quarto.core;

public class DuelGame extends Game {
    public DuelGame(){
        super();
    }

    public void play(){
        boolean isQuarto = false;
        while(!isQuarto){
            getboard().print();
            Player currentPlayer = getPlayer1Turn() ? getPlayer1() : getPlayer2();
            System.out.println("Current player is PLAYER " + (getPlayer1Turn() ? "1" : "2"));
            int pieceInt = currentPlayer.choosePiece(getboard());

            changePlayer1Turn();
            currentPlayer = getPlayer1Turn() ? getPlayer1() : getPlayer2();

            System.out.println("Current player is PLAYER " + (getPlayer1Turn() ? "1" : "2"));

            int tileIndex = currentPlayer.chooseTile(getboard());

            getboard().setTile(tileIndex, Piece.makePiece(pieceInt));
            if(getboard().isQuarto(tileIndex / Board.SIZE, tileIndex % Board.SIZE)){
                getboard().print();
                System.out.println("Congratulations! Player " + (getPlayer1Turn() ? "1" : "2") + " wins.");
                isQuarto = true;
            }
        }
    }

}