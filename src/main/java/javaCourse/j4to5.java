package javaCourse;

import java.util.Collections;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class j4to5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Set<Integer> treeSet = new TreeSet<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    treeSet.add(arr[i] + arr[j] + arr[k]);
                }
            }
        }

        int cnt = 0;
        for (int x : treeSet) {
            cnt++;
            if (cnt == m) {
                System.out.println(x);
            }
        }

    }
}
