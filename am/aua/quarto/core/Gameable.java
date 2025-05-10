package am.aua.quarto.core;

/**
 * Represents a contract for any playable Quarto game mode.
 */
public interface Gameable {

    /**
     * Starts and runs the game logic.
     * Implementing classes must define how the game proceeds from start to finish.
     */
    public void play();
}
