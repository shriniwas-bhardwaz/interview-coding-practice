package LowLevelDesign.DesignTicTacToeMain;

public interface WinStrategy {
    boolean checkWin(Board board, int row, int column,char symbol);
}
