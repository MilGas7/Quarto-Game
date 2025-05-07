package am.aua.quarto.core.exceptions;

public class PieceRepeatException extends RuntimeException {
    public PieceRepeatException() {
        super("Piece is repeating");
    }
    public PieceRepeatException(String message) {
        super(message);
    }
}
