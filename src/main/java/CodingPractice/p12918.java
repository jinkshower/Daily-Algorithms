package CodingPractice;

public class p12918 {

    public boolean solution(String s) {
        if (s.length() != 4 && s.length() != 6) {
            return false;
        }
        return s.chars().allMatch(c -> 48 <= c && c <= 57);
    }
}
