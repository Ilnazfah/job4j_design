package ru.job4j.generic;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable {
    private T[] model;
    private int count;

    public SimpleArray(int capacity) {
        this.model = (T[]) new Object[capacity];
    }

    public void add(T model) {
        this.model[count++] = model;
    }

    public void set(int index, T model) {
        Objects.checkIndex(index, count);
        this.model[index] = model;
    }

    public void remove(int index) {
        Objects.checkIndex(index, count);
        int count = 0;
        for (int i = 0; i < this.model.length; i++) {
            if (i == index) {
                continue;
            }
            this.model[count] = this.model[i];
            count++;
        }
    }

    public T get(int index) {
        Objects.checkIndex(index, count);
        return this.model[index];
    }

    public static void main(String[] args) {
        SimpleArray<Integer> arr = new SimpleArray<>(10);

        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(4);
        arr.add(5);
        arr.set(0, 2352);
        arr.remove(1);
        arr.remove(11);
        arr.set(11, 7);

        for (Object i : arr) {
            System.out.println(i);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new It();
    }

    private class It implements Iterator<T> {
        private int point = 0;

        @Override
        public boolean hasNext() {
            return model[point] != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return model[point++];
        }
    }
}