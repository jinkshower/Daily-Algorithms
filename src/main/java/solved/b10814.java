package solved;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class b10814 {

    public static int n;

    static class Member implements Comparable<Member> {

        int age;
        String name;
        int idx;

        public Member(int age, String name, int idx) {
            this.age = age;
            this.name = name;
            this.idx = idx;
        }

        public int getAge() {
            return this.age;
        }

        public String getName() {
            return this.name;
        }

        public int getIdx() {
            return this.idx;
        }

        public int compareTo(Member other) {
            int otherAge = other.getAge();
            if (this.age < otherAge) {
                return -1;
            } else if (this.age > otherAge) {
                return 1;
            } else {
                return this.idx - other.getIdx();
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();

        List<Member> members = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            String[] split = str.split(" ");
            int age = Integer.parseInt(split[0]);
            String name = split[1];

            Member member = new Member(age, name, i);
            members.add(member);
        }

        Collections.sort(members);

        for (Member member : members) {
            System.out.println(member.getAge() + " " + member.getName());
        }
    }
}
