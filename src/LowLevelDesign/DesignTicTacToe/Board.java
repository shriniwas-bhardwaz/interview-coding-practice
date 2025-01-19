package LowLevelDesign.DesignTicTacToe;

import java.util.ArrayList;
import java.util.List;

/* We will use the Observer pattern to notify players of the game state changes. */
public class Board {
    private char[][] board;
    private List<Player> observers = new ArrayList<>();

    public Board(int size) {
        board = new char[size][size];
    }

    public void addObserver(Player player) {
        observers.add(player);
    }


    public void updateBoard(int x, int y, char symbol,Player player) {
        board[x][y] = symbol;
        notifyObservers(player);
    }

    public void notifyObservers(Player playerTurn) {
        for (Player player : observers) {
            if(player != playerTurn) player.update(this,player);
        }
    }

    public char getCell(int x, int y) {
        return board[x][y];
    }

    public int getSize() {
        return board.length;
    }
}
