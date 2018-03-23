package com.hieule.iterator;

/**
 * This interface defines an object that could be iterated on.
 * @author Hieu Le
 * @version 3/22/18
 */
public interface Iterable<T> {
    // Returns an iterator pointing to the beginning
    Iterator<T> begin();
    // Returns an iterator pointing to the end
    Iterator<T> end();
    // Returns an iterator pointing to the reverse beginning
    Iterator<T> reverseBegin();
    // Returns an iterator pointing to the reverse end
    Iterator<T> reverseEnd();
}
