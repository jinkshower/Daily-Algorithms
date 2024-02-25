package javaCourse.j9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class j9to2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Meeting> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            list.add(new Meeting(a, b));
        }

        Collections.sort(list);

        Meeting prev = list.get(0);
        int cnt = 1;
        for (int i = 1; i < n; i++) {
            Meeting cur = list.get(i);
            if (cur.start >= prev.end) {
                cnt++;
                prev = cur;
            }
        }
        System.out.println(cnt);
    }

    static class Meeting implements Comparable<Meeting> {

        public int start;
        public int end;

        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            if (this.end == o.end) {
                return this.start - o.start;
            } else {
                return this.end - o.end;
            }
        }
    }
}
