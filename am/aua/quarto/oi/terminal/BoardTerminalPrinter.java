package am.aua.quarto.oi.terminal;

import am.aua.quarto.core.*;

/**
 * A utility class for printing a standard {@link Board} to the terminal.
 */
public class BoardTerminalPrinter {
    public static void printBoard(Board board) {
        System.out.print("   ");
        for (int i = 0; i < Board.SIZE; i++) {
            System.out.print("    " + i + "  ");
        }
        System.out.println();
        for (int row = 0; row < Board.SIZE; row++) {
            System.out.print("    ");
            for (int i = 0; i < Board.SIZE; i++) {
                System.out.print("-------");
            }
            System.out.print("-\n" + row + "   ");
            for (int col = 0; col < Board.SIZE; col++) {
                if (board.getTile(row * Board.SIZE + col) == null) {
                    System.out.print("|      ");
                } else {
                    System.out.print("| " + board.getTile(row * Board.SIZE + col).getNameOfPiece().toString() + " ");
                }
            }
            System.out.println("|");
            System.out.print("    ");
            for (int i = 0; i < Board.SIZE; i++) {
                System.out.print("-------");
            }
            System.out.println("-");
        }
    }
}
