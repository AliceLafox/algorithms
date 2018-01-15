package net.lafox.demo.algorithms;


import java.util.ArrayList;
import java.util.List;

import net.lafox.demo.algorithms.validator.ArrayValidator;

public class BestShuffle {
    private static final int ARRAY_SIZE = 4;

    /**
     * Calculate the maximum diff of the differences of four elements.
     * <p>
     * For example, the diff of differences of the array [1, 2, 4, 8] is 7 (difference [0, 1] = 1, [1, 2] = 2 and [2, 3] = 4),
     * but when re-ordered to [2, 4, 1, 8] it is 12 (difference [0, 1] = 2, [1, 2] = 3 and [2, 3] = 7);
     *
     * @param array of length 4 with values in with range [-1000000, 1000000]
     * @return the maximum value of the differences for any ordering of the given values
     */
    public int calculateBestShuffle(int[] array) {
        ArrayValidator.validateSize(array, ARRAY_SIZE);
        ArrayValidator.validateValues(array);

        return permute(array).stream().map(this::getDiffSum).max(Integer::compareTo).get();
    }

    private int getDiffSum(List<Integer> list) {
        int res = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            res += Math.abs(list.get(i) - list.get(i + 1));
        }
        return res;
    }

    private List<List<Integer>> permute(int[] numbers) {
        List<List<Integer>> permutations = new ArrayList<>();
        permutations.add(new ArrayList<>());

        for (int number : numbers) {
            permutations = calcPermutations(number, permutations);
        }
        return permutations;
    }

    private List<List<Integer>> calcPermutations(int number, List<List<Integer>> permutations) {
        List<List<Integer>> current = new ArrayList<>();
        for (List<Integer> permutation : permutations) {
            for (int j = 0, n = permutation.size() + 1; j < n; j++) {
                List<Integer> temp = new ArrayList<>(permutation);
                temp.add(j, number);
                current.add(temp);
            }
        }
        return new ArrayList<>(current);
    }
}
