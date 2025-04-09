public class Player{

    public Player (){

    }

    public Piece choosePiece (char pieceChar){
        Piece newPiece = new Piece(makePiece(pieceChar));
        System.out.println("You choose a piece with characteristics: " +
                newPiece.getColor() + ", " + newPiece.getSize() + ", " + newPiece.getShape() + ", " +
                newPiece.getHole() + " HOLE");
        return newPiece;
    }

    public Piece makePiece (char pieceChar) {
        Piece newPiece;
        switch (pieceChar) {
            case 'a':
                newPiece = new Piece(true, true, true, true);
                break;
            case 'b':
                newPiece = new Piece(true, true, true, false);
                break;
            case 'c':
                newPiece = new Piece(true, true, false, true);
                break;
            case 'd':
                newPiece = new Piece(true, true, false, false);
                break;
            case 'e':
                newPiece = new Piece(true, false, true, true);
                break;
            case 'f':
                newPiece = new Piece(true, false, true, false);
                break;
            case 'g':
                newPiece = new Piece(true, false, false, true);
                break;
            case 'h':
                newPiece = new Piece(true, false, false, false);
                break;
            case 'i':
                newPiece = new Piece(false, true, true, true);
                break;
            case 'j':
                newPiece = new Piece(false, true, true, false);
                break;
            case 'k':
                newPiece = new Piece(false, true, false, true);
                break;
            case 'l':
                newPiece = new Piece(false, true, false, false);
                break;
            case 'm':
                newPiece = new Piece(false, false, true, true);
                break;
            case 'n':
                newPiece = new Piece(false, false, true, false);
                break;
            case 'o':
                newPiece = new Piece(false, false, false, true);
                break;
            case 'p':
                newPiece = new Piece(false, false, false, false);
                break;
            default:
                return null;
        }
        return newPiece;
    }
}