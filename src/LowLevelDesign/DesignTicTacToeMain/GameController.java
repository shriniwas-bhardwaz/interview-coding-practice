package LowLevelDesign.DesignTicTacToeMain;

import java.util.HashMap;
import java.util.Map;

/* We will use the Singleton pattern to
ensure that there is only one instance of the game controller.
Multiple tic tac toe games can run simultaneously */
public class GameController {

    private static GameController instance;
    private Map<Integer,TicTacToe> games = new HashMap<>();
    private static int gameIdConter =0;


    public static GameController getInstance() {
        if(instance == null) {
            return  new GameController();
        }
        return  instance;
    }

    public int createGame(int boardSize, GameMode gameMode,int numberOfPlayers) {
        int gameId = gameIdConter++;
        UIHandler uiHandler = new ConsoleUIHandler();
        TicTacToe newGame = new TicTacToe(boardSize,gameMode,uiHandler,numberOfPlayers);
        games.put(gameId,newGame);
        return gameId;
    }

    public void startGame(int gameId) {
        TicTacToe game = games.get(gameId);
        if(game != null) {
            game.startGame();
        }else {
            System.out.println("Game not found!");
        }
    }


}
