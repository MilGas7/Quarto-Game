package am.aua.quarto.core;

public class SoloGame extends Game{
    public SoloGame(){
        super();
        setPlayer2(new RandomPlayer());
    }

    public void play(){
        boolean isQuarto = false;
        while(!isQuarto){
            getboard().print();
            Player currentPlayer = getPlayer1Turn() ? getPlayer1() : getPlayer2();
            System.out.println("Turn is " + (getPlayer1Turn() ? "YOURS" : "RANDOM PLAYER'S"));
            int pieceInt = currentPlayer.choosePiece(getboard());

            changePlayer1Turn();
            currentPlayer = getPlayer1Turn() ? getPlayer1() : getPlayer2();

            System.out.println("Turn is " + (getPlayer1Turn() ? "YOURS" : "RANDOM PLAYER'S"));

            int tileIndex = currentPlayer.chooseTile(getboard());

            getboard().setTile(tileIndex, Piece.makePiece(pieceInt));
            if(getboard().isQuarto(tileIndex / Board.SIZE, tileIndex % Board.SIZE)){
                getboard().print();
                if(getPlayer1Turn()){
                    System.out.println("Congratulations!!! You win.");
                }
                else{
                    System.out.println("Unfortunately, RANDOM PLAYER wins.");
                }
                isQuarto = true;
            }
        }
    }
}
