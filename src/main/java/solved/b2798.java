package solved;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class b2798 {

    public static int n, m;
    public static List<Integer> cards = new ArrayList<>();
    public static Stack<Integer> pm = new Stack<>();
    public static List<Integer> sums = new ArrayList<>();

    public static void dfs(int L, int n, int m, int[] ch) {
        if (L == 3) {
            int sum = 0;
            for (int x : pm) {
                sum += x;
            }
            if (sum <= m) {
                sums.add(sum);
            }
        } else {
            for (int i = 0; i < n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    pm.push(cards.get(i));
                    dfs(L + 1, n, m, ch);
                    ch[i] = 0;
                    pm.pop();
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();

        for (int i = 0; i < n; i++) {
            cards.add(sc.nextInt());
        }

        int[] ch = new int[n];
        dfs(0, n, m, ch);

        int max = Collections.max(sums);
        System.out.println(max);
    }
}
