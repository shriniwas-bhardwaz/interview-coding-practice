package LowLevelDesign.DesignTicTacToeDegrade.model;

public class PlayingPiece {

    public PieceType pieceType;

    public PlayingPiece(PieceType pieceType) {
        this.pieceType = pieceType;
    }

    public PieceType getPieceType() {
        return pieceType;
    }
}
