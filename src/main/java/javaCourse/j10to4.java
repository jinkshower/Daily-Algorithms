package javaCourse;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class j10to4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Brick> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            list.add(new Brick(a, b, c));
        }

        Collections.sort(list);

        int[] d = new int[n];
        d[0] = list.get(0).height;

        int answer = 0;
        for (int i = 1; i < n; i++) {
            int tmp = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (list.get(i).weight < list.get(j).weight) {
                    tmp = Math.max(tmp, d[j]);
                }
            }
            d[i] = tmp + list.get(i).height;
            answer = Math.max(answer, d[i]);
        }
        System.out.println(answer);
    }

    static class Brick implements Comparable<Brick> {

        public int size;
        public int height;
        public int weight;

        Brick(int size, int height, int weight) {
            this.weight = weight;
            this.height = height;
            this.size = size;
        }

        @Override
        public int compareTo(Brick o) {
            return o.size - this.size;
        }
    }
}
