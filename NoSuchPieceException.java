public class NoSuchPieceException extends RuntimeException {
    public NoSuchPieceException() {
      super("No such piece found.");
    }
    public NoSuchPieceException(String message) {
        super(message);
    }
}
