package LowLevelDesign.DesignSnakeAndLadder;



public class PlayerThread extends Thread {
    private Player player;
    private Game game;
    private DiceStrategy dice;
    private Board board;

    public PlayerThread(Player player, Game game, DiceStrategy dice, Board board) {
        this.player = player;
        this.game = game;
        this.dice = dice;
        this.board = board;
    }

    @Override
    public void run() {
        while (true) {
            game.playerTurn(player,dice,board);
            if(player.getPosition() == board.getSize()) {
                break; // Exit if the player has won
            }
        }
    }
}