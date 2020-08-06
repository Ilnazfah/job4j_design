package ru.job4j.collection;

import java.util.Iterator;

public class SimpleStack<T> {
    private ForwardLinked<T> linked = new ForwardLinked<T>();

    public T pop() {
        linked.deleteFirst();
        return null;
    }

    public void push(T value) {
        linked.add(value);
    }

    public static void main(String[] args) {
        SimpleStack<Integer> simpleStack = new SimpleStack<>();
        simpleStack.push(1);
        simpleStack.push(2);
        System.out.println(simpleStack.pop());
        System.out.println(simpleStack.pop());

//        ForwardLinked<Integer> linked = new ForwardLinked<>();
//        linked.add(1);
//        linked.add(2);
//        System.out.println(linked.deleteFirst());
    }
}