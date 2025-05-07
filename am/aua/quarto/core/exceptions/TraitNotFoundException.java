package am.aua.quarto.core.exceptions;

public class TraitNotFoundException extends RuntimeException {
    public TraitNotFoundException(){
        super("Trait is not found exception");
    }
    public TraitNotFoundException(String message) {
        super(message);
    }
}
