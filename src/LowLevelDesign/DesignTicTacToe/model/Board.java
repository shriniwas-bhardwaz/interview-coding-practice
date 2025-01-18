package LowLevelDesign.DesignTicTacToe.model;


import LowLevelDesign.DesignTicTacToe.Pair;

import java.util.ArrayList;
import java.util.List;

public class Board {

   private int size;
   private PlayingPiece[][] board;

   public Board(int size) {
       this.size = size;
       this.board = new PlayingPiece[size][size];
   }

   public int getSize() {
       return this.size;
   }

   public PlayingPiece[][] getBoard() {
       return this.board;
    }

    public List<Pair<Integer, Integer>> getFreeCells() {
       List<Pair<Integer, Integer>> freeCells = new ArrayList<>();

       for(int i = 0; i < size; i++) {
           for(int j = 0; j < size; j++) {
               if(board[i][j] == null) {
                   Pair<Integer,Integer> rowColumn = new Pair(i, j);
                   freeCells.add(rowColumn);
               }
           }
       }

       return freeCells;
    }


    public void printBoard() {

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] != null) {
                    System.out.print(board[i][j].pieceType.name() + "   ");
                } else {
                    System.out.print("    ");

                }
                System.out.print(" | ");
            }
            System.out.println();

        }
    }




}
