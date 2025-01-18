package LowLevelDesign.DesignSnakeAndLadder;


import java.util.concurrent.ThreadLocalRandom;

public class ObstacleFactory {
    public static void createSnakes(Board board, int numberOfSnakes) {

        while(numberOfSnakes>0) {

            int snakeHead = ThreadLocalRandom.current().nextInt(1,board.getSize()-1);
            int snakeTail = ThreadLocalRandom.current().nextInt(1,board.getSize()-1);

            if(snakeTail >= snakeHead) {
                continue;
            }

            board.addSnake(snakeHead,snakeTail);
            numberOfSnakes--;
        }
    }

    public static void createLadders(Board board, int numberOfLadders) {
        while(numberOfLadders>0) {

            int ladderHead = ThreadLocalRandom.current().nextInt(1,board.getSize()*board.getSize()-1);
            int ladderTail = ThreadLocalRandom.current().nextInt(1,board.getSize()*board.getSize()-1);

            if(ladderHead >= ladderTail) {
                continue;
            }

            board.addSnake(ladderHead,ladderTail);
            numberOfLadders--;
        }
    }
}
