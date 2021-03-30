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

    public boolean insert(K key, V value) {
        checkTable();
        boolean res = checkHash(key);
        if (res) {
            int hash = hash(key);
            Object o = new MapCont(hash, key, value);
            int index = getIndex(key);
            hashTable[index] = o;
            size++;
            modCount++;
        }
        return res;
    }

    public V get(K key) {
        V result = null;
        MapCont o = (MapCont) hashTable[getIndex(key)];
        if (o != null) {
            result = o.getValue();
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
        Object[] temp;
        if (size > hashTable.length - 1) {
            capacity *= 2;
            temp = new Object[capacity];
            for (int i = 0; i < hashTable.length; i++) {
                MapCont o = (MapCont) hashTable[i];
                int hash = hash(o.key);
                K key = o.key;
                V value = o.value;
                int index = getIndex(key);
                Object newObject = new MapCont(hash, key, value);
                temp[index] = newObject;
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

    private class MapCont {
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

        @Override
        public String toString() {
            return "MapCont{" + "hash=" + hash + ", key=" + key + ", value=" + value + '}';
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