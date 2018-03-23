package com.hieule.algorithm;

import java.util.Iterator;

/**
 * @author Hieu Le
 * @version 3/22/18
 */
public class Other {

    private Other() { /* Hides the constructor */ }

    /**
     * Returns true if an iterable sequence a compares lexicographically less than an iterable
     * sequence b.
     *
     * A lexicographic comparison is the kind of comparison generally used to sort words
     * alphabetically in dictionaries. It involves comparing sequentially the elements that have
     * the same position in both lists against each other until one element is not equivalent
     * to the other. The result of comparing the first non-matching elements is the result
     * of the lexicographical comparison.
     *
     * If both sequences compare equal until one of them ends, the shorter sequence is
     * lexicographically less than the longer one.
     */
    public static <T> boolean lexicographicalCompare(
            Iterable<? extends Comparable<? super T>> a, Iterable<? extends T> b) {
        Iterator<? extends Comparable<? super T>> aIterator = a.iterator();
        Iterator<? extends T> bIterator = b.iterator();

        while (aIterator.hasNext() && bIterator.hasNext()) {
            int compResult = aIterator.next().compareTo(bIterator.next());
            if (compResult != 0)
                return compResult < 0;
        }

        return !aIterator.hasNext() && bIterator.hasNext();
    }

    public static <T> boolean lexicographicalCompare(Comparable<? super T>[] a, T[] b) {
        int aIndex = 0;
        int bIndex = 0;
        while (aIndex < a.length && bIndex < b.length) {
            int compResult = a[aIndex++].compareTo(b[bIndex++]);
            if (compResult != 0)
                return compResult < 0;
        }

        return aIndex == a.length && bIndex < b.length;
    }
}
