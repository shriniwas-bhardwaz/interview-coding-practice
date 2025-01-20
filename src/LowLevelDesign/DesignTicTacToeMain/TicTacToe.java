package LowLevelDesign.DesignTicTacToeMain;



import java.util.Deque;
import java.util.LinkedList;

public class TicTacToe implements GameEngine {
    private Board board;
    private Deque<Player> players;
    private MoveStrategy moveStrategy;
    private WinStrategy winStrategy;
    private UIHandler uiHandler;


    public TicTacToe(int boardSize,GameMode gameMode,UIHandler uiHandler,int numberOfPlayers) {
        this.uiHandler = uiHandler;
        board = new Board(boardSize);
        players = new LinkedList<>();

        //Get available PieceType symbols
        PlayingPiece[] pieces = PlayingPiece.values();
        int availableSymbols = pieces.length;

        // Create players based on the number of players
        createPlayersForGame(gameMode, numberOfPlayers, availableSymbols, pieces);


        moveStrategy = new DefaultMoveStrategy();
        winStrategy = new DefaultWinStrategy();

    }

    private void createPlayersForGame(GameMode gameMode, int numberOfPlayers, int availableSymbols, PlayingPiece[] pieces) {
        for (int i = 0; i < numberOfPlayers; i++) {
            if (i >= availableSymbols) {
                throw new IllegalArgumentException("Not enough symbols for the number of players.");
            }
            PlayingPiece pieceType = pieces[i];
            String playerName = "Player" + (i + 1);
            boolean isAI = (gameMode == GameMode.AI_VS_AI || (gameMode == GameMode.HUMAN_VS_AI && i == 1));
            Player player = PlayerFactory.createPlayer(pieceType.getSymbol(), playerName, isAI);
            players.add(player);
            board.addObserver(player);
        }
    }


    public  void startGame() {
       GameState gameState = GameState.IN_PROGRESS;
        while(gameState == GameState.IN_PROGRESS) {
            uiHandler.displayBoard(board);
            Player currentPlayer = players.removeFirst();
            int[] move = currentPlayer.makeMove(board);
           gameState = playTurn(move[0],move[1],currentPlayer);
        }
    }


    @Override
    public GameState playTurn(int x,int y,Player currentPlayer) {
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
            players.addLast(currentPlayer);
            return GameState.IN_PROGRESS;
        } else{
            System.out.println("Invalid move");
            players.addFirst(currentPlayer);
            return GameState.IN_PROGRESS;
        }
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
