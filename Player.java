public class Player{

    public Player (){

    }

    public Piece choosePiece (int pieceInt){
        Piece newPiece = new Piece(Piece.makePiece(pieceInt));
        System.out.println("You choose a piece with characteristics: " +
                newPiece.getColor() + ", " + newPiece.getSize() + ", " + newPiece.getShape() + ", " +
                newPiece.getHole() + " HOLE");
        return newPiece;
    }

    
}