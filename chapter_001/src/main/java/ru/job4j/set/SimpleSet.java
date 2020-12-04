package ru.job4j.set;

import ru.job4j.collection.SimpleArray;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleSet<E> implements Iterable<E> {
    private final SimpleArray<E> simpleArray = new SimpleArray<>();
    private int size = 0;

    public void add(E e) {
        if (!checkValue(e)) {
            simpleArray.add(e);
            size++;
        }
    }

    private boolean checkValue(E e) {
        for (E value : simpleArray) {
            if (value.equals(e)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<E> iterator() {
        return new It();
    }

    private class It implements Iterator<E> {
        private int point = 0;

        @Override
        public boolean hasNext() {
            return point < size;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return simpleArray.get(point++);
        }
    }
}