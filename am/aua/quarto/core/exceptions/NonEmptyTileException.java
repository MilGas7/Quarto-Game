package am.aua.quarto.core.exceptions;

/**
 * Exception thrown when attempting to place a piece on a tile that is not empty.
 */
public class NonEmptyTileException extends RuntimeException {
    public NonEmptyTileException() {
        super("Tile is not empty");
    }

    public NonEmptyTileException(String message) {
        super(message);
    }
}
