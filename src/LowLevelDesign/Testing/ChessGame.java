package LowLevelDesign.Testing;

import java.util.*;

enum Color {
    WHITE, BLACK
}

// Position class to represent a square on the board
class Position {
    int row;
    int column;

    Position(int row, int column) {
        this.row = row;
        this.column = column;
    }

    boolean isValid() {
        return row >= 0 && row < 8 && column >= 0 && column < 8;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Position position = (Position) obj;
        return row == position.row && column == position.column;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, column);
    }
}

// Abstract class for all pieces
abstract class Piece {
    Color color;
    Position position;

    Piece(Color color, Position position) {
        this.color = color;
        this.position = position;
    }

    abstract boolean isValidMove(Position start, Position end, ChessBoard board);

    boolean isSameColor(Piece other) {
        return this.color == other.color;
    }
}

// Individual Piece Classes
class Pawn extends Piece {
    Pawn(Color color, Position position) {
        super(color, position);
    }

    @Override
    boolean isValidMove(Position start, Position end, ChessBoard board) {
        int direction = color == Color.WHITE ? -1 : 1;
        if (end.column == start.column && end.row == start.row + direction && !board.isOccupied(end)) {
            return true;
        }
        if (Math.abs(end.column - start.column) == 1 && end.row == start.row + direction && board.isOccupiedByOpponent(end, this)) {
            return true;
        }
        return false;
    }
}

class Rook extends Piece {
    Rook(Color color, Position position) {
        super(color, position);
    }

    @Override
    boolean isValidMove(Position start, Position end, ChessBoard board) {
        if (start.row == end.row || start.column == end.column) {
            return board.isPathClear(start, end);
        }
        return false;
    }
}

// Additional piece classes like Knight, Bishop, Queen, King can be added similarly

// Square class represents a single square on the chessboard
class Square {
    Position position;
    Piece piece;

    Square(Position position) {
        this.position = position;
    }

    boolean isOccupied() {
        return piece != null;
    }
}

// ChessBoard class
class ChessBoard {
    Square[][] board = new Square[8][8];

    ChessBoard() {
        initializeBoard();
    }

    void initializeBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new Square(new Position(i, j));
            }
        }
        // Place pawns
        for (int i = 0; i < 8; i++) {
            board[1][i].piece = new Pawn(Color.BLACK, new Position(1, i));
            board[6][i].piece = new Pawn(Color.WHITE, new Position(6, i));
        }
        // Place rooks
        board[0][0].piece = new Rook(Color.BLACK, new Position(0, 0));
        board[0][7].piece = new Rook(Color.BLACK, new Position(0, 7));
        board[7][0].piece = new Rook(Color.WHITE, new Position(7, 0));
        board[7][7].piece = new Rook(Color.WHITE, new Position(7, 7));

        // Add other pieces like Knight, Bishop, Queen, King
    }

    boolean isOccupied(Position pos) {
        return board[pos.row][pos.column].isOccupied();
    }

    boolean isOccupiedByOpponent(Position pos, Piece piece) {
        return isOccupied(pos) && !board[pos.row][pos.column].piece.isSameColor(piece);
    }

    boolean isPathClear(Position start, Position end) {
        if (start.row == end.row) { // Horizontal movement
            int step = start.column < end.column ? 1 : -1;
            for (int i = start.column + step; i != end.column; i += step) {
                if (isOccupied(new Position(start.row, i))) return false;
            }
        } else if (start.column == end.column) { // Vertical movement
            int step = start.row < end.row ? 1 : -1;
            for (int i = start.row + step; i != end.row; i += step) {
                if (isOccupied(new Position(i, start.column))) return false;
            }
        }
        return true;
    }

    boolean movePiece(Position start, Position end) {
        if (!start.isValid() || !end.isValid()) return false;

        Piece piece = board[start.row][start.column].piece;
        if (piece == null || !piece.isValidMove(start, end, this)) {
            return false;
        }

        board[end.row][end.column].piece = piece;
        board[start.row][start.column].piece = null;
        piece.position = end;
        return true;
    }

    void displayBoard() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j].piece == null) {
                    System.out.print("- ");
                } else {
                    System.out.print(board[i][j].piece.getClass().getSimpleName().charAt(0) + " ");
                }
            }
            System.out.println();
        }
    }
}

// Player class
class Player {
    String name;
    Color color;

    Player(String name, Color color) {
        this.name = name;
        this.color = color;
    }
}

// Game class
class Game {
    ChessBoard chessBoard;
    Player player1;
    Player player2;
    Color currentTurn;

    Game(Player player1, Player player2) {
        this.chessBoard = new ChessBoard();
        this.player1 = player1;
        this.player2 = player2;
        this.currentTurn = Color.WHITE;
    }

    void startGame() {
        chessBoard.displayBoard();
        System.out.println("Game Started!");
    }

    void switchTurn() {
        currentTurn = (currentTurn == Color.WHITE) ? Color.BLACK : Color.WHITE;
    }

    void makeMove(Position start, Position end) {
        if (chessBoard.movePiece(start, end)) {
            System.out.println("Move successful!");
            switchTurn();
            chessBoard.displayBoard();
        } else {
            System.out.println("Invalid move!");
        }
    }
}

// Main Class to Run the Game
public class ChessGame {
    public static void main(String[] args) {
        Player player1 = new Player("Alice", Color.WHITE);
        Player player2 = new Player("Bob", Color.BLACK);
        Game game = new Game(player1, player2);

        game.startGame();
        game.makeMove(new Position(6, 0), new Position(5, 0)); // Example move
        game.makeMove(new Position(1, 0), new Position(2, 0)); // Example move
    }
}
