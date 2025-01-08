package LowLevelDesign.DesignChessGame;

import java.util.List;

public class Bishop extends  Piece {

    public Bishop(Color color ,Square board) {
        super(color, board);
    }
    @Override
    public List<Square> getValidMoves(ChessBoard board) {
        return List.of();
    }

    @Override
    public char getSymbol() {
        return 0;
    }
}
