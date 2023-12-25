package org.example;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        MyHashMap<Integer, Integer> myMap = new MyHashMap<>();
//        myMap.put(1, 3);
//        myMap.put(1, 4);
//        myMap.put(2, 5);
//        myMap.put(3, 7);
//        myMap.put(4, 3);
//        myMap.put(2, 6);
//        myMap.put(2, 5);
//        myMap.put(3, 8);
//        myMap.put(18, 3);
//        System.out.println("Размер мапы: " + myMap.size());
//        System.out.println(myMap);


        MyArrayList<Integer> myList = new MyArrayList<>();
        System.out.println(myList.isEmpty());
        myList.add(1);
        myList.add(2);
        myList.add(3);
        myList.add(4);
        myList.add(5);
        myList.add(6);
        myList.add(7);
        myList.add(8);
        myList.add(9);
        myList.add(10);
        System.out.println("Размер листа: " + myList.size());
        System.out.println(myList);
        System.out.println(myList.remove(1));
        System.out.println(myList);
        System.out.println(myList.remove(2));
        System.out.println(myList);

    }
}
