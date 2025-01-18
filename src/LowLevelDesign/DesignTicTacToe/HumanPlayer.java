package LowLevelDesign.DesignTicTacToe;

import java.util.Scanner;

public class HumanPlayer extends Player {
    private Scanner scanner = new Scanner(System.in);

    public HumanPlayer(char symbol) {
        this.symbol = symbol;
    }

    @Override
    public void makeMove(Board board) {
        System.out.println("Player " + symbol + ", enter your move (row and column): ");
        Scanner inputScanner = new Scanner(System.in);
        String s = inputScanner.nextLine();
        String[] values = s.split(",");
        int x = Integer.parseInt(values[0]);
        int y = Integer.parseInt(values[1]);
        board.updateBoard(x, y, symbol);
    }

    @Override
    public void update(Board board) {
        // Implementation to update player with board state
        System.out.println("Board updated:");

    }
}
