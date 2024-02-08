package ndb;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Student implements Comparable<Student> {
    private String name;
    private int score;

    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return this.name;
    }

    public int getScore() {
        return this.score;
    }

    @Override
    public int compareTo(Student other) {
        if (this.score < other.score) {
            return -1;
        }
        return 1;
    }
}

public class BasicComparable {
    public static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        sc.nextLine();

        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String str = sc.nextLine();
            String[] split = str.split(" ");
            String name = split[0];
            int score = Integer.parseInt(split[1]);

            students.add(new Student(name, score));
        }

        Collections.sort(students);

        for (int i = 0; i < n; i++) {
            System.out.print(students.get(i).getName() + " ");
        }
    }
}
