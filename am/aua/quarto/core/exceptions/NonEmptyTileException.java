package am.aua.quarto.core.exceptions;

public class NonEmptyTileException extends RuntimeException {
    public NonEmptyTileException(){
        super("Tile is not empty");
    }
    public NonEmptyTileException(String message) {
        super(message);
    }
}
