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
                player1 = PlayerFactory.createPlayer('X',"Player1",false);
                player2 = PlayerFactory.createPlayer('O',"Player2",false);
                break;
            case HUMAN_VS_AI:
                player1 = PlayerFactory.createPlayer('X',"Player1",false);
                player2 = PlayerFactory.createPlayer('O',"AI",true);
                break;
            case AI_VS_AI:
                player1 = PlayerFactory.createPlayer('X',"AI1",true);
                player2 = PlayerFactory.createPlayer('O',"AI2",true);
                break;
        }

        currentPlayer = player1;
        moveStrategy = new DefaultMoveStrategy();
        winStrategy = new DefaultWinStrategy();
        board.addObserver(player1);
        board.addObserver(player2);
    }


    public  void startGame() {
       GameState gameState = GameState.IN_PROGRESS;
        while(gameState == GameState.IN_PROGRESS) {
            uiHandler.displayBoard(board);
            int[] move = currentPlayer.makeMove(board);
           gameState = playTurn(move[0],move[1]);
        }
    }


    @Override
    public GameState playTurn(int x,int y) {
        if(moveStrategy.isValidMove(board,x,y)) {
            board.updateBoard(x,y,currentPlayer.getSymbol(),currentPlayer);
            if(winStrategy.checkWin(board,  x, y, currentPlayer.getSymbol())) {
                System.out.println("Player " + currentPlayer.getSymbol() + " wins!");
                return GameState.WIN;
            }
            if(isDraw()) {
                System.out.println("Game is a draw!");
                return GameState.DRAW;
            }
            switchPlayer();
            return GameState.IN_PROGRESS;
        } else{
            System.out.println("Invalid move");
            return GameState.IN_PROGRESS;
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
