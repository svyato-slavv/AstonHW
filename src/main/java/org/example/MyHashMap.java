package org.example;


import java.util.Arrays;
import java.util.Iterator;

public class MyHashMap<K, V> {
    private final Node<K, V>[] nodeArray;
    private int size;

    final float loadFactory;
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
        this.loadFactory = DEFAULT_LOAD_FACTOR;
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public V put(K key, V value) {
        Node<K, V> newNode = new Node<>(key.hashCode(), key, value, null);
        int index = key.hashCode() % nodeArray.length;
        V valueToReturn = null;
        if (nodeArray[index] == null) {
            nodeArray[index] = newNode;
            size++;
        } else {
            if (nodeArray[index].getNext() == null) {
                if (nodeArray[index].getHash() == newNode.getHash() && nodeArray[index].getKey().equals(key)) {
                    valueToReturn = nodeArray[index].getValue();
                    nodeArray[index].setValue(value);
                } else {
                    nodeArray[index].setNext(newNode);
                    size++;
                }
            } else {
                Node<K, V> next = nodeArray[index];
                while (next.getNext() != null) {
                    if (next.getHash() == newNode.getHash() && next.getKey().equals(key)) {
                        valueToReturn = next.getValue();
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
        return valueToReturn;
    }

    public V get(K key) {
        int index = key.hashCode() % nodeArray.length;
        V value = null;
        if (nodeArray[index] == null) {
            return null;
        }
        if (nodeArray[index].getNext() == null) {
            if (nodeArray[index].getHash() == key.hashCode() && nodeArray[index].getKey().equals(key)) {
                value = nodeArray[index].getValue();
            }
        } else {
            Node<K, V> next = nodeArray[index];
            while (next.getNext() != null) {
                if (next.getHash() == key.hashCode() && next.getKey().equals(key)) {
                    value = next.getValue();
                    break;
                } else next = next.getNext();
            }
            if (next.getHash() == key.hashCode() && next.getKey().equals(key)) {
                value = next.getValue();
            }
        }
        return value;
    }

    public boolean containsKey(K key) {
        int index = key.hashCode() % nodeArray.length;
        boolean containsKey = false;
        if (nodeArray[index] == null) {
            return false;
        }
        if (nodeArray[index].getNext() == null) {
            if (nodeArray[index].getHash() == key.hashCode() && nodeArray[index].getKey().equals(key)) {
                containsKey = true;
            }
        } else {
            Node<K, V> next = nodeArray[index];
            while (next.getNext() != null) {
                if (next.getHash() == key.hashCode() && next.getKey().equals(key)) {
                    containsKey = true;
                    break;
                } else next = next.getNext();
            }
            if (next.getHash() == key.hashCode() && next.getKey().equals(key)) {
                containsKey = true;
            }
        }
        return containsKey;
    }

    public void clear() {
        Arrays.fill(nodeArray, null);
        size = 0;
    }

    public V remove(K key) {
        int index = key.hashCode() % nodeArray.length;
        V value = null;
        if (nodeArray[index].getNext() == null) {
            if (nodeArray[index].getHash() == key.hashCode() && nodeArray[index].getKey().equals(key)) {
                value = nodeArray[index].getValue();
                nodeArray[index] = null;
                size--;
            }
        } else {
            Node<K, V> previous = null;
            Node<K, V> next = nodeArray[index];
            while (next.getNext() != null) {
                if (next.getHash() == key.hashCode() && next.getKey().equals(key)) {
                    value = next.getValue();
                    if (previous == null) {
                        nodeArray[index] = next.getNext();
                    } else {
                        previous.setNext(next.getNext());
                    }
                    size--;
                    break;
                } else {
                    previous = next;
                    next = next.getNext();
                }
            }
            if (next.getHash() == key.hashCode() && next.getKey().equals(key)) {
                value = next.getValue();
            }
        }
        return value;
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

