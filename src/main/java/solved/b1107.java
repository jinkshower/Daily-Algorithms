package solved;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class b1107 {

    public static int n, m;
    public static int size;
    public static int goal;
    public static List<Integer> remote = new ArrayList<>();
    public static Stack<Integer> pm = new Stack<>();

    public static void dfs(int L) {
        if (L == size) {
            int sum = 0;
            for (int x : pm) {
                sum = sum * 10 + x;
            }
            int curDiff = Math.abs(n - sum);
            int goalDiff = Math.abs(n - goal);
            goal = curDiff < goalDiff ? sum : goal;
        } else {
            for (int i = 0; i < remote.size(); i++) {
                pm.push(remote.get(i));
                dfs(L + 1);
                pm.pop();
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt(); //목표 숫자
        m = sc.nextInt(); //고장난 개수

        if (n == 100) {
            System.out.println(0);
            return;
        }

        for (int i = 0; i <= 9; i++) {
            remote.add(i);
        }

        for (int i = 0; i < m; i++) {
            Integer tmp = sc.nextInt();
            remote.remove(tmp);
        }

        size = (int) Math.log10(n) + 1;
        if (remote.isEmpty()) {
            int touch = Math.abs(n - 100);
            System.out.println(touch);
            return;
        }
        dfs(0);

        int touch = Math.abs(n - goal);
        System.out.println(touch + size);
    }
}
