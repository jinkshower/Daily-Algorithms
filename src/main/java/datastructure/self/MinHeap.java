package datastructure.self;

public class MinHeap {
    int[] heap;
    int tail;

    public MinHeap(int size) {
        this.heap = new int[size + 1];
        this.tail = 1;
    }

    public void offer(int x) {
        heap[tail++] = x;
        // rearrange;
    }

    public int poll() {
        int polled = heap[1];
        heap[1] = heap[tail];
        heap[tail--] = 0;
        return polled;
    }

    public void swap(int a, int b) {
        int tmp = heap[a];
        heap[a] = heap[b];
        heap[b] = tmp;
    }
}
