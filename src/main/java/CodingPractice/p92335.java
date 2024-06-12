package CodingPractice;

public class p92335 {

    public boolean isPrime(long n) {
        if (n == 1) {
            return false;
        }
        long a = (long) Math.sqrt(n) + 1;
        for (int i = 2; i < a; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int solution(int n, int k) {

        String q = Integer.toString(n, k);
        String[] split = q.split("0");

        int cnt = 0;
        for (String s : split) {
            if (s.equals("")) {
                continue;
            }
            long tmp = Long.parseLong(s);
            if (isPrime(tmp)) {
                cnt++;
            }
        }

        return cnt;
    }
}
