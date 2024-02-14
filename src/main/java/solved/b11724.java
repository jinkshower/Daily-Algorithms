package solved;

import java.util.Scanner;

public class b11724 {

    public static int n; //수의 개수
    public static int m; //합 구하는 회수

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        Integer[] arr = new Integer[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] culSum = new int[n + 1];
        culSum[1] = arr[1];
        for (int i = 2; i <= n; i++) {
            culSum[i] = culSum[i - 1] + arr[i];
        }

        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            solve(a, b, culSum);
        }
    }

    public static void solve(int a, int b, int[] culSum) {
        int partSum = culSum[b] - culSum[a - 1];
        System.out.println(partSum);
    }
}
