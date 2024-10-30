package datastructure.self;

import java.util.Arrays;

public class SelectionSort {

    public int[] sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            swap(arr, i, min);
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
        SelectionSort s = new SelectionSort();
        int[] sorted = s.sort(arr);
        System.out.println(Arrays.toString(sorted));
    }
}
