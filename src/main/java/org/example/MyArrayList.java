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

    public boolean add(T e) {
        if (array.length == 0) {
            array = new Object[DEFAULT_CAPACITY];
            array[0] = e;
            size++;
        } else {
            if (size < array.length) {
                array[size] = e;
                size++;
            } else if (size == array.length) {
                array = Arrays.copyOf(this.array, 3 * size / 2);
                array[size] = e;
                size++;
            } else {
                throw new RuntimeException("Exception!");
            }
        }
        return true;
    }

    public boolean isEmpty() {
        return size == 0;
    }


    public boolean contains(T e) {
        return Arrays.asList(array).contains(e);
    }


    public void clear() {
        Arrays.fill(array, null);
        size = 0;
    }

    public T remove(int index) {
        T toRemove = (T) array[index];
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
