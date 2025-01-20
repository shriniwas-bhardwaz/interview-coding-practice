package LowLevelDesign.DesignTicTacToeMain;

public class PlayerFactory {

    public static Player createPlayer(char symbol, String name,boolean isMachine) {
       if(isMachine) {
           return  new AIPlayer(name,symbol);
       }
       else
           return  new HumanPlayer(name,symbol);
    }

}
