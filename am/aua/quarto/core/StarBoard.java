package am.aua.quarto.core;

import java.util.Random;

/**
 * Represents a variant of the Quarto game board with a stars.
 */
public class StarBoard extends Board {

    /**
     * The total number of star tiles on the board.
     */
    public static final int STARNUMBER = 4;

    /**
     * An array that tracks whether a tile contains a star.
     */
    private boolean[] starArray;

    /**
     * An array of tiles, each represented by a {@link ChangeablePiece}.
     */
    private ChangeablePiece[] tiles;

    /**
     * Constructs a new StarBoard, randomly selecting 4 tiles to be star tiles.
     */
    public StarBoard() {
        super();
        Random randomGen = new Random();
        this.tiles = new ChangeablePiece[SIZE * SIZE];
        starArray = new boolean[SIZE * SIZE];
        int i = 0;
        while (i < STARNUMBER) {
            int thisStar = randomGen.nextInt(SIZE * SIZE);
            if (!starArray[thisStar]) {
                starArray[thisStar] = true;
                i++;
            }
        }
    }

    /**
     * Constructs a new StarBoard by copying the state of another StarBoard.
     *
     * @param original the original StarBoard to copy
     */
    public StarBoard(StarBoard original) {
        super(original);
        this.tiles = new ChangeablePiece[SIZE * SIZE];
        for (int i = 0; i < SIZE * SIZE; i++) {
            this.tiles[i] = original.tiles[i] != null ?
                    new ChangeablePiece(original.tiles[i]) : null;
        }
        this.starArray = new boolean[SIZE * SIZE];
        for (int i = 0; i < SIZE * SIZE; i++)
            this.starArray[i] = original.starArray[i];
    }

    /**
     * Returns whether the tile at the specified index is a star tile.
     *
     * @param index the index of the tile (0 to 15)
     * @return true if the tile at the specified index is a star tile, false otherwise
     */
    public boolean hasStar(int index) {
        return starArray[index];
    }

    /**
     * Sets a tile at the specified index with a given piece.
     *
     * @param index the index of the tile to set (0 to 15)
     * @param piece the piece to place on the tile
     */
    @Override
    public void setTile(int index, Piece piece) {
        super.setTile(index, piece);
        this.tiles[index] = ChangeablePiece.fromPiece(piece);
    }

    /**
     * Gets the tile at the specified index.
     *
     * @param index the index of the tile to retrieve (0 to 15)
     * @return the {@link ChangeablePiece} at the specified index, or null if the tile is empty
     */
    @Override
    public ChangeablePiece getTile(int index) {
        Piece piece = super.getTile(index);
        return piece != null ? (ChangeablePiece) piece : null;
    }
}
