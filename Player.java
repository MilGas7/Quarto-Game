public class Player{

    public Player (){

    }

    public Piece choosePiece (char pieceChar){
        Piece newPiece = new Piece(Board.makePiece(pieceChar));
        System.out.println("You choose a piece with characteristics: " +
                newPiece.getColor() + ", " + newPiece.getSize() + ", " + newPiece.getShape() + ", " +
                newPiece.getHole() + " HOLE");
        return newPiece;
    }

    
}