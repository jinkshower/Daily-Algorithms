package CodingPractice;

public class p12945 {
    public int solution(int n) {
        int result = fibonacci(n);
        return result % 1234567;
    }

    public int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        p12945 prac = new p12945();
        System.out.println(prac.fibonacci(6));
    }
}
