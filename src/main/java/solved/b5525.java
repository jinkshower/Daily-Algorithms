package solved;

import java.util.Scanner;

public class b5525 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String str = sc.next();

        int[] memo = new int[m];

        int result = 0;
        for (int i = 1; i < m - 1; i++) {
            if (str.charAt(i) == 'O' && str.charAt(i + 1) == 'I') {
                memo[i + 1] = memo[i - 1] + 1;
                if (memo[i + 1] >= n) {
                    //문자열이 완성되었는지 확인
                    if (i + 1 >= 2 * n && str.charAt(i - 2 * n + 1) == 'I') {
                        result++;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
