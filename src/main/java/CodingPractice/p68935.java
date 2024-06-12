package CodingPractice;

public class p68935 {
    public int solution(int n) {
        String three = Integer.toString(n, 3);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(three).reverse();
        three = stringBuilder.toString();
        return Integer.parseInt(three, 3);
    }
}
