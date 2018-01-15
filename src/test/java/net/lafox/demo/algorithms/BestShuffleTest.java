package net.lafox.demo.algorithms;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class BestShuffleTest {

    private BestShuffle shuffler;

    @Before
    public void createJumpCounter() {
        shuffler = new BestShuffle();
    }

    @Test
    public void testFourNumbers() {
        //max = 16 when it shuffled like this: { 2, 8, 1, 4 } [0,1]=6, [1,2]=7, [2,3]=3
        assertEquals(16, shuffler.calculateBestShuffle(new int[]{1, 2, 4, 8}));
    }

    @Test
    public void testFourNumbersNegativeValue() {
        assertEquals(20, shuffler.calculateBestShuffle(new int[]{-1, 2, 4, 8}));

    }

    @Test(expected = RuntimeException.class)
    public void testValueOutOfRange() {
        assertEquals(16, shuffler.calculateBestShuffle(new int[]{1, 2, 4, 80_000_000}));
    }

}
