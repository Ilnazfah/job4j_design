package ru.job4j.collection;

import java.util.*;

public class SimpleLinkedList<E> implements Iterable<E> {
    private int size = 0;
    private int modCount = 0;
    private Node<E> first;
    private Node<E> last;

    public void add(E value) {
        Node<E> last = this.last;
        Node<E> node = new Node<>(value, last, null);
        this.last = node;
        if (last == null) {
            this.first = node;
        } else {
            last.next = node;
        }
        size++;
        modCount++;
    }

    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> n;
        if (index < (size / 2)) {
            n = first;
            for (int i = 0; i < index; i++) {
                n = n.next;
            }
        } else {
            n = last;
            for (int i = size - 1; i > index; i--) {
                n = n.next;
            }
        }
        return n.node;
    }

    @Override
    public Iterator<E> iterator() {
        return new It();
    }

    private class It implements Iterator<E> {
        private Node<E> node = first;
        private int expectedModCount = 0;

        {
            expectedModCount = modCount;
        }

        @Override
        public boolean hasNext() {
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            return node != null;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            E value = node.node;
            node = node.next;
            return value;
        }
    }

    private static class Node<T> {
        private T node;
        private Node<T> prev;
        private Node<T> next;

        public Node(T node, Node<T> prev, Node<T> next) {
            this.node = node;
            this.prev = prev;
            this.next = next;
        }
    }
}