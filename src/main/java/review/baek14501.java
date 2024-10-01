package review;

import java.util.Scanner;

public class baek14501 {
    static int n;
    static int answer;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();
        int[][] graph = new int[n][2];

        for (int i = 0; i < n; i++) {
            graph[i][0] = scanner.nextInt(); // 점프기간
            graph[i][1] = scanner.nextInt(); // 보상
        }

        recur(0, graph, 0);

        System.out.println(answer);
    }

    private static void recur(int depth, int[][] graph, int value) {
        // 퇴사일에 도달했거나 그 이후일 때 최대 보상을 갱신
        if (depth >= n) {
            answer = Math.max(answer, value);
            return;
        }

        // 상담을 하는 경우 (현재 상담을 선택하고 그 상담이 끝난 후로 넘어감)
        if (depth + graph[depth][0] <= n) {  // 상담이 퇴사일을 넘지 않으면
            recur(depth + graph[depth][0], graph, value + graph[depth][1]);
        }

        // 상담을 하지 않는 경우 (다음날로 넘어감)
        recur(depth + 1, graph, value);
    }
}
