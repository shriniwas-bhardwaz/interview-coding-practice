package LowLevelDesign.DesignSnakeAndLadder;

import java.util.concurrent.ThreadLocalRandom;

// The Loaded Dice is an example of a biased dice that doesn't generate numbers randomly.
// Instead, it skews the probabilities, typically favoring higher numbers, making it "loaded" to produce certain outcomes more frequently.
public class LoadedDice implements DiceStrategy {

    private static final ThreadLocalRandom random  = ThreadLocalRandom.current();

    @Override
    public int rollDice() {
        return random.nextInt(3) + 4;  // Rolls between 4 and 6
    }
}
