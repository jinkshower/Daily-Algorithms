package review;

import java.util.Scanner;

public class baek2961 {

    static int n;
    static int answer;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        n = scanner.nextInt();
        int[][] taste = new int[n][2];

        for (int i = 0; i < n; i++) {
            taste[i][0] = scanner.nextInt();
            taste[i][1] = scanner.nextInt();
        }
        answer = Integer.MAX_VALUE;

        recur(0, 1, 0, taste, 0);
        System.out.println(answer);
    }

    private static void recur(int depth, int s, int b, int[][] taste, int use) {
        if (depth == n) {
            if (use == 0) {
                return;
            }
            //s b의 차이
            answer = Math.min(answer, Math.abs(s - b));
            return;
        }
        //이 재료를 넣거나 안넣거나
        recur(depth + 1, s * taste[depth][0], b + taste[depth][1], taste, use + 1);
        recur(depth + 1, s, b, taste, use);
    }
}
