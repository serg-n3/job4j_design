package ru.job4j.map;

import java.util.*;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        if (count >= capacity * LOAD_FACTOR) {
            expand();
        }

        MapEntry<K, V> newEntry = table[getIndex(key)];
        boolean rsl = newEntry == null;
        if (rsl) {
            MapEntry<K, V> entry = new MapEntry<>(key, value);
            table[getIndex(key)] = entry;
            count++;
            modCount++;
        }
        return rsl;
    }

    private int getIndex(K key) {
        return (key == null) ? 0 : indexFor(hash(key.hashCode()));
    }

    private boolean check(K key) {
        return Objects.nonNull(table[getIndex(key)]) && Objects.hashCode(key)
                == Objects.hashCode(table[getIndex(key)].key) && Objects.equals(table[getIndex(key)].key, key);
    }

    private int hash(int hashCode) {
        return hashCode ^ (hashCode >>> 16);
    }

    private int indexFor(int hash) {
        return hash & (capacity - 1);
    }

    private void expand() {
        MapEntry<K, V>[] old = table;
        capacity *= 2;
        table = new MapEntry[capacity];
        for (MapEntry<K, V> entry : old) {
            if (entry != null) {
                table[getIndex(entry.key)] = entry;
            }
        }
    }

    @Override
    public V get(K key) {
        if (check(key)) {
            return table[getIndex(key)].value;
        }
        return null;
    }

    @Override
    public boolean remove(K key) {
        if (check(key)) {
            table[getIndex(key)] = null;
            count--;
            modCount++;
            return true;
            }
        return false;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<K>() {
            private final int expectedModCount = modCount;
            private int point = 0;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                while (point < capacity && table[point] == null) {
                    point++;
                }
                return point < capacity;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return table[point++].key;
            }
        };
    }

    private static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }
}
