package CodingPractice;

public class p12922 {
    public String solution(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder.append(i % 2 == 0 ? "수" : "박");
        }
        return stringBuilder.toString();
    }
}
