package CodingPractice;

public class p12947 {
    public boolean solution(int x) {
        int sumDigit = 0;
        int y = x;
        while (x != 0) {
            sumDigit += x % 10;
            x /= 10;
        }
        return y % sumDigit == 0;
    }
}
