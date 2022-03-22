package cn.szz.plane.utils;

import java.util.Random;

public class RandomUtils {

    private static final Random RANDOM = new Random();

    public static int nextInt(final int startInclusive, final int endExclusive) {
        CheckUtils.isTrue(endExclusive >= startInclusive,
                "Start value must be smaller or equal to end value.");
        CheckUtils.isTrue(startInclusive >= 0, "Both range values must be non-negative.");
        if (startInclusive == endExclusive) {
            return startInclusive;
        }
        return startInclusive + RANDOM.nextInt(endExclusive - startInclusive);
    }

    public static int nextInt(int bound) {
        return RANDOM.nextInt(bound);
    }

    public static int nextInt() {
        return nextInt(Integer.MAX_VALUE);
    }

}
