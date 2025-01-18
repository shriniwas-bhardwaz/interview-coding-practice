package LowLevelDesign.DesignSnakeAndLadder;

import java.util.concurrent.ThreadLocalRandom;


/* Use ThreadLocalRandom for better performance in multithreaded environments */

public class NormalDice implements DiceStrategy {

    private static final ThreadLocalRandom random  = ThreadLocalRandom.current();

    @Override
    public int rollDice() {
        return random.nextInt(1,7);
    }
}
