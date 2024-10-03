package review;

import java.util.Arrays;

public class pro42861 {

    static int[] parents;

    public int solution(int n, int[][] costs) {
        int distance = 0;

        parents = new int[n];
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }

        Arrays.sort(costs, (a, b) -> a[2] - b[2]);

        for (int[] cost : costs) {
            int a = cost[0];
            int b = cost[1];
            int value = cost[2];

            a = find(a);
            b = find(b);

            if (a == b) {
                continue;
            } else {
                union(a, b);
                distance += value;
            }
        }
        return distance;
    }

    private int find(int a) {
        if (parents[a] == a) {
            return a;
        } else {
            parents[a] = find(parents[a]);
            return find(parents[a]);
        }
    }

    private void union(int a, int b) {
        parents[b] = a;
    }
}
