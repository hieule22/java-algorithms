package test.com.hieule.iterator;

import com.hieule.iterator.Iterable;
import com.hieule.iterator.IterableArrayList;
import com.hieule.iterator.Iterator;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Hieu Le
 * @version 3/23/18
 */

public class IterableArrayListTest {
    private ArrayList<Integer> expected;
    private Iterable<Integer> iterable;

    @Before
    public void setUp() {
        expected = new ArrayList<>(Arrays.asList(1, 2, 3));
        iterable = new IterableArrayList<>(expected);
    }

    @Test
    public void forwardIterationTest() throws Exception {
        List<Integer> actual = new ArrayList<>();
        for (Iterator<Integer> iterator = iterable.begin();
             !iterator.equals(iterable.end()); iterator.increment()) {
            actual.add(iterator.access());
        }

        assertEquals(expected, actual);
    }

    @Test
    public void backwardIterationTest() throws Exception {
        List<Integer> actual = new ArrayList<>();
        for (Iterator<Integer> iterator = iterable.reverseBegin();
                !iterator.equals(iterable.reverseEnd()); iterator.increment()) {
            actual.add(iterator.access());
        }

        Collections.reverse(actual);
        assertEquals(expected, actual);
    }

    @Test
    public void copyTest() {
        ArrayList<Integer> actual = new ArrayList<>(Collections.nCopies(expected.size(), 0));
        Iterable<Integer> iterableActual = new IterableArrayList<>(actual);
        Iterator<Integer> actualIterator = iterableActual.begin();
        Iterator<Integer> expectedIterator = iterable.begin();

        while (!actualIterator.equals(iterableActual.end())) {
            actualIterator.set(expectedIterator.access());
            actualIterator.increment();
            expectedIterator.increment();
        }

        assertEquals(expected, actual);
    }
}
