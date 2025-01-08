package LowLevelDesign.DesignChessGame;

import java.util.List;

public class Pawn extends Piece{

    public Pawn(boolean isWhite,Square position) {
        super(Color.WHITE,position);
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
