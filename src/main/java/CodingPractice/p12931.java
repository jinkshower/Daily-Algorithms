package CodingPractice;

public class p12931 {
    public int solution(int n) {
        int sum = 0;
        int limit = (int) (Math.log10(n));
        for (int i = limit; i >= 0; i--) {
            double pow = Math.pow(10, i);
            int remain = (int) (n / pow);
            sum += remain;
            n -= (int) (remain * pow);
        }
        return sum;

//        int sum = 0;
//
//        while (n != 0) {
//            sum += n % 10;
//            n /= 10;
//        }
//        return sum;
    }
}
