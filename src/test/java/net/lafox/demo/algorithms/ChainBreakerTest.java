package net.lafox.demo.algorithms;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ChainBreakerTest {

    private ChainBreaker breaker;

    @Before
    public void createChainBreaker() {
        breaker = new ChainBreaker();
    }

    @Test
    public void testExample() {
        assertEquals(6, breaker.calculateMinimumBreakValue(new int[] { 1, 2, 3, 4, 5, 6 }));
    }
}
