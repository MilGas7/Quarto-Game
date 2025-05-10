package am.aua.quarto.core;

import am.aua.quarto.oi.*;

/**
 * An abstract representation of a Quarto game.
 */
public abstract class Game implements Gameable {

    /**
     * The first player in the game.
     */
    private Player player1;

    /**
     * The second player in the game.
     */
    private Player player2;

    /**
     * The game board.
     */
    private Board board;

    /**
     * Indicates whether it's player1's turn.
     */
    private boolean player1Turn;

    /**
     * IO handler used for user interaction and output.
     */
    public IOHandler io;

    /**
     * Constructs a new {@code Game} with the given IO handler.
     *
     * @param ioHandler the IO handler to manage input/output interactions.
     */
    public Game(IOHandler ioHandler) {
        this.io = ioHandler;
        player1 = new Player();
        player2 = new Player();
        board = new Board();
        player1Turn = true;
    }

    /**
     * Returns player 1.
     *
     * @return the first player.
     */
    public Player getPlayer1() {
        return this.player1;
    }

    /**
     * Returns player 2.
     *
     * @return the second player.
     */
    public Player getPlayer2() {
        return this.player2;
    }

    /**
     * Returns the current game board.
     *
     * @return the board being used in the game.
     */
    public Board getboard() {
        return board;
    }

    /**
     * Returns whether it is player 1's turn.
     *
     * @return {@code true} if it's player 1's turn, {@code false} otherwise.
     */
    public boolean getPlayer1Turn() {
        return this.player1Turn;
    }

    /**
     * Sets the second player.
     *
     * @param player the player to assign as player 2.
     */
    public void setPlayer2(Player player) {
        this.player2 = player;
    }

    /**
     * Sets the first player.
     *
     * @param player the player to assign as player 1.
     */
    public void setPlayer1(Player player) {
        this.player1 = player;
    }

    /**
     * Sets the board for the game. If the input board is a {@link StarBoard}, it makes a deep copy.
     * Otherwise, it uses a regular {@link Board} copy.
     *
     * @param board the board to assign to the game.
     */
    public void setBoard(Board board) {
        if (board instanceof StarBoard) {
            this.board = new StarBoard((StarBoard) board);
        } else {
            this.board = new Board(board);
        }
    }

    /**
     * Switches the current player turn from player 1 to player 2 or vice versa.
     */
    public void changePlayer1Turn() {
        this.player1Turn = !player1Turn;
    }

    /**
     * Starts the game. Each subclass must define its own gameplay logic.
     */
    public abstract void play();
}
