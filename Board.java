public class Board{

    public static final int SIZE = 4;
    private Piece[] tiles;

    public Board(){
        tiles = new Piece[SIZE * SIZE];
        for (int i = 0; i < tiles.length; i++) {
            tiles[i] = null;
        }
    }

    public Board(Board original){
        if (original == null){
            System.out.println("Fatal error.");
            System.exit(0);
        }
        this.tiles = new Piece[SIZE * SIZE];
        System.arraycopy(original.tiles, 0, this.tiles, 0, tiles.length);
    }

    public Piece getTile(int index) {
        return tiles[index];
    }

    public void setTile(int index, Piece piece) {
        tiles[index] = piece;
    }

    public void print() {
        for (int row = 0; row < SIZE; row++) {
            for(int i = 0; i < SIZE; i ++){
                System.out.print("-------");
            }
            System.out.println("-");
            for (int col = 0; col < SIZE; col++) {
                if(tiles[row * SIZE + col] == null){
                    System.out.print("|      ");
                }
                else{
                    System.out.print("| " + tiles[row * SIZE + col].getNameOfPiece().toString() + " ");
                }
            }
            System.out.println("|");
            for(int i = 0; i < SIZE; i ++){
                System.out.print("-------");
            }
            System.out.println("-");
        }
    }
}