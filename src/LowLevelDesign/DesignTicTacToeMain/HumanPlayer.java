package LowLevelDesign.DesignTicTacToeMain;

import java.util.Scanner;

public class HumanPlayer extends Player {


    public HumanPlayer(String name,char symbol) {
       this.name = name;
        this.symbol = symbol;
    }

    @Override
    public int[] makeMove(Board board) {
        System.out.println("Player " + symbol + ", enter your move (row and column): ");
        Scanner inputScanner = new Scanner(System.in);
        String s = inputScanner.nextLine();
        String[] values = s.split(",");
        int x = Integer.parseInt(values[0]);
        int y = Integer.parseInt(values[1]);
        return new int[] {x,y};
    }

    @Override
    public void update(Board board,Player player) {
        // Implementation to update player with board state
        System.out.println("Board updated:" + player.getName());
    }
}
