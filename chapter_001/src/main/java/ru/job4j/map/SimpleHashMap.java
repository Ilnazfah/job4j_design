package ru.job4j.map;

import java.util.Iterator;

public class SimpleHashMap<K, V> implements Iterable<V> {
    private Object[] hashTable;
    private int size = 0;
    private int capacity = 16;

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
        }
        return res;
    }

    V get(K key) {
        V result = null;
        MapCont o = (MapCont) hashTable[getIndex(key)];
        try {
            result = o.getValue();
        } catch (NullPointerException ignored) { }
        return result;
    }

    boolean delete(K key) {
        if (!checkHash(key)) {
            int index = getIndex(key);
            hashTable[index] = null;
            size--;
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

        public V getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        SimpleHashMap<String, String> simpleHashMap = new SimpleHashMap<>();
        simpleHashMap.insert("Coffee", "Coffee");
        System.out.println(simpleHashMap.insert("Tea", "Tea"));
        System.out.println("Size " + simpleHashMap.getSize());

        System.out.println(simpleHashMap.get("Coffee"));
        System.out.println(simpleHashMap.get("Tea"));
        System.out.println(simpleHashMap.delete("Tea"));
        System.out.println("Size " + simpleHashMap.getSize());
        System.out.println(simpleHashMap.get("Tea"));
    }
}