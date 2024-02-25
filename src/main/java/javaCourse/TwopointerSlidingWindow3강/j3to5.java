package javaCourse.TwopointerSlidingWindow3강;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class j3to5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        List<Integer> sorted = new ArrayList<>();
        Map<Integer, Integer> ranking = new HashMap<>();

        for (int i = 0; i < n; i++) {
            int cur = sc.nextInt();
            list.add(cur);
            sorted.add(cur);
        }

        Collections.sort(sorted, Collections.reverseOrder());

        int rank = 1;
        for (int x : sorted) {
            if (!ranking.containsKey(x)) {
                ranking.put(x, rank++);
            } else {
                rank++;
            }
        }

        for (int x : list) {
            System.out.print(ranking.get(x) + " ");
        }
    }
}
