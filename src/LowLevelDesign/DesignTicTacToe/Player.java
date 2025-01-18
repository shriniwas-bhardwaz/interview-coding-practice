package LowLevelDesign.DesignTicTacToe;

/*
We will yse the Factory pat
 */
public abstract class Player {

    protected char symbol;

    public char getSymbol() {
        return symbol;
    }

    public abstract void makeMove(Board board);

    public abstract void update(Board board);
}