package LowLevelDesign.DesignSnakeAndLadder;


public class SnakeAndLadderGame {
    public static void main(String[] args) {
        Board board = Board.getInstance(100);
        ObstacleFactory.createSnakes(board, 6);
        ObstacleFactory.createLadders(board, 8);

        Game game = new Game();
        Player player1 = new Player("Alice");
        Player player2 = new Player("Bob");

        game.addPlayer(player1);
        game.addPlayer(player2);

        DiceStrategy dice = new NormalDice();

        // Create and start threads for each player
        new PlayerThread(player1, game, dice, board).start();
        new PlayerThread(player2, game, dice, board).start();
    }
}