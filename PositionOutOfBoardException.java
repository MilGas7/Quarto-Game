public class PositionOutOfBoardException extends RuntimeException {
    public PositionOutOfBoardException() {
        super("Position out of board exception");
    }
    public PositionOutOfBoardException(String message) {
        super(message);
    }
}
