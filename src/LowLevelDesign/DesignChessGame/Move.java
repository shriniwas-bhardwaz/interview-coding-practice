package LowLevelDesign.DesignChessGame;

public class Move {

    private Square startSquare;
    private Square endSquare;
    private Piece movedPiece;
    private boolean isCapture;

    public Move(Square startSquare,Square endSquare) {
        this.startSquare = startSquare;
        this.endSquare = endSquare;
        this.movedPiece = startSquare.getPiece();
        this.isCapture = !endSquare.isEmpty();
    }

    public boolean isValidMove() {
        return movedPiece != null && movedPiece.isValidMove(this,null);
    }

    public void execute() {
        endSquare.setPiece(movedPiece);
        startSquare.setPiece(null);
    }
    public Square getStartSquare() {
        return startSquare;
    }

    public Square getEndSquare() {
        return endSquare;
    }
}
