package javaCourse.j3;

import java.util.Scanner;

public class j3to9 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                graph[i][j] = sc.nextInt();
            }
        }

        int tmp = 0;
        int tmp2 = 0;

        int rowSum = 0;
        int colSum = 0;
        int diaSum1 = 0;
        int diaSum2 = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                tmp += graph[i][j];
                tmp2 += graph[j][i];
                if (i == j) {
                    diaSum1 += graph[i][j];
                }
                if (i + j == n) {
                    diaSum2 += graph[i][j];
                }
            }
            rowSum = Math.max(rowSum, tmp);
            colSum = Math.max(colSum, tmp2);
            tmp = 0;
            tmp2 = 0;
        }
        int diaSum = Math.max(diaSum1, diaSum2);
        int answer = Math.max(rowSum, Math.max(colSum, diaSum));
        System.out.println(answer);
    }
}
