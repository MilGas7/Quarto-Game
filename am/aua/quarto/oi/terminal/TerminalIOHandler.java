package am.aua.quarto.oi.terminal;

import am.aua.quarto.oi.*;
import am.aua.quarto.core.*;
import java.util.Scanner;

public class TerminalIOHandler implements IOHandler{
    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

    @Override
    public String getInput(String prompt) {
        System.out.println(prompt);
        Scanner keyboard = new Scanner(System.in);
        return keyboard.nextLine();
    }

    @Override
    public void showBoard(Board board){
        if (board instanceof StarBoard) {
            StarBoardTerminalPrinter.printBoard((StarBoard) board);
        }
        else {
            BoardTerminalPrinter.printBoard(board);
        }
    }
}
