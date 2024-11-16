package util;

import java.util.Random;

public class RandomUtil {

    private final Random randomGenerator = new Random();

    public int getRandomNumber(int bound) {
        return randomGenerator.nextInt(bound);
    }


}
