package datastructure.self;

public class Stack {
    int[] elements;
    int top;
    int capacity;

    public Stack(int size) {
        this.elements = new int[size];
        this.top = -1;
        this.capacity = size;
    }

    public void push(int x) {
        capacity++;
        if (capacity > elements.length) {
            throw new IllegalArgumentException();
        }
        elements[++top] = x;
    }

    public int pop() {
        capacity--;
        if (capacity < 0) {
            throw new IllegalArgumentException();
        }
        return elements[top--];
    }

    public int peek() {
        if (top == -1) {
            throw new IllegalArgumentException();
        }
        return elements[top];
    }
}
