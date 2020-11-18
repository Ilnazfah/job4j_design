package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SimpleStack<T> {
    private ForwardLinked<T> linked = new ForwardLinked<T>();
    private int size = 0;

    public T pop() {
        return linked.deleteLast();
    }

    public void push(T value) {
        linked.add(value);
        size++;
    }

    public int size() {
        return size;
    }
}