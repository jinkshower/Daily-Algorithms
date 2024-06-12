package solved;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class b5430 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            String str = sc.next();
            int n = sc.nextInt();
            String tmp = sc.next();

            String subbed = tmp.substring(1, tmp.length() - 1);
            String[] arr = subbed.split(",");
            Deque<Integer> deque = new LinkedList<>();

            for (String num : arr) {
                if (!num.equals("")) {
                    deque.add(Integer.parseInt(num));
                }
            }
            AC(deque, str);
        }
    }

    public static void AC(Deque<Integer> deque, String order) {
        boolean reverse = false;

        for (char command : order.toCharArray()) {
            if (command == 'R') {
                reverse = !reverse;
            } else {
                if (deque.isEmpty()) {
                    System.out.println("error");
                    return;
                }

                if (!reverse) {
                    deque.removeFirst();
                } else {
                    deque.removeLast();
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        while (!deque.isEmpty()) {
            sb.append(!reverse ? deque.removeFirst() : deque.removeLast());
            if (!deque.isEmpty()) {
                sb.append(",");
            }
        }
        sb.append("]");
        System.out.println(sb);
    }
}
