package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleHashMap<K, V> implements Iterable<V> {
    private Object[] hashTable;
    private int size = 0;
    private int capacity = 16;
    private int modCount;

    public SimpleHashMap() {
        hashTable = new Object[capacity];
    }

    boolean insert(K key, V value) {
        checkTable();
        boolean res = checkHash(key);
        if (res) {
            int hash = key.hashCode();
            Object o = new MapCont(hash, key, value);
            int index = getIndex(key);
            hashTable[index] = o;
            size++;
            modCount++;
        }
        return res;
    }

    V get(K key) {
        V result = null;
        MapCont o = (MapCont) hashTable[getIndex(key)];
        if (o != null) {
            result = o.getValue();
        }
        return result;
    }

    boolean delete(K key) {
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
        Object[] temp;
        if (size > hashTable.length - 1) {
            capacity *= 2;
            temp = new Object[capacity];
            System.arraycopy(hashTable, 0, temp, 0, size);
            hashTable = temp;
        }
    }

    int getIndex(K key) {
        return key.hashCode() & (hashTable.length - 1);
    }

    boolean checkHash(K key) {
        return hashTable[getIndex(key)] == null;
    }

    public int getSize() {
        return size;
    }

    public int getTableSize() {
        return hashTable.length;
    }

    class MapCont {
        private int hash;
        private K key;
        private V value;

        public MapCont(int hash, K key, V value) {
            this.hash = hash;
            this.key = key;
            this.value = value;
        }

        public V getValue() {
            return value;
        }
    }

    @Override
    public Iterator<V> iterator() {
        return new SimpleHashMap.It();
    }

    private class It implements Iterator<V> {
        private int point = 0;
        private int expectedModCount = modCount;

        @Override
        public boolean hasNext() {
            return point < size;
        }

        @Override
        public V next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            if (expectedModCount != modCount) {
                throw new ConcurrentModificationException();
            }
            return (V) hashTable[point++];
        }
    }
}