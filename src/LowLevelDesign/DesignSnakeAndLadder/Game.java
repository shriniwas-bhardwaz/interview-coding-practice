package LowLevelDesign.DesignSnakeAndLadder;

import java.util.ArrayList;
import java.util.List;

public class Game {
    private List<Player> players;
    private int currentPlayerIndex;

    public Game() {
        this.players = new ArrayList<>();
        this.currentPlayerIndex = 0;
    }

    public synchronized void addPlayer(Player player) {
        players.add(player);
    }

    public synchronized void notifyPlayers(String message,Player playerTurn) {
        for (Player player : players) {
            if(player != playerTurn) {
                player.update(message);
            }
        }
    }

    public synchronized void playerTurn(Player player, DiceStrategy dice, Board board) {
        while(players.get(currentPlayerIndex) != player) {
            try {
                wait();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        int diceRoll = dice.rollDice();
        Command moveCommand = new MoveCommand(player, diceRoll, board);
        moveCommand.execute();
        notifyPlayers(player.getName() + " rolled a " + diceRoll + " and moved to " + player.getPosition(),player);

        if (player.getPosition() == board.getSize()) {
            notifyPlayers(player.getName() + " wins!",player);
        } else {
            nextTurn();
        }

        notifyAll(); // notify All the players that turn has changed
    }

    public synchronized Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    public synchronized void nextTurn() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }
}