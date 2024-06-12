package solved;

import java.util.Scanner;

public class b6064 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        String str = sc.next();

        char[] arr = str.toCharArray();
        int[] memo = new int[m];

        int count = 0;
        for (int i = 1; i < m - 1; i++) {
            //OI를 찾으면
            if (arr[i] == 'O' && arr[i + 1] == 'I') {
                memo[i + 1] = memo[i - 1] + 1;

                if (memo[i + 1] >= n && arr[i - 2 * n + 1] == 'I') {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
