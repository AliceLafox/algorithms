package net.lafox.demo.algorithms;


import static net.lafox.demo.algorithms.validator.ArrayValidator.RANGE_MAX;
import static net.lafox.demo.algorithms.validator.ArrayValidator.validateSize;
import static net.lafox.demo.algorithms.validator.ArrayValidator.validateValues;

public class ChainBreaker {
    public static final int MIN_SIZE = 5;
    public static final int MAX_SIZE = 10_000;

    /**
     * Break a chain of links in three chain where the value of the broken links is minimal.
     * A chain is made of one or more links which have a strength value.
     * <p>
     * For example, the array [1, 2, 3, 4, 5, 6] represents a chain of links.
     * This chain can be broken into three links in several ways:<ul>
     * <li>[1], [3], [5, 6] (value of broken links = 2 + 4 = 6)
     * <li>[1], [3, 4], [6] (value of broken links = 2 + 5 = 7)
     * <li>[1, 2], [4], [6] (value of broken links = 3 + 5 = 8)
     * </ul>
     *
     * @param array of length with range [5, 10000], with values in with range [-1000000, 1000000]
     * @return the minimum value of broken links which break the chain in to three separate chains.
     */
    public int calculateMinimumBreakValue(int[] array) {
        validateSize(array, MIN_SIZE, MAX_SIZE);
        validateValues(array);

        int min = RANGE_MAX;

        for (int i = 1; i < array.length - 3; i++) {
            for (int j = i + 2; j < array.length; j++) {
                min = Math.min(array[i] + array[j], min);
            }
        }
        return min;
    }
}
