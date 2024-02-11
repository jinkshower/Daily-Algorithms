package solved;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class b1874 {

    public static int n;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }
        Stack<Integer> stack = new Stack<>();

        List<String> answer = new ArrayList<>();

        int current = 1;
        int index = 0;

        boolean canMake = true;
        while (canMake) {
            if (stack.isEmpty()) {
                stack.push(current);
                answer.add("+");
                current++;
            } else if (stack.peek().equals(list.get(index))) {
                stack.pop();
                index++;
                answer.add("-");
            } else if (stack.peek() > list.get(index)) {
                canMake = false;
                break;
            } else {
                stack.push(current);
                answer.add("+");
                current++;
            }
            if (index == n) {
                break;
            }
        }

        if (!canMake) {
            System.out.println("NO");
            return;
        }
        for (int i = 0; i < answer.size(); i++) {
            System.out.println(answer.get(i));
        }
    }
}
