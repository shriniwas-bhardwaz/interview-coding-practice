package LowLevelDesign.DesignTicTacToe;

public class PlayerFactory {

    public static Player createPlayer(char symbol,boolean isMachine) {
       if(isMachine) {
           return  new AIPlayer(symbol);
       }
       else
           return  new HumanPlayer(symbol);
    }

}
