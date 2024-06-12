package solved;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class b1920 {

    public static int n, m;

    public static boolean binarySearch(List<Integer> origin, int start, int end, int target) {
        if (start > end) {
            return false;
        }
        int mid = (start + end) / 2;

        if (origin.get(mid) == target) {
            return true;
        } else if (origin.get(mid) > target) {
            return binarySearch(origin, start, mid - 1, target);
        } else {
            return binarySearch(origin, mid + 1, end, target);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        List<Integer> origin = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            origin.add(sc.nextInt());
        }

        Collections.sort(origin);

        m = sc.nextInt();
        List<Integer> toFind = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            toFind.add(sc.nextInt());
        }

        for (int i = 0; i < m; i++) {
            if (binarySearch(origin, 0, n - 1, toFind.get(i))) {
                System.out.println(1);
            } else {
                System.out.println(0);
            }
        }
    }
}
