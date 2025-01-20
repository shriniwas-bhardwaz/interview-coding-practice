package LowLevelDesign.DesignTicTacToeMain;

public enum PlayingPiece {
    X('X'),
    O('O');

    private final char symbol;

    PlayingPiece(char symbol) {
        this.symbol = symbol;
    }

    public char getSymbol() {
        return symbol;
    }
}
