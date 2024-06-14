package datastructure.stack;

class Node<T> {

    T data;
    Node<T> next;

    public Node(T data) {
        this.data = data;
        this.next = null;
    }
}

public class LinkedListStack<T> {

    private Node<T> top;
    private int size;

    public LinkedListStack() {
        this.top = null;
        this.size = 0;
    }

    public void push(T value) {
        Node<T> newNode = new Node<>(value);
        newNode.next = top;
        top = newNode;
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            throw new IllegalArgumentException();
        }
        T value = top.data;
        top = top.next;
        size--;
        return value;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalArgumentException();
        }
        return top.data;
    }

    public boolean isEmpty() {
        return top == null;
    }
}
