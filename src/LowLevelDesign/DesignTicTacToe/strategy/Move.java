package LowLevelDesign.DesignTicTacToe.strategy;

import LowLevelDesign.DesignTicTacToe.model.Board;

public interface Move {

    boolean isValidMove(Board board, int row, int column);
}
