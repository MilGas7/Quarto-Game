package am.aua.quarto;
import am.aua.quarto.core.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Input:\n" +
                "1 for playing original version with 2 players \n" +
                "2 for playing original version with random generator");
        int n = keyboard.nextInt();
        Game game;
        switch (n){
            case 1:
                game = new DuelGame();
                game.play();
                break;
            case 2:
                game = new SoloGame();
                game.play();
                break;
            default:
                System.out.println("Fatal error:");
                System.exit(0);
        }

    }
}