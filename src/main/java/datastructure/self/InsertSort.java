package datastructure.self;

import java.util.Arrays;

public class InsertSort {

    public int[] sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int tmp = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > tmp) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = tmp;
        }
        return arr;
    }

    public void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args) {
        int[] arr = {9, 2, 1, 3, 4};
        InsertSort s = new InsertSort();
        int[] sorted = s.sort(arr);
        System.out.println(Arrays.toString(sorted));
    }
}
