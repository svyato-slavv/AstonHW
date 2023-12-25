package org.example;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class MyHashMap<K, V> {
    private final Node<K, V>[] nodeArray;
    private int size;

    private float loadFactory;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    static class Node<K, V> {
        final int hash;
        K key;
        V value;

        Node<K, V> next;

        Node(int hash, K key, V value, Node<K, V> next) {
            this.hash = hash;
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public int getHash() {
            return hash;
        }


        public K getKey() {
            return key;
        }

        public void setKey(K key) {
            this.key = key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }

        public Node<K, V> getNext() {
            return next;
        }

        public void setNext(Node<K, V> next) {
            this.next = next;
        }

        @Override
        public String toString() {
            return "{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    public MyHashMap() {
        this.nodeArray = new Node[DEFAULT_INITIAL_CAPACITY];
    }


    public int size() {
        return size;
    }

    public void put(K key, V value) {
        Node<K, V> newNode = new Node<>(key.hashCode(), key, value, null);
        int index = key.hashCode() % nodeArray.length;
        if (nodeArray[index] == null) {
            nodeArray[index] = newNode;
            size++;
        } else {
            if (nodeArray[index].getNext() == null) {
                if (nodeArray[index].getHash() == newNode.getHash() && nodeArray[index].getKey().equals(key)) {
                    nodeArray[index].setValue(value);
                } else {
                    nodeArray[index].setNext(newNode);
                    size++;
                }
            } else {
                Node<K, V> next = nodeArray[index];
                while (next.getNext() != null) {
                    if (next.getHash() == newNode.getHash() && next.getKey().equals(key)) {
                        next.setValue(value);
                        break;
                    } else next = next.getNext();
                }
                if (next.getNext() == null) {
                    next.setNext(newNode);
                    size++;
                }
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[  ");
        for (int i = 0; i < nodeArray.length; i++) {
            if (nodeArray[i] == null)
                continue;
            if (nodeArray[i].getNext() == null) {
                stringBuilder.append(nodeArray[i].getKey()).append("=").append(nodeArray[i].getValue()).append("  ");
            } else {
                Node<K, V> next = nodeArray[i];
                while (next.getNext() != null) {
                    stringBuilder.append(next.getKey()).append("=").append(next.getValue()).append("  ");
                    next = next.getNext();
                }
                if (next.getNext() == null) {
                    stringBuilder.append(next.getKey()).append("=").append(next.getValue()).append("  ");
                }
            }
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }
}

