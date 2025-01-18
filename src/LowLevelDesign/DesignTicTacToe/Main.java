package LowLevelDesign.DesignTicTacToe;



public class Main {
    public static void main(String[] args) {
        GameController controller = GameController.getInstance();
        int gameId = controller.createGame(3, GameMode.HUMAN_VS_HOME);
        controller.startGame(gameId);

    }
}
