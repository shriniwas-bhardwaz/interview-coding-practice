package LowLevelDesign.DesignTicTacToeMain;

public interface GameEngine {
    GameState playTurn(int x, int y,Player currentPlayer);

}
