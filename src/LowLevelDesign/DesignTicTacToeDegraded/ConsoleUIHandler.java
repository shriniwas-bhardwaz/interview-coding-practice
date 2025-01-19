package LowLevelDesign.DesignTicTacToeDegraded;


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


}
