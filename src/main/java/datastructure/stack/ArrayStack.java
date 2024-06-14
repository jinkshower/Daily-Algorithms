package datastructure.stack;

public class ArrayStack {

    private int[] stack;
    private int capacity;
    private int pointer;

    public ArrayStack(int capacity) {
        this.pointer = 0;
        this.capacity = capacity;
        try {
            stack = new int[capacity];
        } catch (OutOfMemoryError e) {
            this.capacity = 0;
        }
    }

    public int push(int x) {
        if (pointer >= capacity) {
            throw new IllegalArgumentException();
        }
        return stack[pointer++] = x;
    }

    public int pop() {
        if (pointer <= 0) {
            throw new IllegalArgumentException();
        }
        return stack[--pointer];
    }

    public int peek() {
        if (pointer <= 0) {
            throw new IllegalArgumentException();
        }
        return stack[pointer - 1];
    }

    public boolean isEmpty() {
        return pointer == 0;
    }

    public boolean isFull() {
        return pointer == capacity;
    }
}
