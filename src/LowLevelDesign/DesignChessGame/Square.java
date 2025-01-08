package LowLevelDesign.DesignChessGame;

public class Square {

    private final int row;
    private final int col;
    private Piece piece;

    public Square(int row, int col) {
        this.row = row;
        this.col = col;
        this.piece = null;
    }

    public boolean isEmpty() {
        return this.piece == null;
    }

    public Piece getPiece() {
        return this.piece;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public int getRow() {
        return this.row;
    }

    public int getCol() {
        return this.col;
    }
}
