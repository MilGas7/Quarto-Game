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
}