package LowLevelDesign.DesignTicTacToeDegrade.strategy;

import LowLevelDesign.DesignTicTacToeDegrade.model.Board;

public interface Move {

    boolean isValidMove(Board board, int row, int column);
}
