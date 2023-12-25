package org.example;

import java.util.Arrays;

public class MyArrayList<T> {
    private Object[] array;

    private int size;
    static final int DEFAULT_CAPACITY = 10;


    public MyArrayList() {
        array = new Object[]{};
    }

    public MyArrayList(int capacity) {
        array = new Object[capacity];
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        return (T) array[index];
    }

    public void add(T o) {
        if (array.length == 0) {
            array = new Object[DEFAULT_CAPACITY];
            array[0] = o;
            size++;
        } else {
            if (size < array.length) {
                array[size] = o;
                size++;
            } else if (size == array.length) {
                this.array = Arrays.copyOf(this.array, 3 * size / 2);
                array[size] = o;
                size++;
            } else throw new RuntimeException("Exception!");
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public boolean contains(Object o) {
        return Arrays.asList(array).contains(o);
    }


    public void clear() {
        Arrays.fill(array, null);
        size = 0;
    }

    public Object remove(int index) {
        Object toRemove = array[index];
        array[index] = null;
        for (int i = index + 1; i < size; i++) {
            array[i - 1] = array[i];
            array[i] = null;
        }
        size--;
        return toRemove;
    }


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            stringBuilder.append(array[i]);
            if (i == size - 1) {
                stringBuilder.append("]");
                break;
            }
            stringBuilder.append(",");
        }
        return stringBuilder.toString();
    }
}
