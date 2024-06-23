package datastructure.heap;

public class MaxHeap {

    int[] heap;
    int size;

    public MaxHeap(int capacity) {
        //heap 배열은 1부터 시작한다.
        //부모가 n이면 왼쪽 자식은 2n, 오른쪽 자식은 2n+1이다.
        heap = new int[capacity + 1];
        size = 0;
    }

    public void insert(int value) {
        //힙 가장 마지막에 value를 넣는다.
        heap[++size] = value;
        // 해당 노드의 부모와 비교하여 부모가 작으면 swap
        // 부모와 비교하므로 i를 2로 나눈다.
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
        // 힙의 마지막 노드를 최상단으로 이동한다
        int item = heap[1];//루트 노드값을 일단 저장
        heap[1] = heap[size]; //마지막 노드를 최상단으로 이동한다.
        heap[size--] = 0; //사이즈를 하나 줄이고 마지막 노드 0 초기화

        // 루트 이동 후 자식 2개를 비교해 더 큰 값과 swap한다.
        for (int i = 1; i * 2 <= size; ) {
            //마지막 노드가 왼쪽 노드와 오른쪽 노드 보다 크면 끝
            if (heap[i] > heap[i * 2] && heap[i] > heap[i * 2 + 1]) {
                break;
            }

            //왼쪽 노드가 더 큰 경우, swap
            else if (heap[i * 2] > heap[i * 2 + 1]) {
                swap(i, i * 2);
                i = i * 2;
            } else {
                swap(i, i * 2 + 1);
                i = i * 2 + 1;
            }
        }

        return item; //최상단 노드값을 반환한다.
    }

    private void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }
}
