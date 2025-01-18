package LowLevelDesign.DesignTicTacToe;


import java.util.concurrent.ThreadLocalRandom;

public class AIPlayer extends Player {


    public AIPlayer(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public void makeMove(Board board) {
        System.out.println("Player " + symbol + ", enter your move (row and column): ");
        int x = ThreadLocalRandom.current().nextInt(0,3);
        int y = ThreadLocalRandom.current().nextInt(0,3);
        board.updateBoard(x, y, symbol);
    }

    @Override
    public void update(Board board) {
        // Implementation to update player with board state
        System.out.println("Board updated:");
        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                System.out.print(board.getCell(i, j) + " ");
            }
            System.out.println();
        }
    }
}
