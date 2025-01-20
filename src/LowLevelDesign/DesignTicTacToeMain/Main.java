package LowLevelDesign.DesignTicTacToeMain;



public class Main {
    public static void main(String[] args) {
        GameController controller = GameController.getInstance();
        int gameId = controller.createGame(3, GameMode.HUMAN_VS_AI,2);
        controller.startGame(gameId);

    }
}
