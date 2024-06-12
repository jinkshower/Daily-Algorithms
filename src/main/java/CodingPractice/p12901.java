package CodingPractice;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class p12901 {

    public String solution(int a, int b) {
        LocalDate localDate = LocalDate.of(2016, a, b);
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        return dayOfWeek.toString().substring(0, 3);
    }

    public static void main(String[] args) {
        p12901 prac = new p12901();
        System.out.println(prac.solution(5, 24));
    }
}
