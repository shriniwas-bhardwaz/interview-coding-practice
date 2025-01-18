package LowLevelDesign.DesignTicTacToe;



public class TicTacToe implements GameEngine {
    private Board board;
    private Player currentPlayer;
    private Player player1;
    private  Player player2;
    private MoveStrategy moveStrategy;
    private WinStrategy winStrategy;
    private UIHandler uiHandler;


    public TicTacToe(int boardSize,GameMode gameMode,UIHandler uiHandler) {
        this.uiHandler = uiHandler;
        board = new Board(boardSize);

        switch(gameMode) {
            case HUMAN_VS_HOME:
                player1 = PlayerFactory.createPlayer('X',false);
                player2 = PlayerFactory.createPlayer('O',false);
                break;
            case HUMAN_VS_AI:
                player1 = PlayerFactory.createPlayer('X',false);
                player2 = PlayerFactory.createPlayer('O',true);
                break;
            case AI_VS_AI:
                player1 = PlayerFactory.createPlayer('X',true);
                player2 = PlayerFactory.createPlayer('O',true);
                break;
        }

        currentPlayer = player1;
        moveStrategy = new DefaultMoveStrategy();
        winStrategy = new DefaultWinStrategy();
        board.addObserver(player1);
        board.addObserver(player2);
    }


    @Override
    public void playTurn(int x,int y,boolean noWinner) {
        if(moveStrategy.isValidMove(board,x,y)) {
            board.updateBoard(x,y, currentPlayer.symbol);
            if(winStrategy.checkWin(board,  x, y, currentPlayer.getSymbol())) {
                System.out.println("Player " + currentPlayer.getSymbol() + " wins!");
                noWinner = false;
                return;
            }
            if(isDraw()) {
                System.out.println("Game is a draw!");
                noWinner = false;
                return;
            }
            switchPlayer();
        } else{
            System.out.println("Invalid move");
        }
    }



    public  void startGame() {
       boolean noWinner = true;
        while(noWinner) {
            uiHandler.displayBoard(board);
            int[] move = uiHandler.getMove();
            playTurn(move[0],move[1],noWinner);
        }
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }

    private boolean isDraw() {
        for(int i=0;i<board.getSize();i++) {
            for(int j=0;j< board.getSize();j++) {
                if(board.getCell(i,j) == '\0') return false;
            }
        }
        return true;
    }


}
