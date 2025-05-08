package am.aua.quarto.oi.terminal;

import am.aua.quarto.oi.*;
import am.aua.quarto.core.*;

public class StarBoardTerminalPrinter {
    public static void printBoard(StarBoard starBoard) {
        System.out.print("   ");
        for(int i = 0; i < Board.SIZE; i++) {
            System.out.print("    " + i + "  ");
        }
        System.out.println();

        for (int row = 0; row < Board.SIZE; row++) {
            System.out.print("    ");
            for(int i = 0; i < Board.SIZE; i++) {
                System.out.print("-------");
            }
            System.out.print("-\n" + row + "   ");

            for (int col = 0; col < Board.SIZE; col++) {
                ChangeablePiece piece = starBoard.getTile(row * Board.SIZE + col);
                if(piece == null) {
                    System.out.print("|      ");
                } else {
                    System.out.print("| " + piece.getNameOfPiece().toString() + " ");
                }
            }
            System.out.println("|");

            System.out.print("    ");
            for(int i = 0; i < Board.SIZE; i++) {
                System.out.print("-------");
            }
            System.out.println("-");
        }
    }
}
