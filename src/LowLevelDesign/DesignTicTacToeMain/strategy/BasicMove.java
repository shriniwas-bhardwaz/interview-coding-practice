package LowLevelDesign.DesignTicTacToeMain.strategy;

import LowLevelDesign.DesignTicTacToeMain.model.Board;

public class BasicMove implements Move{
    @Override
    public boolean isValidMove(Board board, int row, int column) {
        if(row < 0 || row > board.getSize() || column < 0 || column > board.getSize())
            return false;
        return board.getBoard()[row][column] == null;
    }
}
