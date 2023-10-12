package fi.iki.jst.cgitest2;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SmallestGapFinderTest {

    @Test
    public void testSmallestGapWithEmptyArray() {
        int[] numbers = new int[0];
        assertThrows(IllegalArgumentException.class, () -> {
            SmallestGapFinder.smallestGap(numbers);
        });
    }

    @Test
    public void testSmallestGapWithSingleNumberArray() {
        int[] numbers = {5};
        assertThrows(IllegalArgumentException.class, () -> {
            SmallestGapFinder.smallestGap(numbers);
        });
    }

    @Test
    public void testSmallestGap() {
        int[] numbers = {1, 5, 9, 15};
        int result = SmallestGapFinder.smallestGap(numbers);
        assertEquals(3, result);
    
    }

    @Test
    public void testSmallestGap2() {
        int[] numbers = {5, 1, 9, 15, 200};
        int result = SmallestGapFinder.smallestGap(numbers);
        assertEquals(3, result);
    }

    @Test
    public void testSmallestGap3() {
        int[] numbers = {100, 1, 6, 15};
        int result = SmallestGapFinder.smallestGap(numbers);
        assertEquals(4, result);
    }

    @Test
    public void testSmallestGapWithEqualNumbers() {
        int[] numbers = {7, 7};
        int result = SmallestGapFinder.smallestGap(numbers);
        assertEquals(0, result);
    }

    @Test
    public void testSmallestGapWithSmallerNumberFirst() {
        int[] numbers = {5, 10};
        int result = SmallestGapFinder.smallestGap(numbers);
        assertEquals(4, result);
    }

    @Test
    public void testSmallestGapWithLargerNumberFirst() {
        int[] numbers = {10, 5};
        int result = SmallestGapFinder.smallestGap(numbers);
        assertEquals(4, result);
    }
}
