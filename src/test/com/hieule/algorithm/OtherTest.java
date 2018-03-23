package test.com.hieule.algorithm;

import org.junit.Test;

import java.util.Arrays;

import static com.hieule.algorithm.Other.lexicographicalCompare;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * @author Hieu Le
 * @version 3/22/18
 */

public class OtherTest {
    @Test
    public void lexicographicalCompareTest() throws Exception {
        assertTrue(lexicographicalCompare(Arrays.asList(1), Arrays.asList(2)));
        assertTrue(lexicographicalCompare(Arrays.asList(1, 2), Arrays.asList(1, 3)));
        assertTrue(lexicographicalCompare(Arrays.asList(1, 2), Arrays.asList(1, 2, 3)));
        assertTrue(lexicographicalCompare(Arrays.asList(), Arrays.asList(1)));

        assertFalse(lexicographicalCompare(Arrays.asList(2), Arrays.asList(1)));
        assertFalse(lexicographicalCompare(Arrays.asList(1, 3), Arrays.asList(1, 2)));
        assertFalse(lexicographicalCompare(Arrays.asList(1), Arrays.asList(1)));
        assertFalse(lexicographicalCompare(Arrays.asList(1), Arrays.asList()));
        assertFalse(lexicographicalCompare(Arrays.asList(), Arrays.asList()));
    }
}
