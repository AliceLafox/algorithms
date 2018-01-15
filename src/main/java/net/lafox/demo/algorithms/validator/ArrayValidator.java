package net.lafox.demo.algorithms.validator;

public class ArrayValidator {
    public final static int RANGE_MIN = -1_000_000;
    public final static int RANGE_MAX = 1_000_000;
    public final static String ARRAY_SIZE_EXCEEDS_LIMIT_RANGE = "Array size exceeds limit range";
    public final static String ARRAY_HAS_WRONG_SIZE = "Array has wrong size. Expected size is";
    public final static String VALUE_IS_OUT_OF_RANGE = "Value is out of range";


    public static void validateValues(int[] array) {
        for (int i : array) {
            if (i > RANGE_MAX || i < RANGE_MIN) {
                throw new RuntimeException(VALUE_IS_OUT_OF_RANGE + " [" + RANGE_MIN + ", " + RANGE_MAX + "]");
            }
        }
    }

    public static void validateSize(int[] array, int size) {
        if (array == null || array.length != size) {
            throw new RuntimeException(ARRAY_HAS_WRONG_SIZE + " [" + size + "]");
        }
    }

    public static void validateSize(int[] array, int minSize, int maxSize) {
        if (array == null || array.length > maxSize || array.length < minSize) {
            throw new RuntimeException(ARRAY_SIZE_EXCEEDS_LIMIT_RANGE + " [" + minSize + ", " + maxSize + "]");
        }
    }

}
