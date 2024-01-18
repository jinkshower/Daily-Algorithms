package CodingPractice;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class p159994 {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        boolean flag = true;
        Queue<String> cards_1 = new LinkedList<>(List.of(cards1));
        Queue<String> cards_2 = new LinkedList<>(List.of(cards2));
        for (int i = 0; i < goal.length; i++) {
            String first = cards_1.peek();
            String second = cards_2.peek();
            if (goal[i].equals(first)) {
                cards_1.poll();
            } else if (goal[i].equals(second)) {
                cards_2.poll();
            } else {
                flag = false;
            }
        }
        return flag ? "Yes" : "No";
    }

    public static void main(String[] args) {
        p159994 prac = new p159994();
        System.out.println(prac.solution(new String[]{"i", "water", "drink"},
                new String[]{"want", "to"}, new String[]{"i", "want", "to", "drink", "water"}));
    }
}
