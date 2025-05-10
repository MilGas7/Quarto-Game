package am.aua.quarto.core;

import am.aua.quarto.core.exceptions.*;

/**
 * Represents a game board for the Quarto game.
 */
public class Board {

    /**
     * The fixed size of the board (4x4).
     */
    public static final int SIZE = 4;

    /**
     * The array of placed pieces on the board.
     */
    private Piece[] tiles;

    /**
     * Array representing whether each of the 16 pieces has been used.
     */
    private boolean[] pieceCount;

    /**
     * Constructs an empty {@code Board} with all tiles set to null
     * and all pieces marked as unused.
     */
    public Board() {
        tiles = new Piece[SIZE * SIZE];
        for (int i = 0; i < tiles.length; i++) {
            tiles[i] = null;
        }
        pieceCount = new boolean[SIZE * SIZE]; //number of possible piece type
        for (int i = 0; i < pieceCount.length; i++)
            pieceCount[i] = false;
    }

    /**
     * Copy constructor that creates a deep copy of the given {@code Board}.
     *
     * @param original the board to copy.
     */
    public Board(Board original) {
        if (original == null) {
            System.out.println("Fatal error.");
            System.exit(0);
        }
        this.tiles = new Piece[SIZE * SIZE];
        this.pieceCount = new boolean[SIZE * SIZE];
        for (int i = 0; i < tiles.length; i++)
            this.tiles[i] = original.tiles[i];
        for (int i = 0; i < pieceCount.length; i++)
            this.pieceCount[i] = original.pieceCount[i];
    }


    /**
     * Checks whether a piece with the given index has been used.
     *
     * @param index the piece index.
     * @return {@code true} if the piece has been used; {@code false} otherwise.
     */
    public boolean getPieceCount(int index) {
        return this.pieceCount[index];
    }

    /**
     * Returns the piece at a specified tile index.
     *
     * @param index the tile index (0 to 15).
     * @return the {@link Piece} at the given index, or {@code null} if empty.
     */
    public Piece getTile(int index) {
        return tiles[index];
    }

    /**
     * Marks a piece as used by its index.
     *
     * @param index the index of the piece (0 to 15).
     */
    public void setPieceCount(int index) {
        this.pieceCount[index] = true;
    }

    /**
     * Places a piece on a tile at the specified index.
     *
     * @param index the tile index (0 to 15).
     * @param piece the {@link Piece} to place.
     */
    public void setTile(int index, Piece piece) {
        tiles[index] = piece;
    }

    /**
     * Checks if the index is within bounds and the tile is empty.
     *
     * @param index the tile index to validate.
     * @throws PositionOutOfBoardException if the index is out of range.
     * @throws NonEmptyTileException       if the tile is already occupied.
     */
    public void checkIndex(int index) {
        if (index < 0 || index >= SIZE * SIZE)
            throw new PositionOutOfBoardException("Row and column are out of board.");
        if (tiles[index] != null)
            throw new NonEmptyTileException("Tile of row " + (index / SIZE) + " and column " + (index % SIZE) + " is not empty");
    }

    /**
     * Validates that a piece has not been used and exists.
     *
     * @param pieceInt the integer representation of the piece.
     * @return {@code true} if the piece is valid and unused.
     * @throws NoSuchPieceException if the index is invalid.
     * @throws PieceRepeatException if the piece has already been used.
     */
    public boolean checkPiece(int pieceInt) {
        if (pieceInt < 0 || pieceInt >= 16)
            throw new NoSuchPieceException("There is no such piece.");
        if (pieceCount[pieceInt])
            throw new PieceRepeatException("You already had such a piece.");
        return true;
    }

    /**
     * Checks whether placing a piece at a specified location results in a "Quarto".
     *
     * @param row the row index of the last placed piece (0 to 3).
     * @param col the column index of the last placed piece (0 to 3).
     * @return {@code true} if a Quarto condition is met; {@code false} otherwise.
     */
    public boolean isQuarto(int row, int col) { //row and column of lastly putted piece
        if (Piece.haveCommonAttribute(getTile(row * SIZE + 0), getTile(row * SIZE + 1), getTile(row * SIZE + 2), getTile(row * SIZE + 3)))
            return true;
        if (Piece.haveCommonAttribute(getTile(0 * SIZE + col), getTile(1 * SIZE + col), getTile(2 * SIZE + col), getTile(3 * SIZE + col)))
            return true;
        if (row == col && Piece.haveCommonAttribute(getTile(0 * SIZE + 0), getTile(1 * SIZE + 1), getTile(2 * SIZE + 2), getTile(3 * SIZE + 3)))
            return true;
        if (row == SIZE - col - 1 && Piece.haveCommonAttribute(getTile(0 * SIZE + SIZE - 1), getTile(1 * SIZE + SIZE - 2), getTile(2 * SIZE + SIZE - 3), getTile(3 * SIZE + SIZE - 4)))
            return true;
        return false;
    }
}