package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ForwardLinked<T> implements Iterable<T> {
    private int size = 0;
    private int modCount = 0;
    private Node<T> head;

    public void add(T value) {
        Node<T> node = new Node<>(value, null);
        if (head == null) {
            head = node;
        } else {
            Node<T> last = head;
            while (last.next != null) {
                last = last.next;
            }
            last.next = node;
        }
        modCount++;
        size++;
    }

    public void addFirst(T value) {
        Node<T> firstNode = new Node<>(value, null);
        firstNode.next = head;
        head = firstNode;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        Node<T> last = head;
        for (int i = 0; i < index; i++) {
            last = last.next;
        }
        return last.item;
    }

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        T last = head.item;
        Node<T> newLast = head.next;
        head.item = null;
        head.next = null;
        head = newLast;
        return last;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private final int expectedModCount = modCount;
            private Node<T> last = head;

            @Override
            public boolean hasNext() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }

                return last != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T elem = last.item;
                last = last.next;
                return elem;
            }
        };
    }

    private static class Node<T> {
        private T item;
        private Node<T> next;

        Node(T element, Node<T> next) {
            this.item = element;
            this.next = next;
        }
    }
}