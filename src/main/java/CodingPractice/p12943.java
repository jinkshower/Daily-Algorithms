package CodingPractice;

public class p12943 {
    public int solution(int num) {
        int x = collatz(num);
        return x >= 500 ? -1 : x;
    }

    int collatz(long num) {
        int count = 0;
        while (num != 1 && count <= 500) {
            if (num % 2 == 0) {
                num /= 2;
                count++;
            } else {
                num = (num * 3) + 1;
                count++;
            }
        }
        return count;
    }
}
