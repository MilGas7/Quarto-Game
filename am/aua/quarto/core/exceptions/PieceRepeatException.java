package am.aua.quarto.core.exceptions;

/**
 * Exception thrown when a piece is repeated.
 */
public class PieceRepeatException extends RuntimeException {
    public PieceRepeatException() {
        super("Piece is repeating");
    }

    public PieceRepeatException(String message) {
        super(message);
    }
}
