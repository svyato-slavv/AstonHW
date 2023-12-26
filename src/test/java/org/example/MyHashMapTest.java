package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MyHashMapTest {
    MyHashMap<Integer, Integer> myHashMap = new MyHashMap<>();

    Map<Integer, Integer> originalMap = new HashMap<>();


    @BeforeEach
    void myArrayList() {
        originalMap.put(1, 3);
        originalMap.put(2, 4);
        originalMap.put(3, 5);
        originalMap.put(2, 2);
        originalMap.put(18, 20);
        originalMap.put(4, null);

        myHashMap.put(1, 3);
        myHashMap.put(2, 4);
        myHashMap.put(3, 5);
        myHashMap.put(2, 2);
        myHashMap.put(18, 20);
        myHashMap.put(4, null);
    }

    @Test
    void size() {
        assertEquals(myHashMap.size(), originalMap.size());
    }

    @Test
    void put() {
        Assertions.assertAll("Test put()",
                () -> assertEquals(originalMap.put(6, 8), myHashMap.put(6, 8)),
                () -> assertEquals(originalMap.put(3, 3), myHashMap.put(3, 3)),
                () -> assertEquals(originalMap.size(), myHashMap.size()));
    }

    @Test
    void get() {
        Assertions.assertAll("Test remove()",
                () -> assertEquals(originalMap.get(18), myHashMap.get(18)),
                () -> assertNull(originalMap.get(4)),
                () -> assertEquals(originalMap.get(2), myHashMap.get(2)));
    }

    @Test
    void remove() {
        Assertions.assertAll("Test remove()",
                () -> assertEquals(originalMap.remove(3), myHashMap.remove(3)),
                () -> assertEquals(originalMap.remove(4), myHashMap.remove(4)),
                () -> assertEquals(originalMap.size(), myHashMap.size()));
    }

    @Test
    void isEmptyWithNotEmptyMap() {
        assertFalse(myHashMap.isEmpty());
    }

    @Test
    void isEmptyWithEmptyMap() {
        myHashMap.clear();
        assertTrue(myHashMap.isEmpty());
    }

    @Test
    void containsKey() {
        assertTrue(myHashMap.containsKey(1));
    }

    @Test
    void clear() {
        myHashMap.clear();
        assertEquals(myHashMap.size(), 0);
    }
}