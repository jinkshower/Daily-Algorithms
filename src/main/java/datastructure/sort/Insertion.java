package datastructure.sort;

public class Insertion {

    public static void main(String[] args) {
        Insertion insertion = new Insertion();
        int[] arr = {3, 5, 1, 2, 4, 8, 7, 9};
        insertion.basic(arr);

        System.out.println(java.util.Arrays.toString(arr));
    }

    private void basic(final int[] arr) {
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
    }


    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
