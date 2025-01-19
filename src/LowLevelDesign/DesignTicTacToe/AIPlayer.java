package LowLevelDesign.DesignTicTacToe;


import java.util.concurrent.ThreadLocalRandom;

public class AIPlayer extends Player {


    public AIPlayer(String name,char symbol) {
        this.name = name;
        this.symbol = symbol;
    }

    @Override
    public int[] makeMove(Board board) {
        System.out.println("Player " + symbol + ", enter your move (row and column): ");
        int x = ThreadLocalRandom.current().nextInt(0,3);
        int y = ThreadLocalRandom.current().nextInt(0,3);
        return new int[] {x,y};
    }

    @Override
    public void update(Board board,Player player) {
        // Implementation to update player with board state
        System.out.println("Board updated:"+player.getName());

    }
}
