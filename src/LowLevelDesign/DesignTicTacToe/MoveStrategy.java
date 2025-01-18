package LowLevelDesign.DesignTicTacToe;

public interface MoveStrategy {

    boolean isValidMove(Board board, int x, int y);

}
