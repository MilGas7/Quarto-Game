package am.aua.quarto.core.exceptions;

/**
 * Exception thrown when a specified trait is not found..
 */
public class TraitNotFoundException extends RuntimeException {
    public TraitNotFoundException() {
        super("Trait is not found exception");
    }

    public TraitNotFoundException(String message) {
        super(message);
    }
}
