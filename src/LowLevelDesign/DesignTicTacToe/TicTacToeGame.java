package LowLevelDesign.DesignTicTacToe;

import LowLevelDesign.DesignTicTacToe.model.*;
import LowLevelDesign.DesignTicTacToe.strategy.BasicMove;
import LowLevelDesign.DesignTicTacToe.strategy.Move;


import java.util.*;

public class TicTacToeGame {

    Deque<Player> players;
    Board gameBoard;
    private Move moveStrategy;

    Map<PieceType,int[]> rowCounter;
    Map<PieceType,int[]> colCounter;
    Map<PieceType,Integer> diagonalCounter;
    Map<PieceType,Integer> antiDiagonalCounter;



    public TicTacToeGame() {
        initializeGame();
        this.moveStrategy = new BasicMove();
    }

    public void initializeGame() {

        //creating 2 players
        players = new LinkedList<>();
        PlayingPiece crossPiece = new PlayingPieceX();
        Player player1 = new Player("Player1",crossPiece);

       PlayingPiece noughtPiece = new PlayingPieceO();
        Player player2 = new Player("Player2",noughtPiece);

        PlayingPiece yPiece = new PlayingPieceY();
        Player player3 = new Player("Player3",yPiece);

        players.add(player1);
        players.add(player2);
        players.add(player3);

        //initialize board
        gameBoard = new Board(4);

        //initialize counters
        rowCounter = new HashMap<>();
        colCounter = new HashMap<>();
        diagonalCounter = new HashMap<>();
        antiDiagonalCounter = new HashMap<>();

        for(Player player : players) {
            rowCounter.put(player.getPlayingPiece().getPieceType(), new int[gameBoard.getSize()]);
            colCounter.put(player.getPlayingPiece().getPieceType(), new int[gameBoard.getSize()]);
            diagonalCounter.put(player.getPlayingPiece().getPieceType(),0);
            antiDiagonalCounter.put(player.getPlayingPiece().getPieceType(),0);
        }

    }

    public String startGame() {

        boolean noWinner = true;

        while(noWinner) {

            // take out the player whose turn is and also put the player in the list back
            Player playerTurn = players.removeFirst();

            // get the free space from board
            gameBoard.printBoard();

            List<Pair<Integer,Integer>> freeSpaces = gameBoard.getFreeCells();
            if(freeSpaces.isEmpty()) {
                noWinner = false;
                continue;
            }

            //read the user input
            System.out.println("Player:" + playerTurn.getName() + " Enter row,column: ");
            Scanner inputScanner = new Scanner(System.in);
            String s = inputScanner.nextLine();
            String[] values = s.split(",");
            int inputRow = Integer.parseInt(values[0]);
            int inputColumn = Integer.parseInt(values[1]);

            // place the Piece
            boolean pieceAddedSuccessfully =  moveStrategy.isValidMove(gameBoard,inputRow,inputColumn);
            if(!pieceAddedSuccessfully) {
                //player cannot insert the piece into this cell, player has to choose another cell

                System.out.println("Incorrect Position, try again");
                players.addFirst(playerTurn);
                continue;
            }

            gameBoard.getBoard()[inputRow][inputColumn] = playerTurn.getPlayingPiece();
            players.addLast(playerTurn);
            boolean winner = isThereWinner(inputRow,inputColumn,playerTurn.getPlayingPiece().getPieceType());
            if(winner) {
                playerTurn.getStatistics().incrementWins();

                players.stream()
                        .filter(p -> !p.equals(playerTurn))
                        .findFirst()
                        .ifPresent(otherPlayer -> otherPlayer.getStatistics().incrementLosses());
                return playerTurn.getName();
            }
        }
        for(Player player : players) {
            player.getStatistics().incrementDraws();
        }
        return "tie";
    }

    public void displayStatistics() {
        for (Player player : players) {
            System.out.println("Player: " + player.getName() +
                    ", Wins: " + player.getStatistics().getWins() +
                    ", Losses: " + player.getStatistics().getLosses() +
                    ", Draws: " + player.getStatistics().getDraws());
        }
    }

    public boolean isThereWinner(int row, int column, PieceType piece) {


        rowCounter.get(piece)[row]++;
        colCounter.get(piece)[column]++;
        if(row == column)
        {  diagonalCounter.put(piece,diagonalCounter.get(piece)+1); }
        if(row + column == gameBoard.getSize()-1)
        { antiDiagonalCounter.put(piece,antiDiagonalCounter.get(piece)+1); }

        int boardSize = gameBoard.getSize();

        return rowCounter.get(piece)[row] == boardSize ||
                colCounter.get(piece)[column] == boardSize ||
                diagonalCounter.get(piece) == boardSize ||
                antiDiagonalCounter.get(piece) == boardSize
                ;

       /* boolean rowMatch = true;
        boolean columnMatch = true;
        boolean diagonalMatch = true;
        boolean antidiagonalMatch = true;

        //need to check in row
        for(int i=0;i<gameBoard.getSize();i++) {
            if(gameBoard.getBoard()[row][i]== null || gameBoard.getBoard()[row][i].getPieceType() != piece) {
                rowMatch = false;
            }
        }

        //need to check in column
        for(int i=0;i<gameBoard.getSize();i++) {
            if(gameBoard.getBoard()[i][column] == null || gameBoard.getBoard()[i][column].getPieceType() != piece) {
                columnMatch = false;
            }
        }

        //need to check diagonals
        for(int i=0,j=0;i<gameBoard.getSize();i++,j++) {
            if(gameBoard.getBoard()[i][j] == null || gameBoard.getBoard()[i][j].getPieceType() != piece) {
                diagonalMatch = false;
            }
        }

        //need to check anti-diagonals
        for(int i=0,j=gameBoard.getSize()-1;i< gameBoard.getSize();i++,j--) {
            if(gameBoard.getBoard()[i][j] == null || gameBoard.getBoard()[i][j].getPieceType() != piece) {
                antidiagonalMatch = false;
            }
        }

        return rowMatch || columnMatch || diagonalMatch || antidiagonalMatch;
        */

    }
}
