package datastructure.queue;

public class ArrayQueue {

    private int[] queue;
    private int capacity;
    private int front;
    private int rear;
    private int num;

    public ArrayQueue(int capacity) {
        num = front = rear = 0;
        this.capacity = capacity;
        queue = new int[capacity];
    }

    public int enqueue(int x) {
        if (num >= capacity) {
            throw new IllegalArgumentException();
        }
        queue[rear++] = x;
        num++;
        if (rear == capacity) {
            rear = 0;
        }
        return x;
    }

    public int deque() {
        if (num <= 0) {
            throw new IllegalArgumentException();
        }
        int value = queue[front++];
        num--;
        if (front == capacity) {
            front = 0;
        }
        return value;
    }

    public int peek() {
        if (num <= 0) {
            throw new IllegalArgumentException();
        }
        return queue[front];
    }
}
