package ndb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class BinarySearch {

    public static int n, m;

    public static boolean binarySearch(Integer[] arr, Integer target, int start, int end) {
        if (start > end) {
            return false;
        }
        int mid = (start + end) / 2;

        if (Objects.equals(arr[mid], target)) {
            return true;
        } else if (arr[mid] > target) {
            return binarySearch(arr, target, start, mid - 1);
        } else {
            return binarySearch(arr, target, mid + 1, end);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        m = sc.nextInt();
        Integer[] arr2 = new Integer[m];
        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }

        List<String> answer = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            if (binarySearch(arr, arr2[i], 0, n - 1)) {
                answer.add("yes");
            } else {
                answer.add("no");
            }
        }
        System.out.println(String.join(" ", answer));
    }
}
