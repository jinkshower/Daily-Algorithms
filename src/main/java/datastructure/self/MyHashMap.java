package datastructure.self;

public class MyHashMap {// linked List
    int capacity = 10000;
    Node[] bucket = new Node[capacity];

    public MyHashMap() {
    }

    public void put(int key, int value) {
        int idx = hash(key);
        if (bucket[idx] == null) {
            bucket[idx] = new Node(key, value);
        }

        Node prev = findPrev(bucket[idx], key);
        if (prev.next == null) {
            prev.next = new Node(key, value);
        } else {
            prev.next.value = value;
        }
    }

    public int get(int key) {
        int idx = hash(key);
        if (bucket[idx] == null) {
            return -1;
        }
        Node prev = findPrev(bucket[idx], key);
        if (prev.next == null) {
            return -1;
        }
        return prev.next.value;
    }

    public void remove(int key) {
        int idx = hash(key);
        if (bucket[idx] != null) {
            Node prev = findPrev(bucket[idx], key);
            if (prev.next != null) {
                prev.next = prev.next.next;
            }
        }
    }

    private int hash(int key) {
        return key % capacity;
    }

    private Node findPrev(Node node, int key) {
        Node prev = null;
        while (node != null && node.key != key) {
            prev = node;
            node = node.next;
        }
        return prev;
    }

    static class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.value = val;
        }
    }
}
