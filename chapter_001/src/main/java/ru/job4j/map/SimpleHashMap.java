package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleHashMap<K, V> implements Iterable<Object> {
    private Node<K, V>[] hashTable;
    private int size = 0;
    private int capacity = 16;
    private int modCount;
    private final float LOAD_FACTOR = 0.75f;

    public SimpleHashMap() {
        hashTable = new Node[capacity];
    }

    public boolean insert(K key, V value) {
        checkTable();
        boolean res = checkHash(key);
        if (res) {
            int hash = hash(key);
            Node<K, V> node = new Node<>(hash, key, value);
            int index = getIndex(key);
            hashTable[index] = node;
            size++;
            modCount++;
        }
        return res;
    }

    public V get(K key) {
        V result = null;
        Node<K, V> o = hashTable[getIndex(key)];
        if (o != null) {
            result = o.value;
        }
        return result;
    }

    public boolean delete(K key) {
        if (!checkHash(key)) {
            int index = getIndex(key);
            hashTable[index] = null;
            size--;
            modCount++;
            return true;
        }
        return false;
    }

    private void checkTable() {
        Node<K, V>[] temp;
        if (size > LOAD_FACTOR * capacity) {
            capacity *= 2;
            temp = new Node[capacity];
            for (Node<K, V> n : hashTable) {
                if (n != null) {
                    int hash = hash(n.key);
                    int index = getIndex(n.key);
                    temp[index] = new Node(hash, n.key, n.value);
                }
            }
            hashTable = temp;
        }
    }

    public int getIndex(K key) {
        return hash(key) & (capacity - 1);
    }

    private boolean checkHash(K key) {
        return hashTable[getIndex(key)] == null;
    }

    private static int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public int getSize() {
        return size;
    }

    private class Node<K, V> {
        private int hash;
        private K key;
        private V value;

        public Node(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }

        public V getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "MapCont{" + "hash=" + hash + ", key=" + key + ", value=" + value + '}';
        }
    }

    @Override
    public Iterator<Object> iterator() {
        return new SimpleHashMap.It();
    }

    private class It implements Iterator<K> {
        private int point = 0;
        private int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            if (size == 0) {
                return false;
            }
            for (int i = point; i <= size; i++) {
                if (hashTable[i] != null) {
                    point = i;
                    return true;
                }
            }
            return false;
        }

        @Override
        public K next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            return hashTable[point++].key;
        }
    }
}