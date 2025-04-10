public class Board{

    public static final int SIZE = 4;
    private char[] tiles;

    public Board(){
        tiles = new char[SIZE * SIZE];
        for (int i = 0; i < tiles.length; i++) {
            tiles[i] = ' ';
        }
    }

    public Board(Board original){
        if (original == null){
            System.out.println("Fatal error.");
            System.exit(0);
        }
        this.tiles = new char[SIZE * SIZE];
        System.arraycopy(original.tiles, 0, this.tiles, 0, tiles.length);
    }

    public char getTile(int index) {
        return tiles[index];
    }

    public void setTile(int index, char piece) {
        tiles[index] = piece;
    }

    public void print() {
        for (int row = 0; row < SIZE; row++) {
            for(int i = 0; i < SIZE; i ++){
                System.out.print("----");
            }
            System.out.println("-");
            for (int col = 0; col < SIZE; col++) {
                System.out.print("| " + tiles[row * SIZE + col] + " ");
            }
            System.out.println("|");
            for(int i = 0; i < SIZE; i ++){
                System.out.print("----");
            }
            System.out.println("-");
        }
    }

    public static Piece makePiece (char pieceChar) {
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