package datastructure.sort;

import java.util.Arrays;

public class Selection {

    public static void main(String[] args) {
        Selection selection = new Selection();
        int[] arr = {3, 5, 1, 2, 4, 8, 7, 9};
        selection.basic(arr);

        System.out.println(Arrays.toString(arr));
    }

    private void basic(final int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[min]) {
                    min = j;
                }
            }
            swap(arr, i, min);
        }
    }

    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
