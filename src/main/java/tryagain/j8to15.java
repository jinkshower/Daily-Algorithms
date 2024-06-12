package tryagain;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class j8to15 {

    static int[][] map;
    static int[] combi;
    static int n, m;
    static List<Node> pizza = new ArrayList<>();
    static List<Node> houses = new ArrayList<>();
    static int answer = Integer.MAX_VALUE;

    public static void combi(int L, int S) {
        if (L == m) {
            List<Node> chosenPizza = new ArrayList<>();
            for (int x : combi) {
                chosenPizza.add(pizza.get(x));
            }
            int sum = 0;
            for (Node house : houses) {
                int houseMinDis = Integer.MAX_VALUE;
                for (Node chosen : chosenPizza) {
                    houseMinDis = Math.min(
                        Math.abs(chosen.x - house.x) + Math.abs(chosen.y - house.y), houseMinDis);
                }
                sum += houseMinDis;
            }
            answer = Math.min(answer, sum);

        } else {
            for (int i = S; i < pizza.size(); i++) {
                combi[L] = i;
                combi(L + 1, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();//n에서
        m = sc.nextInt();//m개 뽑기
        map = new int[n][n];
        combi = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int tmp = sc.nextInt();
                if (tmp == 1) {
                    houses.add(new Node(i, j));
                } else if (tmp == 2) {
                    pizza.add(new Node(i, j));
                }
                map[i][j] = tmp;
            }
        }
        combi(0, 0);
        System.out.println(answer);
    }

    static class Node {

        public int x, y;

        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
