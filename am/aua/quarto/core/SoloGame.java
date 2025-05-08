package am.aua.quarto.core;

import am.aua.quarto.oi.*;

public class SoloGame extends Game{
    public SoloGame(IOHandler ioHandler) {
        super(ioHandler);
        setPlayer2(new RandomPlayer());
    }

    @Override
    public void play() {
        boolean isQuarto = false;

        while (!isQuarto) {
            io.showBoard(getboard());

            Player currentPlayer = getPlayer1Turn() ? getPlayer1() : getPlayer2();
            io.showMessage("Turn is " + (getPlayer1Turn() ? "YOURS" : "RANDOM PLAYER"));

            int pieceInt = currentPlayer.choosePiece(getboard(), io);

            changePlayer1Turn();
            currentPlayer = getPlayer1Turn() ? getPlayer1() : getPlayer2();
            io.showMessage("Turn is " + (getPlayer1Turn() ? "YOURS" : "RANDOM PLAYER"));

            int tileIndex = currentPlayer.chooseTile(getboard(), io);

            getboard().setTile(tileIndex, Piece.makePiece(pieceInt));
            getboard().setPieceCount(pieceInt);

            if (getboard().isQuarto(tileIndex / Board.SIZE, tileIndex % Board.SIZE)) {
                io.showBoard(getboard());
                io.showMessage(getPlayer1Turn() ? "Congratulations!!! YOU WIN." : "Unfortunately, RANDOM PLAYER WINS.");
                isQuarto = true;
            }
        }
    }
}
