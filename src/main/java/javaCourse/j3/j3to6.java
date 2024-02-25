package javaCourse.j3;

import java.util.Scanner;

public class j3to6 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int lt = 0;
        int len = 0;
        int cnt = 0;
        int answer = 0;
        for (int rt = 0; rt < n; rt++) {
            if (arr[rt] == 0) {
                cnt++;
                len = rt - lt;
                if (cnt > k) {
                    while (arr[lt] != 0) {
                        lt++;
                    }
                    if (arr[lt] == 0) {
                        cnt--;
                        lt++;
                    }
                }
            }
            answer = Math.max(len, answer);
        }

        System.out.println(answer);
    }
}
