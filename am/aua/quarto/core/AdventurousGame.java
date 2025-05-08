package am.aua.quarto.core;

import am.aua.quarto.core.exceptions.*;
import am.aua.quarto.oi.*;

public class AdventurousGame extends Game{

    public AdventurousGame(IOHandler ioHandler) {
        super(ioHandler);
        setBoard(new StarBoard());
    }

    public StarBoard getBoard(){ return (StarBoard)super.getboard(); }

    @Override
    public void play() {
        boolean isQuarto = false;

        while (!isQuarto) {
            io.showBoard(getboard());

            Player currentPlayer = getPlayer1Turn() ? getPlayer1() : getPlayer2();
            io.showMessage("Current player is PLAYER " + (getPlayer1Turn() ? "1" : "2"));
            int pieceInt = currentPlayer.choosePiece(getboard(), io);

            changePlayer1Turn();
            currentPlayer = getPlayer1Turn() ? getPlayer1() : getPlayer2();
            io.showMessage("Current player is PLAYER " + (getPlayer1Turn() ? "1" : "2"));

            int tileIndex = currentPlayer.chooseTile(getboard(), io);

            ChangeablePiece piece = ChangeablePiece.fromPiece(Piece.makePiece(pieceInt));
            getBoard().setTile(tileIndex, piece);
            getboard().setPieceCount(pieceInt);

            // Handle star logic
            if (getBoard().hasStar(tileIndex)) {
                boolean traitChanged = false;
                io.showBoard(getboard());
                while (!traitChanged) {
                    try {
                        String traitName = io.getInput("Tile has a STAR! Write a trait to change (Color, Size, Shape, Hole):")
                                .split(" ")[0];
                        piece.changeTrait(traitName);
                        getBoard().setTile(tileIndex, piece);
                        traitChanged = true;
                    } catch (TraitNotFoundException e) {
                        io.showMessage(e.getMessage());
                    }
                }
            }

            if (getboard().isQuarto(tileIndex / Board.SIZE, tileIndex % Board.SIZE)) {
                io.showBoard(getboard());
                io.showMessage("Congratulations! Player " + (getPlayer1Turn() ? "1" : "2") + " wins.");
                isQuarto = true;
            }
        }
    }
}
