package test.com.hieule.algorithm;

import com.hieule.algorithm.BinarySearch;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author Hieu Le
 * @version 3/11/18
 */
public class BinarySearchTest {

    private static final List<Integer> emptyIntList = Collections.emptyList();

    @Test
    public void lowerBound() throws Exception {
        final List<Integer> list = Arrays.asList(1, 3, 5, 7);

        for (int i = 0; i < list.size(); ++i)
            assertEquals(BinarySearch.lowerBound(list, list.get(i)), i);

        assertEquals(BinarySearch.lowerBound(list, 0), 0);
        assertEquals(BinarySearch.lowerBound(list, 4), 2);
        assertEquals(BinarySearch.lowerBound(list, 8), 4);
    }

    @Test
    public void lowerBoundSingletonList() throws Exception {
        final int value = 1;
        final List<Integer> list = Collections.singletonList(value);
        assertEquals(BinarySearch.lowerBound(list, value), 0);
        assertEquals(BinarySearch.lowerBound(list, value - 1), 0);
        assertEquals(BinarySearch.lowerBound(list, value + 1), 1);
    }

    @Test
    public void lowerBoundEmptyList() throws Exception {
        assertEquals(BinarySearch.lowerBound(emptyIntList, 1), 0);
    }

    @Test
    public void upperBound() throws Exception {
        final List<Integer> list = Arrays.asList(1, 3, 5, 7);

        for (int i = 0; i < list.size(); ++i)
            assertEquals(BinarySearch.upperBound(list, list.get(i)), i + 1);

        assertEquals(BinarySearch.upperBound(list, 0), 0);
        assertEquals(BinarySearch.upperBound(list, 4), 2);
        assertEquals(BinarySearch.upperBound(list, 8), 4);
    }

    @Test
    public void upperBoundEmptyList() throws Exception {
        assertEquals(BinarySearch.upperBound(emptyIntList, 1), 0);
    }

    @Test
    public void upperBoundSingletonList() throws Exception {
        final int value = 1;
        List<Integer> list = Collections.singletonList(value);
        assertEquals(BinarySearch.upperBound(list, value), 1);
        assertEquals(BinarySearch.upperBound(list, value - 1), 0);
        assertEquals(BinarySearch.upperBound(list, value + 1), 1);
    }

    @Test
    public void binarySearch() throws Exception {
        final List<Integer> list = Arrays.asList(1, 3, 5, 7);
        for (int value : list)
            assertTrue(BinarySearch.binarySearch(list, value));
    }

    @Test
    public void binarySearchSingletonList() throws Exception {
        final List<Integer> list = Collections.singletonList(1);
        assertTrue(BinarySearch.binarySearch(list, list.get(0)));
        assertFalse(BinarySearch.binarySearch(list, list.get(0) + 1));
    }

    @Test
    public void binarySearchEmptyList() throws Exception {
        assertFalse(BinarySearch.binarySearch(emptyIntList, 1));
    }
}
