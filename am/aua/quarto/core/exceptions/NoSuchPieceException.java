package am.aua.quarto.core.exceptions;

/**
 * Exception thrown when attempting to reference a piece that does not exist.
 */
public class NoSuchPieceException extends RuntimeException {
    public NoSuchPieceException() {
        super("No such piece found.");
    }

    public NoSuchPieceException(String message) {
        super(message);
    }
}
