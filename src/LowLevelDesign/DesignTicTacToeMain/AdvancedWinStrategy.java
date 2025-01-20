package LowLevelDesign.DesignTicTacToeMain;



import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AdvancedWinStrategy implements WinStrategy{

    Map<Character,int[]> rowCounter ;
    Map<Character,int[]> colCounter ;
    Map<Character,Integer> diagonalCounter ;
    Map<Character,Integer> antiDiagonalCounter ;

    public AdvancedWinStrategy() {
        //initialize counters
        rowCounter = new HashMap<>();
        colCounter = new HashMap<>();
        diagonalCounter = new HashMap<>();
        antiDiagonalCounter = new HashMap<>();

        List<Character> symbols = Arrays.asList('X','O');
        for(char ch: symbols) {
            rowCounter.put(ch,new int[3]);
            colCounter.put(ch,new int[3]);
            diagonalCounter.put(ch,0);
            antiDiagonalCounter.put(ch,0);
        }

    }

    @Override
    public boolean checkWin(Board board, int row,int column,char symbol) {
        rowCounter.get(symbol)[row]++;
        colCounter.get(symbol)[column]++;


        if(row == column)
        {  diagonalCounter.put(symbol,diagonalCounter.get(symbol)+1); }
        if(row + column == board.getSize()-1)
        { antiDiagonalCounter.put(symbol,antiDiagonalCounter.get(symbol)+1); }

        int boardSize = board.getSize();

        return rowCounter.get(symbol)[row] == boardSize ||
                colCounter.get(symbol)[column] == boardSize ||
                diagonalCounter.get(symbol) == boardSize ||
                antiDiagonalCounter.get(symbol) == boardSize;
    }
}
