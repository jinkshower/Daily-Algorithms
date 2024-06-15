package datastructure.queue;

public class IntDeque {

    private int[] deque;
    private int capacity;
    private int front;
    private int rear;
    private int num;

    public IntDeque(int capacity) {
        num = front = rear = 0;
        this.capacity = capacity;
        deque = new int[capacity];
    }

    public int addFirst(int x) {
        if (num >= capacity) {
            throw new IllegalArgumentException();
        }
        num++;
        if (--front < 0) {
            front = capacity - 1;
        }
        deque[front] = x;
        return x;
    }

    public int addLast(int x) {
        if (num >= capacity) {
            throw new IllegalArgumentException();
        }
        deque[rear++] = x;
        num++;
        if (rear == capacity) {
            rear = 0;
        }
        return x;
    }

    public int removeFirst() {
        if (num <= 0) {
            throw new IllegalArgumentException();
        }
        int x = deque[front++];
        num--;
        if (front == capacity) {
            front = 0;
        }
        return x;
    }

    public int removeLast() {
        if (num <= 0) {
            throw new IllegalArgumentException();
        }
        num--;
        if (--rear < 0) {
            rear = capacity - 1;
        }
        return deque[rear];
    }
}
