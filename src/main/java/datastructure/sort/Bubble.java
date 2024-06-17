package datastructure.sort;

import java.util.Arrays;

public class Bubble {

    public static void main(String[] args) {
        Bubble bubble = new Bubble();
        int[] arr = {3, 5, 1, 2, 4, 8, 7, 9};
//        bubble.basic(arr);
//        bubble.optimized(arr);
//        bubble.optimized2(arr);
        bubble.optimized3(arr);
        System.out.println(Arrays.toString(arr));
    }

    public void basic(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            for (int j = len - 1; j > i; j--) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                }
            }
        }
    }

    private void optimized(final int[] arr) {
        //이미 정렬이 끝났다면 더이상 정렬하지 않는다.
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            int exchange = 0;
            for (int j = len - 1; j > i; j--) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                    exchange++;
                }
            }
            if (exchange == 0) {
                break;
            }
        }
    }

    private void optimized2(final int[] arr) {
        //정렬을 완료한 인덱스를 기억하고 있다가 그 인덱스 이후로는 정렬하지 않는다.
        int k = 0;
        int len = arr.length;
        while (k < len - 1) {
            int last = len - 1;
            for (int j = len - 1; j > k; j--) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                    last = j;
                }
            }
            k = last;
        }
    }

    private void optimized3(final int[] arr) {
        //앞으로 가장 작은 수를 보내고 뒤로 가장 큰 수를 보내어 정렬한다.
        int len = arr.length;
        int left = 0;
        int right = len - 1;
        int last = right;

        int cnt = 0;

        while (left < right) {
            for (int j = right; j > left; j--) {
                if (arr[j - 1] > arr[j]) {
                    swap(arr, j - 1, j);
                    last = j;
                }
            }
            left = last;
            
            for (int j = left; j < right; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                    cnt++;
                    last = j;
                }
            }
            right = last;
        }
        System.out.println("cnt = " + cnt);
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
