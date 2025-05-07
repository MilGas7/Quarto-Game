package am.aua.quarto.core.exceptions;

public class NoSuchPieceException extends RuntimeException {
    public NoSuchPieceException() {
      super("No such piece found.");
    }
    public NoSuchPieceException(String message) {
        super(message);
    }
}
