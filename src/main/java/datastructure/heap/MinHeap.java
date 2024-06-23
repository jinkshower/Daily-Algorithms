package datastructure.heap;

public class MinHeap {

    int[] heap;
    int size;

    public MinHeap(int capacity) {
        //편한 계산을 위해 1부터 시작
        heap = new int[capacity + 1];
        size = 0;
    }

    public void insert(int value) {
        heap[++size] = value;

        for (int i = size; i > 1; i /= 2) {
            if (heap[i / 2] < heap[i]) {
                swap(i / 2, i);
            } else {
                break;
            }
        }
    }

    public int poll() {
        if (size == 0) {
            return 0;
        }
        int item = heap[1];
        heap[1] = heap[size];
        heap[size--] = 0;

        for (int i = 1; i * 2 <= size; ) {
            if (heap[i] < heap[i * 2] && heap[i] < heap[i * 2 + 1]) {
                break;
            } else if (heap[i * 2] < heap[i * 2 + 1]) {
                swap(i, i * 2);
                i = i * 2;
            } else {
                swap(i, i * 2 + 1);
                i = i * 2 + 1;
            }
        }
        return item;
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}
