package javaCourse.j9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class j9to3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Meeting> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.add(new Meeting(a, 's'));
            list.add(new Meeting(b, 'e'));
        }

        Collections.sort(list);

        int answer = Integer.MIN_VALUE;
        int cnt = 0;
        for (Meeting m : list) {
            if (m.state == 's') {
                cnt++;
            } else {
                cnt--;
            }
            answer = Math.max(answer, cnt);
        }
        System.out.println(answer);
    }

    static class Meeting implements Comparable<Meeting> {

        public int time;
        public char state;

        Meeting(int time, char state) {
            this.time = time;
            this.state = state;
        }

        @Override
        public int compareTo(Meeting o) {
            if (this.time == o.time) {
                return this.state - o.state;
            } else {
                return this.time - o.time;
            }
        }
    }
}
