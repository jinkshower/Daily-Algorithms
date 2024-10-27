package datastructure.self;

public class LinkedList {

    Node head;

    public LinkedList() {
        this.head = null;
    }

    public void append(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            return;
        }

        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void prepend(int value) {
        Node newNode = new Node(value);

        if (head == null) {
            head = newNode;
            return;
        }

        newNode.next = head;
        head = newNode;
    }

    public void deleteNode1(int value) {
        if (head == null) {
            return;
        }

        Node current = head;
        while (current.next != null) {
            if (current.next.val == value) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }
    }

    public boolean search(int value) {
        Node current = head;
        while (current != null) {
            if (current.val == value) {
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.println(current.val);
            current = current.next;
        }
    }

    public static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

}
