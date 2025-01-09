package LowLevelDesign.DesignChessGame;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece{
    public King(Color color,Square position) {
        super(color,position);
    }

    @Override
    public List<Square> getValidMoves(ChessBoard board) {
        List<Square> validMoves = new ArrayList<>();
        int[][] directions = {
                {-1,-1},{-1,0},{-1,1},
                {0,-1},{0,1},{1,0},{1,1},{1,-1}
        };

        for(int[] dir: directions) {
            int newRow = getPosition().getRow() + dir[0];
            int newCol = getPosition().getCol() + dir[1];
            try {
                Square target = board.getSquare(newRow, newCol);
//                if(target.isEmpty() || target.getPiece() != this.isSameColor(target.getPiece())r)) {
//                    validMoves.add(target);
//                }
            } catch(Exception e) {
                System.out.println("Invalid move");
            }
        }
        return validMoves;
    }

    @Override
    public boolean isValidMove(Move move, ChessBoard board) {
        int x = Math.abs(move.getStartSquare().getRow() - move.getEndSquare().getRow());
        int y = Math.abs(move.getStartSquare().getCol() - move.getEndSquare().getCol());
        return (x<=1 && y<=1);
    }


}
