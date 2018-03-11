package com.hieule.algorithm;

import java.util.List;

/**
 * Collections of binary search utilities
 * @author Hieu Le
 * @version 3/8/18
 */
public final class BinarySearch {

    /**
     * Returns the index of the first element from list which does not compare less than value.
     */
    public static <T> int lowerBound(List<? extends Comparable<? super T>> list, T value) {
        int low = 0;
        int high = list.size();
        while (low < high) {
            final int mid = low + ((high - low) >> 1);
            if (list.get(mid).compareTo(value) >= 0)
                high = mid;
            else
                low = mid + 1;
        }

        return low;
    }

    /**
     * Returns the index of the first element from list which compares greater than value.
     */
    public static <T> int upperBound(List<? extends Comparable<? super T>> list, T value) {
        int low = 0;
        int high = list.size();
        while (low < high) {
            final int mid = low + ((high - low) >> 1);
            if (list.get(mid).compareTo(value) > 0)
                high = mid;
            else
                low = mid + 1;
        }

        return low;
    }

    /**
     * Returns true if any element from list is equivalent to value, and false otherwise.
     */
    public static <T> boolean binarySearch(List<? extends Comparable<? super T>> list, T value) {
        int index = lowerBound(list, value);
        return index != list.size() && list.get(index).compareTo(value) == 0;
    }
}
