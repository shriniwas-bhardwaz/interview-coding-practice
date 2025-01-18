package LowLevelDesign.DesignTicTacToe;

import java.util.Scanner;

public class ConsoleUIHandler implements UIHandler{

    @Override
    public void displayBoard(Board board) {

        for (int i = 0; i < board.getSize(); i++) {
            for (int j = 0; j < board.getSize(); j++) {
                if (board.getCell(i,j) !=  '\0') {
                    System.out.print(board.getCell(i,j) + "   ");
                } else {
                    System.out.print("    ");

                }
                System.out.print(" | ");
            }
            System.out.println();

        }
    }

    @Override
    public int[] getMove() {
        System.out.println("Enter your move (row and column): ");
        Scanner inputScanner = new Scanner(System.in);
        String s = inputScanner.nextLine();
        String[] values = s.split(",");
        int inputRow = Integer.parseInt(values[0]);
        int inputColumn = Integer.parseInt(values[1]);
        return new int[]{inputRow, inputColumn};
    }
}
