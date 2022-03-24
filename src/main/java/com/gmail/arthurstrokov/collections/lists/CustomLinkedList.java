package com.gmail.arthurstrokov.collections.lists;

public class CustomLinkedList<T> {

    private class Node<T> {
        T value;
        Node<T> next;

        Node(T value) {
            this.value = value;
            this.next = null;
        }
    }

    private Node<T> head = null;

    public int size() {
        Node<T> p;
        int size = 0;
        for (p = head; p != null; p = p.next) {
            size++;
        }
        return size;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public boolean contains(T o) {
        if (isEmpty()) {
            return false;
        }
        Node<T> p;
        for (p = head; p != null; p = p.next) {
            if (p.value.equals(o)) {
                return true;
            }
        }
        return false;
    }

    public void add(T o) {
        if (isEmpty()) {
            head = new Node<>(o);
        } else {
            Node<T> p = head;
            Node<T> node = new Node<>(o);
            while (p.next != null) {
                p = p.next;
            }
            p.next = node;
            node.next = null;
        }
    }

    public boolean remove(T o) {
        Node<T> p = head;
        Node<T> p1 = null;
        boolean have = false;
        if (isEmpty()) {
            return false;
        }
        while (p != null) {
            if (p.value.equals(o)) {
                if (p1 == null) {
                    head = head.next;
                } else {
                    p1.next = p.next;
                }
                have = true;
            }
            p1 = p;
            p = p.next;
        }
        return have;
    }

    public void clear() {
        head = null;
    }

    public T get(int index) {
        int i = -1;
        if (isEmpty()) {
            return null;
        }
        if (index < 0 || index > size()) {
            return null;
        }
        Node<T> p = head;
        while (p != null) {
            i++;
            if (i == index) {
                return p.value;
            }
            p = p.next;
        }
        return null;
    }

    public void add(int index, T element) {
        int i = -1;
        if (isEmpty()) {
            this.add(element);
            return;
        }
        if (index < 0 || index > size()) {
            return;
        }
        Node<T> p = head;
        Node<T> p1 = null;
        while (p != null) {
            i++;
            if (i == index) {
                Node<T> newNode = new Node<>(element);
                if (p1 == null) {
                    newNode.next = head;
                    head = newNode;
                } else {
                    p1.next = newNode;
                    newNode.next = p;
                }
            }
            p1 = p;
            p = p.next;
        }
    }

    public T set(int index, T element) {
        int i = -1;
        if (isEmpty()) {
            add(element);
            return null;
        }
        if (index < 0 || index > size()) {
            return null;
        }
        Node<T> p = head;
        T o = null;
        while (p != null) {
            i++;
            if (i == index) {
                o = p.value;
                p.value = element;
                return o;
            }
            p = p.next;
        }
        return null;
    }

    public T remove(int index) {
        if (isEmpty()) {
            return null;
        }
        if (index < 0 || index > size()) {
            return null;
        }
        Node<T> p = head;
        Node<T> p1 = null;
        int i = -1;
        while (p != null) {
            i++;
            if (i == index) {
                if (p1 == null) {
                    head = head.next;
                } else {
                    p1.next = p.next;
                }
                return p.value;
            }
            p1 = p;
            p = p.next;
        }
        return null;
    }

    public Object[] toArray() {
        if (isEmpty()) {
            return new Object[0];
        }
        int length = size();
        int i = 0;
        Object[] a = new Object[length];
        Node<T> p;
        for (p = head; p != null; p = p.next) {
            a[i] = p.value;
            i++;
        }
        return a;
    }
}
