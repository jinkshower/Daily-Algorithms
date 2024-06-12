package solved;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class b5430again {

    static Scanner sc = new Scanner(System.in);

    static void execute(String order, Deque<Integer> deque) {
        boolean reverse = false;
        for (char c : order.toCharArray()) {
            if (c == 'R') {
                reverse = !reverse;
            } else {
                if (deque.isEmpty()) {
                    System.out.println("error");
                    return;
                }
                if (reverse) {
                    deque.removeLast();
                } else {
                    deque.removeFirst();
                }
            }
        }
        int size = deque.size();
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            int current = -1;
            if (reverse) {
                current = deque.removeLast();
            } else {
                current = deque.removeFirst();
            }
            sb.append(current);
            if (i < size - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        System.out.println(sb);
    }

    static void solve() {
        String order = sc.next();
        int n = sc.nextInt();
        String num = sc.next();

        String trimmed = num.substring(1, num.length() - 1);
        String[] split = trimmed.split(",");
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            deque.add(Integer.parseInt(split[i]));
        }

        execute(order, deque);
    }

    public static void main(String[] args) {
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            solve();
        }
    }
}
