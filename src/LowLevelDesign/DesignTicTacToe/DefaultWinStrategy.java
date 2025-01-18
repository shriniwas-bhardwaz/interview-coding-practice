package LowLevelDesign.DesignTicTacToe;

public class DefaultWinStrategy implements WinStrategy{


    @Override
    public boolean checkWin(Board board, int row,int column,char symbol) {
        boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antidiagonalMatch = true;

        //need to check in row
        for(int i=0;i<board.getSize();i++) {
            if(board.getCell(row,i) == '\0' || board.getCell(row,i) != symbol) {
                rowMatch = false;
            }
        }

        //need to check in column
        for(int i=0;i<board.getSize();i++) {
            if(board.getCell(i,column) == '\0' || board.getCell(i,column) != symbol) {
                columnMatch = false;
            }
        }

        //need to check diagonals
        for(int i=0,j=0;i<board.getSize();i++,j++) {
            if(board.getCell(i,j) == '\0' || board.getCell(i,j) != symbol) {
                diagonalMatch = false;
            }
        }

        //need to check anti-diagonals
        for(int i=0,j=board.getSize()-1;i< board.getSize();i++,j--) {
            if(board.getCell(i,j) == '\0' || board.getCell(i,j) != symbol) {
                antidiagonalMatch = false;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antidiagonalMatch;
    
    
    }
}
