package ru.job4j.collection;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int size = 0;

    public T poll() {
        size--;
        for (int i = 0; i < in.size(); i++) {
            out.push(in.pop());
        }
        return out.pop();
    }

    public void push(T value) {
        in.push(value);
        size++;
    }

    public int size() {
        return size;
    }

    public static void main(String[] args) {
        SimpleQueue<String> s = new SimpleQueue<>();
        s.push("1");
        s.push("2");
        s.push("3");
        System.out.println(s.size);
    }
}