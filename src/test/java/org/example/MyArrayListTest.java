package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {
    MyArrayList<Integer> myIntegerList = new MyArrayList<>();
    MyArrayList<String> myStringList = new MyArrayList<>();

    List<Integer> originalIntegerList = new ArrayList<>();
    List<String> originalStringList = new ArrayList<>();

    @BeforeEach
    void myArrayList() {
        originalIntegerList.addAll(List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10));
        originalStringList.addAll(List.of("Ivan", "Igor", "Misha"));

        myIntegerList.add(1);
        myIntegerList.add(2);
        myIntegerList.add(3);
        myIntegerList.add(4);
        myIntegerList.add(5);
        myIntegerList.add(6);
        myIntegerList.add(7);
        myIntegerList.add(8);
        myIntegerList.add(9);
        myIntegerList.add(10);

        myStringList.add("Ivan");
        myStringList.add("Igor");
        myStringList.add("Misha");
    }


    @Test
    void size() {
        Assertions.assertAll("Test size()",
                () -> assertEquals(myStringList.size(), originalStringList.size()),
                () -> assertEquals(myStringList.size(), 3));
    }

    @Test
    void get() {
        Assertions.assertAll("Test get()",
                () -> assertEquals(myIntegerList.get(1), originalIntegerList.get(1)),
                () -> assertInstanceOf(Integer.class, myIntegerList.get(1)),
                () -> assertEquals(myStringList.get(1), originalStringList.get(1)),
                () -> assertInstanceOf(String.class, myStringList.get(1)));
    }

    @Test
    void add() {
        originalIntegerList.add(11);
        myIntegerList.add(11);
        Assertions.assertAll("Test add()",
                () -> assertEquals(originalIntegerList.get(10), myIntegerList.get(10)),
                () -> assertEquals(originalIntegerList.size(), myIntegerList.size()),
                () -> assertEquals(myIntegerList.size(), 11));
    }

    @Test
    void isEmpty() {
        myIntegerList.clear();
        assertTrue(myIntegerList.isEmpty());
    }

    @Test
    void contains() {
        Assertions.assertAll("Test contains()",
                () -> assertFalse(myIntegerList.contains(13)),
                () -> assertTrue(myIntegerList.contains(1)));
    }

    @Test
    void clear() {
        myIntegerList.clear();
        originalIntegerList.clear();
        Assertions.assertAll("Test clear()",
                () -> assertEquals(myIntegerList.size(), originalIntegerList.size()),
                () -> assertEquals(myIntegerList.size(), 0));
    }

    @Test
    void remove() {
        myIntegerList.remove(0);
        originalIntegerList.remove(0);
        Assertions.assertAll("Test remove()",
                () -> assertEquals(myIntegerList.size(), originalIntegerList.size()),
                () -> assertFalse(myIntegerList.contains(1)),
                () -> assertEquals(myIntegerList.size(), 9));
    }
}