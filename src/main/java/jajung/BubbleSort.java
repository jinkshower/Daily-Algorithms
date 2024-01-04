package jajung;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {64, 34, 25, 12, 22, 11, 90};

        System.out.println("정렬 전 배열:");
        printArray(arr);

        bubbleSort(arr);

        System.out.println("\n정렬 후 배열:");
        printArray(arr);
    }

    static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        int tmp = 0;
        // 버블 정렬을 이 부분에 구현해주세요!
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                tmp = arr[i];
                arr[i] = arr[i + 1];
                arr[i + 1] = tmp;
            }
        }
        return arr;
    }

    // 배열 출력
    static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
