package LowLevelDesign.DesignChessGame;

import java.util.List;

public class Rook extends Piece {
    public Rook(Color color, Square position) {
        super(color, position);
    }

    @Override
    public List<Square> getValidMoves(ChessBoard board) {
        return getSquares();
    }

    private static List<Square> getSquares() {
        return List.of();
    }

    @Override
    public char getSymbol() {
        return 0;
    }
}
