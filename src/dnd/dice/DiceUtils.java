package dnd.dice;

import java.util.Random;

public class DiceUtils {
    private static final Random random = new Random();

    private DiceUtils() {

    }

    public static byte throwDice(int diceSidesCount) {
        return (byte) random.nextInt(1, diceSidesCount + 1);
    }


}
