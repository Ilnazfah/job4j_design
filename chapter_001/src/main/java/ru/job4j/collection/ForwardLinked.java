package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node<T> head;
    private int size = 0;

    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        size++;
        tail.next = node;
    }

    public void revert() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        ForwardLinked<T> tempList = new ForwardLinked<>();
        while (head != null) {
            tempList.add(deleteLast());
        }
        head = tempList.head;
    }

    public void deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        head = head.next;
        size--;
    }

    public T deleteLast() {
        T elem;
        Node<T> tail;
        if (head == null) {
            throw new NoSuchElementException();
        }
        if (head.next == null) {
            elem = head.value;
            head = null;
        } else {
            tail = head;
            while (tail.next.next != null) {
                tail = tail.next;
            }
            elem = tail.next.value;
            tail.next = null;
        }
        size--;
        return elem;
    }

    public int getSize() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }
    }
}