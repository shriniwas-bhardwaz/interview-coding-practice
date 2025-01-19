package LowLevelDesign.DesignTicTacToeMain.strategy;

import LowLevelDesign.DesignTicTacToeMain.model.Board;

public interface Move {

    boolean isValidMove(Board board, int row, int column);
}
