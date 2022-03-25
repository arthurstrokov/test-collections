package com.gmail.arthurstrokov.collections.lists;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class CustomLinkedListTest {

    CustomLinkedList<String> linkedList;

    @BeforeEach
    void init() {
        linkedList = new CustomLinkedList<>();
        linkedList.add("Linked");
    }

    @Test
    void size() {
        assertEquals(1, linkedList.size());
        linkedList.add("Hello");
        assertEquals(2, linkedList.size());
    }

    @Test
    void isEmpty() {
        assertFalse(linkedList.isEmpty());
    }

    @Test
    void contains() {
        linkedList.add("contains");
        assertTrue(linkedList.contains("contains"));
        assertFalse(linkedList.contains("assertFalse"));
    }

    @Test
    void add() {
        linkedList.add("add");
        assertTrue(linkedList.contains("add"));
    }

    @Test
    void remove() {
        linkedList.add("remove");
        assertTrue(linkedList.remove("remove"));
        assertFalse(linkedList.remove("remove"));
        assertFalse(linkedList.isEmpty());
    }

    @Test
    void clear() {
        linkedList.add("clear");
        assertTrue(linkedList.contains("clear"));
        linkedList.clear();
        assertFalse(linkedList.contains("clear"));
        assertEquals(0, linkedList.size());
        assertTrue(linkedList.isEmpty());
    }

    @Test
    void get() {
        assertEquals("Linked", linkedList.get(0));
        assertNull(linkedList.get(10));
    }

    @Test
    void testAdd() {
        linkedList.add(0, "Hello");
        assertEquals("Hello", linkedList.get(0));
        assertEquals("Linked", linkedList.get(1));
    }

    @Test
    void set() {
        linkedList.set(0, "Hello");
        assertEquals("Hello", linkedList.get(0));
        assertNull(linkedList.get(1));
    }

    @Test
    void testRemove() {
        linkedList.add("testRemove");
        assertEquals("testRemove", linkedList.remove(1));
        assertNull(linkedList.remove(42));
    }

    @Test
    void toArray() {
        linkedList.add("toArray");
        assertEquals("[Linked, toArray]", Arrays.toString(linkedList.toArray()));
        linkedList.clear();
        assertEquals("[]", Arrays.toString(linkedList.toArray()));
    }
}