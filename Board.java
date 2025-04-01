public class Board{

    public static final int SIZE = 4;
    private byte[] tiles;

    /**
     * Constructs an empty Board.
     */
    public Board(){
        tiles = new byte[SIZE * SIZE];
    }

    /**
     * Copy constructor for creating a new Board that is a copy of another Board.
     * @param original The Board to copy.
     */
    public Board(Board original){
        if (original == null){
            System.out.println("Fatal error.");
            System.exit(0);
        }
        this.tiles = original.tiles;
    }

    /**
     * Gives which piece is at the specified index.
     * @param index The index of the tile to retrieve.
     * @return The value of the tile at the specified index.
     */
    public byte getTile(int index) {
        return tiles[index];
    }

    /**
     * Sets the value of the tile at the specified index in the array.
     * @param index The index of the tile to set.
     * @param piece The byte value (appropriate to that piece) to set the tile to.
     */
    public void setTile(int index, byte piece) {
        tiles[index] = piece;
    }

    /**
     * Prints the current state of the puzzle matrix to the console.
     */
    public void print() {
        for (int i = 0; i < SIZE * SIZE; i++) {
            if (i == 0 || i == 15) {
                System.out.printf("%15d", i);
                System.out.println("| " + tiles[i] + " |");
                System.out.println();
            }
            else if (i == 1 || i == 13) {
                System.out.printf("%10d", i);
                System.out.print("| " + tiles[i] + " |");
                i += 1;
                System.out.printf("%5d", i);
                System.out.println("| " + tiles[i] + " |");
                System.out.println();
            }
            else if (i == 3 || i == 10) {
                System.out.printf("%5d", i);
                System.out.print("| " + tiles[i] + " |");
                i += 1;
                System.out.printf("%5d", i);
                System.out.print("| " + tiles[i] + " |");
                i += 1;
                System.out.printf("%5d", i);
                System.out.println("| " + tiles[i] + " |");
                System.out.println();
            }
            else if (i == 6) {
                for (int j = 0; j < SIZE; j++) {
                    System.out.print("| " + tiles[i] + " |");
                    System.out.printf("%-5d", i);
                    i += 1;
                }
                i -= 1;
                System.out.println();
                System.out.println();
            }
        }
    }

}