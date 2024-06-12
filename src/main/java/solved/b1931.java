package solved;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class b1931 {

    static class Meeting implements Comparable<Meeting> {

        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return this.start;
        }

        public int getEnd() {
            return this.end;
        }

        @Override
        public int compareTo(Meeting other) {
            int com = other.getEnd();
            if (this.end < com) {
                return -1;
            } else if (this.end > com) {
                return 1;
            } else {
                return this.start - other.getStart();
            }
        }
    }

    public static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        List<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int startT = sc.nextInt();
            int endT = sc.nextInt();
            meetings.add(new Meeting(startT, endT));
        }

        Collections.sort(meetings);

        int count = 1;
        int start = meetings.get(0).getStart();
        int end = meetings.get(0).getEnd();
        for (int i = 1; i < meetings.size(); i++) {
            if (meetings.get(i).getStart() >= end) {
                start = meetings.get(i).getStart();
                end = meetings.get(i).getEnd();
                count++;
            }
        }
        System.out.println(count);
    }
}
