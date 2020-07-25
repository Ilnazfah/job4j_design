package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] container;
    private int modCount = 0;
    private int capacity = 10;
    private int count = 0;

    public SimpleArray() {
        container = new Object[capacity];
    }

    public SimpleArray(int capacity) {
        this.capacity = capacity;
        container = new Object[this.capacity];
    }

    public T get(int index) {
        Objects.checkIndex(index, count);
        return (T) container[index];
    }

    public void add(T model) {
        Object[] temp = null;
        if (count > container.length - 1) {
            capacity *= 2;
            temp = new Object[capacity];
            System.arraycopy(container, 0, temp, 0, count);
            container = temp;
            container[count++] = model;
            modCount++;
        } else {
            container[count++] = model;
        }
        modCount++;
    }

    @Override
    public Iterator<T> iterator() {
        return new It();
    }

    private class It implements Iterator<T> {
        private int point = 0;
        private int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            return point < count;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            return (T) container[point++];
        }
    }

    public static void main(String[] args) {
        SimpleArray<Integer> simpleArray = new SimpleArray<>(11);
        System.out.println(simpleArray.capacity);
        simpleArray.add(0);
        simpleArray.add(1);
        simpleArray.add(2);
        simpleArray.add(3);
        simpleArray.add(4);
        simpleArray.add(5);
        simpleArray.add(6);
        simpleArray.add(7);
        simpleArray.add(8);
        simpleArray.add(9);
        simpleArray.add(11);
        simpleArray.add(12);
        simpleArray.add(13);
        simpleArray.add(14);
        simpleArray.add(15);
        simpleArray.add(16);
        simpleArray.add(17);
        simpleArray.add(18);
        simpleArray.add(19);
        simpleArray.add(20);

        for (int i : simpleArray) {
            System.out.println(i);
        }
    }
}