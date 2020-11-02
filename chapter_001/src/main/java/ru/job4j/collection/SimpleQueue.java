package ru.job4j.collection;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();

    public T poll() {
        while (in != null) {
            out.push(in.pop());
        }
        return null;
    }

    public void push(T value) {
        in.push(value);
    }
}