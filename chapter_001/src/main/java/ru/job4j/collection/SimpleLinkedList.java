package ru.job4j.collection;

import java.util.*;

public class SimpleLinkedList<E> implements Iterable<E> {
    private int modCount = 0;
    private int size = 0;
    private Node<E> first;
    private Node<E> last;

    public void add(E value) {
        if (first == null) {
            last = new Node<>(first, value, null);
        }
        //first = new Node<>();
        size++;
        modCount++;
    }

    public E get(int index) {
        Objects.checkIndex(index, size);
        return null;
    }

    public int size() {
        return this.size;
    }

    private class Node<E> {
        private E currEl;
        private Node<E> nextEl;
        private Node<E> lastEl;

        public Node(Node<E> lastEl, E currEl, Node<E> nextEl) {
            this.currEl = currEl;
            this.nextEl = nextEl;
            this.lastEl = lastEl;
        }
    }

    public class It implements Iterator<E> {
        private int point = 0;
        private int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            return false;
        }

        @Override
        public E next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            return null;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new It();
    }
}