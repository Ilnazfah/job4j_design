package ru.job4j.collection;

import java.util.Queue;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int size = 0;

    public T poll() {
        if (out.isEmpty()) {
            for (int i = 0; i < size; i++) {
                out.push(in.pop());
            }
        }
        size--;
        return out.pop();
    }

    public void push(T value) {
        in.push(value);
        size++;
    }

    public int size() {
        return size;
    }
}