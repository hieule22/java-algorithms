package com.hieule.iterator;

/**
 * A C++ inspired iterator that points at elements of an iterable container
 * @author Hieu Le
 * @version 3/22/18
 */
public abstract class Iterator<T> implements Comparable<Iterator<T>> {
    public abstract Iterator<T> increment();
    public abstract Iterator<T> decrement();
    public abstract T access();
    public abstract void set(T value);

    @Override
    public boolean equals(Object other) {
        return this == other ||
                this.getClass().isInstance(other) && this.compareTo((Iterator<T>) other) == 0;
    }
}