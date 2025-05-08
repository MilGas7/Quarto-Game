package am.aua.quarto.oi;

import am.aua.quarto.core.*;

public interface IOHandler {
    public void showMessage(String message);
    public String getInput(String prompt);
    public void showBoard(Board board);
}
