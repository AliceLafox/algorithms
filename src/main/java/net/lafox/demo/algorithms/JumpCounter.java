package net.lafox.demo.algorithms;

import net.lafox.demo.algorithms.validator.ArrayValidator;

public class JumpCounter {
    public static final int MAX_SIZE = 10_000;
    private static final int MIN_SIZE = 1;

    /**
     * Counts the number of jumps needed to get from the first index in the array to the given index.
     * A jump is made by adding the value in the array for the current index, to the current index.
     * <p>
     * For example, given the array [1, 1, 1] and the index 2, there are two jumps:<ul>
     * <li>Start as 0
     * <li>Jump to index 1 (0 plus the value at index 0)
     * <li>Jump to index 2 (1 plus the value at index 1)
     * </ol>
     * <br><br>
     *
     * @param array       of length with range [1, 10000], with values in with range [-1000000, 1000000]
     * @param jumpToIndex to reach by making jumps
     * @return the number of jump to reach the given index, or -1 if the index is never reached.
     */
    public int countJumpsToIndex(int[] array, int jumpToIndex) {
        ArrayValidator.validateSize(array, MIN_SIZE, MAX_SIZE);
        ArrayValidator.validateValues(array);

        for (int i = 0, result = 0; i < array.length && i >= 0; i += array[i], result++) {
            if (i == jumpToIndex) return result;
        }

        return -1;
    }

}
