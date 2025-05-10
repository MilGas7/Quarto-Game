package am.aua.quarto;

import am.aua.quarto.oi.*;
import am.aua.quarto.oi.terminal.*;
import am.aua.quarto.oi.gui.*;
import am.aua.quarto.core.*;

/**
 * The entry point for the Quarto game application.
 */
public class Main {

    /**
     * The main method.
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Usage: java Main <1 for Terminal | 2 for GUI>");
            return;
        }

        IOHandler ioHandler;
        Game game;
        if (args[0].equals("1")) { // Terminal mode
            ioHandler = new TerminalIOHandler();

            String gameChoice = ioHandler.getInput("Choose game mode:\n " +
                    "1. Duel Game\n " +
                    "2. Solo Game\n " +
                    "3. Adventurous Game\n " +
                    "Enter 1, 2 or 3:");

            if (gameChoice == null || gameChoice.trim().isEmpty()) {
                ioHandler.showMessage("No input provided. Exiting...");
                return;
            }

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
                    return;
            }

            game.play();

        } else if (args[0].equals("2")) { //GUI mode
            new MainMenu();
        } else {
            System.out.println("Invalid argument. Use 1 for Terminal or 2 for GUI.");
        }
    }
}