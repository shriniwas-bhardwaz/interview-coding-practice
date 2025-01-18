package LowLevelDesign.DesignTicTacToeOld.strategy;

import LowLevelDesign.DesignTicTacToeOld.model.Board;

public interface Move {

    boolean isValidMove(Board board, int row, int column);
}
