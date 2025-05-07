package am.aua.quarto.core;

public abstract class Game implements Gameable{
    private Player player1;
    private Player player2;
    private Board board;
    private boolean player1Turn;

    public Game(){
        player1 = new Player();
        player2 = new Player();
        board = new Board();
        player1Turn = true;
    }

    public Player getPlayer1(){ return this.player1; }

    public Player getPlayer2(){ return this.player2; }

    public Board getboard(){return board; }

    public boolean getPlayer1Turn() {return this.player1Turn; }

    public void setPlayer2(Player player) { this.player2 = player; }

    public void changePlayer1Turn() { this.player1Turn = !player1Turn; }

    public abstract void play();
}
