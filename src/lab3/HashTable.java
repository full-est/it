package lab3;

import java.util.LinkedList;

public class HashTable<K, V> {
    private LinkedList<Entry<K, V>>[] table;
    private int size;
    private static final int DEFAULT_CAPACITY = 16;

    private static class Entry<K, V> {
        private final K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    public HashTable() {
        this.table = new LinkedList[DEFAULT_CAPACITY];
        this.size = 0;
    }

    private int hash(K key) {
        return key.hashCode() % table.length;
    }

    public void put(K key, V value) {
        int index = hash(key);
        index = Math.abs(index);
        if (table[index] == null) {
            table[index] = new LinkedList<>();
        }

        for (Entry<K, V> entry : table[index]) {
            if (entry.getKey().equals(key)) {
                entry.setValue(value);
                return;
            }
        }

        table[index].add(new Entry<>(key, value));
        size++;
    }

    public V get(K key) {
        int index = hash(key);
        index = Math.abs(index);
        if (table[index] != null) {
            for (Entry<K, V> entry : table[index]) {
                if (entry.getKey().equals(key)) {
                    return entry.getValue();
                }
            }
        }
        return null;
    }

    public void remove(K key) {
        int index = hash(key);
        index = Math.abs(index);
        if (table[index] != null) {
            for (Entry<K, V> entry : table[index]) {
                if (entry.getKey().equals(key)) {
                    table[index].remove(entry);
                    size--;
                    return;
                }
            }
        }
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        for (LinkedList<Entry<K, V>> entry : table) {
            if (entry != null && !entry.isEmpty()) {
                return false;
            }
        }
        return true;
    }


    public void printTable() {
        for (int i = 0; i < table.length; i++) {
            if (table[i] != null) {
                System.out.print("Index " + i + ": ");
                for (Entry<K, V> entry : table[i]) {
                    System.out.print("{" + entry.getKey() + ": " + entry.getValue() + "} ");
                }
                System.out.println();
            }
        }
    }
}
