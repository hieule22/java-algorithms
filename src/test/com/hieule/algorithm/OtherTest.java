package test.com.hieule.algorithm;

import org.junit.Test;

import java.util.Arrays;

import static com.hieule.algorithm.Other.lexicographicalCompare;
import static java.util.Collections.emptyList;
import static java.util.Collections.singletonList;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

/**
 * @author Hieu Le
 * @version 3/22/18
 */

public class OtherTest {
    @Test
    public void lexicographicalCompareTest() throws Exception {
        assertTrue(lexicographicalCompare(singletonList(1), singletonList(2)));
        assertTrue(lexicographicalCompare(Arrays.asList(1, 2), Arrays.asList(1, 3)));
        assertTrue(lexicographicalCompare(Arrays.asList(1, 2), Arrays.asList(1, 2, 3)));
        assertTrue(lexicographicalCompare(emptyList(), singletonList(1)));

        assertFalse(lexicographicalCompare(singletonList(2), singletonList(1)));
        assertFalse(lexicographicalCompare(Arrays.asList(1, 3), Arrays.asList(1, 2)));
        assertFalse(lexicographicalCompare(singletonList(1), singletonList(1)));
        assertFalse(lexicographicalCompare(singletonList(1), emptyList()));
        assertFalse(lexicographicalCompare(emptyList(), emptyList()));

        assertTrue(lexicographicalCompare(new String[]{"1"}, new String[] {"2"}));
    }
}
