package ru.job4j.collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.ConcurrentModificationException;
import java.util.Objects;
public class SimpleArrayList<T> implements SimpleList<T> {
    private T[] container;
    private int size;
    private int modCount;
    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

        private void grow() {
            if (size == 0) {
                container = Arrays.copyOf(container, 10);
            } else {
                container = Arrays.copyOf(container, container.length * 2);
            }
        }
        @Override
        public void add(T value) {
            if (size >= container.length) {
                grow();
            }
            container[size++] = value;
            modCount++;
        }
        @Override
        public T set(int index, T newValue) {
            T lastValue = get(index);
            container[index] = newValue;
            return lastValue;
        }

        @Override
        public T remove(int index) {
            Objects.checkIndex(index, container.length);
            T removeValue = get(index);
            System.arraycopy(
                    container,
                    index + 1,
                    container,
                    index,
                    container.length - index - 1
            );
            container[container.length - 1] = null;
            modCount++;
            size--;
            return removeValue;
        }
        @Override
        public T get(int index) {
            Objects.checkIndex(index, size);
            if (index < 0 || index >= container.length) {
                throw new IndexOutOfBoundsException();
            }
            return container[index];
        }

        @Override
        public int size() {
            return size;
        }
        @Override
        public Iterator<T> iterator() {
            return new Iterator<T>() {
                int value = 0;
                final int expectedModCount = modCount;
                @Override
                public boolean hasNext() {
                    if (expectedModCount != modCount) {
                        throw new ConcurrentModificationException();
                    }
                    return value < size;
                }
                @Override
                public T next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    return container[value++];
                }
            };
        }
    }