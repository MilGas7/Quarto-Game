public abstract class Game implements Gameable{
    Player player1;
    Player player2;
    Board board;
    boolean player1Turn;

    public Game(){
        player1 = new Player();
        player2 = new Player();
        board = new Board();
        player1Turn = true;
    }

    public abstract void play();
}
