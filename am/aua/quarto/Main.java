package am.aua.quarto;

import am.aua.quarto.oi.*;
import am.aua.quarto.oi.terminal.*;
import am.aua.quarto.core.*;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java Main <1 for Terminal | 2 for GUI>");
            return;
        }

        IOHandler ioHandler;
        Game game = null;

        if (args[0].equals("1")) {
            ioHandler = new TerminalIOHandler();
        }
//        else if (args[0].equals("2")) {
//            ioHandler = new GUIIOHandler();
//        }
        else {
            System.out.println("Invalid argument. Use 1 for Terminal or 2 for GUI.");
            return;
        }

        String gameChoice = ioHandler.getInput(" Choose game mode:\n " +
                "1. Duel Game\n " +
                "2. Solo Game\n " +
                "3. Adventurous Game\n " +
                "Enter 1, 2 or 3:");

        switch (gameChoice.trim()) {
            case "1":
                game = new DuelGame(ioHandler);
                break;
            case "2":
                game = new SoloGame(ioHandler);
                break;
            case "3":
                game = new AdventurousGame(ioHandler);
                break;
            default:
                ioHandler.showMessage("Invalid choice. Exiting...");
                System.exit(0);
        }

        game.play();
    }
}