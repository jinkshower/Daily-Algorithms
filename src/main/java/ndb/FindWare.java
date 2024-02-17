package ndb;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class FindWare {

    static List<Integer> list = new ArrayList<>();
    static int n;

    static boolean binarySearch(int target) {
        int start = 0;
        int end = n - 1;

        while (start <= end) {
            int mid = (start + end) / 2;
            if (target > list.get(mid)) {
                start = mid + 1;
            } else if (target < list.get(mid)) {
                end = mid - 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        Collections.sort(list);

        int m = sc.nextInt();
        for (int i = 0; i < m; i++) {
            int current = sc.nextInt();
            if (binarySearch(current)) {
                System.out.println("yes");
            } else {
                System.out.println("no");
            }
        }
    }
}
