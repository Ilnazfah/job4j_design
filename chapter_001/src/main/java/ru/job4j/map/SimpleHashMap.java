package ru.job4j.map;

import java.util.Iterator;

public class SimpleHashMap<K, V> implements Iterable<V> {
    private Object[] hashTable = new Object[16];

    boolean insert(K key, V value) {
        int hash = key.hashCode();
        Object o = new MapCont(hash, key, value);
        int index = getIndex(key);
        hashTable[index] = o;
        return false;
    }

    V get(K key) {
        V result = null;
        //result = hashTable[getIndex(key)].getClass();
        return result;
    }

    boolean delete(K key) {
        return false;
    }

    int getIndex(K key) {
        return key.hashCode() & (hashTable.length - 1);
    }

    @Override
    public Iterator<V> iterator() {
        return null;
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

        public V getValue () {
            return value;
        }
    }
}