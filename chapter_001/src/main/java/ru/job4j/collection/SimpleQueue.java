package ru.job4j.collection;

import java.util.Queue;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int size = 0;

    public T poll() {
        T temp = out.pop();
        for (int i = 0; i < size; i++) {
            in.push(out.pop());
        }
        size--;
        return temp;
    }

//    public T poll() {
//        T temp;
//        for (int i = 0; i < size; i++) {
//            out.push(in.pop());
//        }
//        temp = out.pop();
//        for (int i = 0; i < size - 1; i++) {
//            in.push(out.pop());
//        }
//        size--;
//        return temp;
//    }

    public void push(T value) {
        in.push(value);
        size++;
    }

    public int size() {
        return size;
    }
}