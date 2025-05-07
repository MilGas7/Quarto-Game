package am.aua.quarto.core;
import am.aua.quarto.core.exceptions.TraitNotFoundException;

import java.util.Scanner;

public class AdventurousGame extends Game{

    public AdventurousGame(){
        super();
        setBoard(new StarBoard());
    }

    public StarBoard getBoard(){ return (StarBoard)super.getboard(); }

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

            getBoard().setTile(tileIndex, ChangeablePiece.fromPiece(Piece.makePiece(pieceInt)));

            Scanner keyboard = new Scanner(System.in);

            if(getBoard().hasStar(tileIndex)) {
                boolean flag = false;
                getboard().print();
                while(!flag) {
                    try {
                        System.out.println("Write a trait you want to change (Color, Size, Shape, Hole): ");
                        String traitName = keyboard.nextLine().split(" ")[0];
                        ChangeablePiece piece = (ChangeablePiece)getBoard().getTile(tileIndex);
                        piece.changeTrait(traitName);
                        getBoard().setTile(tileIndex, piece);
                        flag = true;
                    }
                    catch(TraitNotFoundException e) {
                        System.out.println(e.getMessage());
                    }
                }
            }

            if(getboard().isQuarto(tileIndex / Board.SIZE, tileIndex % Board.SIZE)){
                getboard().print();
                System.out.println("Congratulations! Player " + (getPlayer1Turn() ? "1" : "2") + " wins.");
                isQuarto = true;
            }
        }
    }
}
