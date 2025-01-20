package LowLevelDesign.DesignTicTacToeMain;

/*
We will yse the Factory pattern
 */
public abstract class Player {

    protected String name;
    protected char symbol;

    public String getName() {
        return  this.name;
    }
    public char getSymbol() {
        return symbol;
    }

    public abstract int[] makeMove(Board board);

    public abstract void update(Board board,Player player);
}
