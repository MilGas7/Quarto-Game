package am.aua.quarto.core.exceptions;

/**
 * Exception thrown when a position is outside the valid range of the board.
 */
public class PositionOutOfBoardException extends RuntimeException {
    public PositionOutOfBoardException() {
        super("Position out of board exception");
    }

    public PositionOutOfBoardException(String message) {
        super(message);
    }
}
