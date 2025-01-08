package LowLevelDesign.DesignChessGame;

public class ChessBoard {

    private Square[][] board;
    private int size;

    public ChessBoard(int size) {
        this.size = size;
        this.board = new Square[size][size];
        initializeBoard();
    }

    private void initializeBoard() {
        for(int row =0;row<size;row++) {
            for(int col=0;col<size;col++) {
                board[row][col] = new Square(row, col);
            }
        }
        setUpPieces();
    }

    private void setUpPieces() {
        for(int col=0;col<8;col++) {
            board[1][col].setPiece(new Pawn(false, board[1][col])); // Black pawns
            board[size-2][col].setPiece(new Pawn(true, board[size-2][col])); // White pawns
        }
        board[size-1][4].setPiece(new King(Color.WHITE, board[size-1][4]));
        board[0][4].setPiece(new King(Color.BLACK,board[0][4]));

        // Rooks
        board[0][0].setPiece(new Rook(Color.BLACK, board[0][0])); // Black Rook
        board[0][size-1].setPiece(new Rook(Color.BLACK, board[0][size-1]));
        board[size-1][0].setPiece(new Rook(Color.WHITE, board[size-1][0]));  // White Rook
        board[size-1][size-1].setPiece(new Rook(Color.WHITE, board[size-1][size-1]));

        // Bishops
        board[0][2].setPiece(new Bishop(Color.BLACK, board[0][2])); // Black Bishop
        board[0][5].setPiece(new Bishop(Color.BLACK, board[0][5]));
        board[7][2].setPiece(new Bishop(Color.WHITE, board[7][2]));  // White Bishop
        board[7][5].setPiece(new Bishop(Color.WHITE, board[7][5]));
    }

    public Square getSquare(int row, int col) {
        if(row >=0 && row< size && col >=0 && col < size) {
            return board[row][col];
        }
        throw  new IllegalArgumentException("Invalid board position");
    }


}
