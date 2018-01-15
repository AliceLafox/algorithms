package net.lafox.demo.algorithms;

import static net.lafox.demo.algorithms.validator.ArrayValidator.ARRAY_SIZE_EXCEEDS_LIMIT_RANGE;
import static net.lafox.demo.algorithms.validator.ArrayValidator.VALUE_IS_OUT_OF_RANGE;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class JumpCounterTest {

    @Rule
    public final ExpectedException exception = ExpectedException.none();
    private JumpCounter counter;

    @Before
    public void createJumpCounter() {
        counter = new JumpCounter();
    }

    @Test
    public void testExample() {
        assertEquals(2, counter.countJumpsToIndex(new int[]{1, 1, 1}, 2));
    }

    @Test
    public void testExample2() {
        assertEquals(-1, counter.countJumpsToIndex(new int[]{1, 2, 1}, 2));
    }

    @Test
    public void testExample3() {
        assertEquals(1, counter.countJumpsToIndex(new int[]{2, 1, 1}, 2));
    }

    @Test
    public void testExample4() {
        assertEquals(-1, counter.countJumpsToIndex(new int[]{2, 1, 1}, 1));
    }

    @Test
    public void testExample5() {
        assertEquals(-1, counter.countJumpsToIndex(new int[]{5, 1, 1}, 2));
    }

    @Test
    public void testExample6() {
        assertEquals(-1, counter.countJumpsToIndex(new int[]{-5, 1, 1}, 2));
    }

    @Test
    public void testValueOutOfRange() {
        assertException(VALUE_IS_OUT_OF_RANGE);
        assertEquals(-1, counter.countJumpsToIndex(new int[]{2, 1, 8_000_000}, 1));
    }

    @Test
    public void testArraySize() {
        assertException(ARRAY_SIZE_EXCEEDS_LIMIT_RANGE);
        assertEquals(-1, counter.countJumpsToIndex(new int[JumpCounter.MAX_SIZE + 20], 1));
    }


    @Test
    public void testArrayEmpty() {
        assertException(ARRAY_SIZE_EXCEEDS_LIMIT_RANGE);
        assertEquals(-1, counter.countJumpsToIndex(new int[]{}, 1));
    }

    @Test
    public void testArrayNull() {
        assertException(ARRAY_SIZE_EXCEEDS_LIMIT_RANGE);
        assertEquals(-1, counter.countJumpsToIndex(null, 1));
    }

    private void assertException(String s) {
        exception.expect(RuntimeException.class);
        exception.expectMessage(s);
    }

}
