package datastructure.self;

public class Queue {
    int[] elements;
    int front;
    int rear;
    int capacity;

    public Queue(int size) {
        this.elements = new int[size];
        this.front = 0;
        this.rear = -1;
        this.capacity = 0;
    }

    public void offer(int x) {
        elements[++rear] = x;
        capacity++;
    }

    public int poll() {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        capacity--;
        return elements[front++];
    }

    public int peek() {
        if (capacity <= 0) {
            throw new IllegalArgumentException();
        }
        return elements[front];
    }
}
