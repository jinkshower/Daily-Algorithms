package review;

import java.util.Scanner;

public class baek12865dp {
    static int n;
    static int m;
    static int[][] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        n = scanner.nextInt();  // 아이템 개수
        m = scanner.nextInt();  // 최대 무게
        int[][] graph = new int[n][2];  // 아이템 정보 (무게, 가치)

        for (int i = 0; i < n; i++) {
            graph[i][0] = scanner.nextInt(); // 무게
            graph[i][1] = scanner.nextInt(); // 가치
        }

        dp = new int[n][m + 1];  // dp 배열을 최대 무게 m 크기로 설정
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= m; j++) {
                dp[i][j] = -1;  // dp 배열을 -1로 초기화
            }
        }

        int answer = recur(graph, 0, 0);

        System.out.println(answer);  // 최종 결과 출력
    }

    private static int recur(int[][] graph, int depth, int weight) {
        // 현재 weight가 최대 무게를 초과한 경우
        if (weight > m) {
            return Integer.MIN_VALUE;  // 불가능한 값 반환
        }

        // depth가 n에 도달하면 더 이상 선택할 아이템이 없으므로 0 반환
        if (depth == n) {
            return 0;
        }

        // 이미 계산된 값이 있는 경우 해당 값을 반환
        if (dp[depth][weight] != -1) {
            return dp[depth][weight];
        }

        // 현재 아이템을 선택했을 때와 선택하지 않았을 때의 최대 가치 계산
        dp[depth][weight] = Math.max(
                recur(graph, depth + 1, weight + graph[depth][0]) + graph[depth][1],  // 아이템을 선택한 경우
                recur(graph, depth + 1, weight)  // 아이템을 선택하지 않은 경우
        );

        return dp[depth][weight];
    }
}
