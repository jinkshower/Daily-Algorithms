package solved;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class b1003 {

    public static int n;
    public static int[][] d = new int[41][3];

    public static void solve(int n) {
        d[0][0] = 1;
        d[0][1] = 0;
        //fi(1) 일때 0출력횟수
        d[1][0] = 0;
        //fi(1) 일때 1출력회수
        d[1][1] = 1;

        for (int i = 2; i <= n; i++) {
            d[i][0] = d[i - 1][0] + d[i - 2][0];
            d[i][1] = d[i - 1][1] + d[i - 2][1];
        }
        System.out.println(d[n][0] + " " + d[n][1]);
        List<Integer> list = IntStream.rangeClosed(0, n).boxed().collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            solve(sc.nextInt());
        }
    }
    
}
