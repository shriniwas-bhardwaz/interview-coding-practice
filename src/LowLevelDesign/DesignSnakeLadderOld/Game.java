package LowLevelDesign.DesignSnakeLadderOld;

import java.util.Deque;
import java.util.LinkedList;

public class Game {

    Board board;
    Dice dice;
    Deque<Player> players;
    Player winner;

    public Game() {
        initializeGame();
    }

    private void initializeGame() {
        board = new Board(10,5,6);
        dice = new Dice(2);
        winner = null;
        addPlayers();
    }

    private void addPlayers() {
        players = new LinkedList<>();

        Player player1 = new Player("Shriniwas",0);
        Player player2 = new Player("Rahul",0);
        players.add(player1);
        players.add(player2);
    }

    public void startGame() {
        while(winner == null) {

            //check whose turn now
            Player playerTurn = findPlayerTurn();
            System.out.println("player turn is: " + playerTurn.getName() + " current position is: "+ playerTurn.getCurrentPosition());

            //roll the dice
            int diceNumbers = dice.rollDice();

            //get the new position
            int playerPosition = playerTurn.getCurrentPosition() + diceNumbers;
            playerPosition = jumpCheck(playerPosition);
            playerTurn.currentPosition = playerPosition;

        System.out.println("player turn is: " + playerTurn.getName() + " new position is: "+ playerTurn.getCurrentPosition());
        if(playerPosition >= board.cells.length * board.cells.length - 1) {
            winner = playerTurn;
        }

        }
    }

    private int jumpCheck(int playerPosition) {
        if(playerPosition > board.cells.length*board.cells.length-1) {
            return playerPosition;
        }
        Cell cell = board.getCell(playerPosition);
        if(cell.getJump() != null && playerPosition == cell.getJump().start) {
            String jumpBy = (cell.getJump().start < cell.getJump().end ) ? "Ladder" : "Snake";
            System.out.println("Jump done by: " + jumpBy);
            return cell.getJump().end;
        }
        return playerPosition;
    }

    private Player findPlayerTurn() {
        Player playerTurns =players.removeFirst();
        players.addLast(playerTurns);
        return playerTurns;
    }
}
