package com.gmail.arthurstrokov.collections;

import com.gmail.arthurstrokov.collections.lists.CustomLinkedList;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TestCollectionsApplicationTests {

    @Test
    void contextLoads() {
        assertTrue(true);
    }

    @Test
    void customLinkedListTest() {
        CustomLinkedList<String> linkedList = new CustomLinkedList<>();
        assertTrue(linkedList.isEmpty());
        assertEquals(0, linkedList.size());

        linkedList.add("Hello");
        linkedList.add("linked");
        linkedList.add("list");
        linkedList.add("world");

        assertFalse(linkedList.isEmpty());
        assertEquals(4, linkedList.size());

        assertTrue(linkedList.contains("Hello"));
        linkedList.remove("Hello");
        assertFalse(linkedList.contains("Hello"));

        linkedList.remove(0);
        assertFalse(linkedList.contains("linked"));

        assertEquals(2, linkedList.size());

        assertFalse(linkedList.remove("ABC"));
        assertNull(linkedList.remove(5));
        assertNull(linkedList.get(566));
        linkedList.add(566, "566");
        assertNull(linkedList.get(566));

        assertEquals("list", linkedList.get(0));
        linkedList.add(0, "Hello");
        assertEquals("Hello", linkedList.get(0));
        linkedList.add(1, "world!");

        linkedList.set(2, "new");
        assertEquals("new", linkedList.get(2));

        assertEquals("Hello world!", linkedList.get(0) + " " + linkedList.get(1));

        System.out.println(Arrays.toString(linkedList.toArray()));

        assertEquals(4, linkedList.size());

        linkedList.clear();
        assertTrue(linkedList.isEmpty());
        assertEquals(0, linkedList.size());
    }
}
