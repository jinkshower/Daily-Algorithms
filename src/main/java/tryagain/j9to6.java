package tryagain;

import java.util.Scanner;

public class j9to6 {

    static int n, m;
    static int[] unf;

    static int find(int v) {
        if (unf[v] == v) {
            return v;
        }
        return unf[v] = find(unf[v]);
    }

    static void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);
        if (fa != fb) {
            unf[fa] = fb;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //9명
        m = sc.nextInt(); //7쌍

        unf = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            unf[i] = i;
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            union(a, b);
        }
        int a = sc.nextInt();
        int b = sc.nextInt();
        int fa = find(a);
        int fb = find(b);
        if (fa == fb) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
