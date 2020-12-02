package ru.job4j.set;

import ru.job4j.collection.SimpleArray;

import java.util.Iterator;

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

    public static void main(String[] args) {
        SimpleSet<String> simpleSet = new SimpleSet<>();
        simpleSet.add("one");
        simpleSet.add("one");
        simpleSet.add("two");
    }

    @Override
    public Iterator<E> iterator() {
        int point = 0;
        return new Iterator<E>() {
            @Override
            public boolean hasNext() {
                return point < size;
            }

            @Override
            public E next() {
                return null;
            }
        };
    }
}