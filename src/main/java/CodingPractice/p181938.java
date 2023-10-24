package CodingPractice;

public class p181938 {
    public int solution(int a, int b) {
        int aConb = Integer.parseInt(""+ a + b);
        return Math.max(aConb, a * b * 2);
    }
}
