package com.hieule.iterator;

import com.sun.corba.se.impl.io.TypeMismatchException;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * An iterable wrapper for ArrayList
 * @author Hieu Le
 * @version 3/22/18
 */
public class IterableArrayList<T> implements Iterable<T> {
    private final ArrayList<T> list;

    public IterableArrayList(ArrayList<T> list) {
        this.list = list;
    }

    @Override
    public Iterator<T> begin() {
        return new ArrayListIterator(list, 0, true);
    }

    @Override
    public Iterator<T> end() {
        return new ArrayListIterator(list, list.size(), true);
    }

    @Override
    public Iterator<T> reverseBegin() {
        return new ArrayListIterator(list, list.size() - 1, false);
    }

    @Override
    public Iterator<T> reverseEnd() {
        return new ArrayListIterator(list, -1, false);
    }

    private class ArrayListIterator extends Iterator<T> {

        private int position;
        private final boolean isForwardIterator;
        private final ArrayList<T> list;

        private ArrayListIterator(ArrayList<T> list, int initialPosition, boolean isForwardIterator) {
            position = initialPosition;
            this.isForwardIterator = isForwardIterator;
            this.list = list;
        }

        @Override
        public Iterator<T> increment() {
            position += isForwardIterator ? 1 : -1;
            return this;
        }

        @Override
        public Iterator<T> decrement() {
            position += isForwardIterator ? -1 : 1;
            return this;
        }

        @Override
        public T access() throws NoSuchElementException {
            if (position < 0 || position >= list.size()) {
                throw new NoSuchElementException();
            }
            return list.get(position);
        }

        @Override
        public void set(T value) throws NoSuchElementException {
            if (position < 0 || position >= list.size()) {
                throw new NoSuchElementException();
            }
            list.set(position, value);
        }

        @Override
        public int compareTo(Iterator<T> o) {
            if (!o.getClass().isInstance(o))
                throw new TypeMismatchException();
            ArrayListIterator other = (ArrayListIterator) o;
            if (this.list != other.list || this.isForwardIterator != other.isForwardIterator)
                throw new TypeMismatchException();
            return this.isForwardIterator ? Integer.compare(this.position, other.position) :
                    Integer.compare(other.position, this.position);
        }
    }
}
