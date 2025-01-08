package LowLevelDesign.DesignChessGame;

import java.util.List;

/** Abstract classes can have public,protected
 * or private concrete methods,but abstract
 * methods cannot be private
 */
public abstract class Piece {

    private Color color;
    private Square position;

    public Piece(Color color, Square position) {
        this.color = color;
        this.position = position;
    }

    public abstract List<Square> getValidMoves(ChessBoard board);

    public abstract char getSymbol();

    public boolean isSameColor(Piece other) {
        return this.color == other.color;
    }

    public void setPosition(Square position) {
        this.position = position;
    }

    public Square getPosition() {
        return position;
    }
}
