package review;

public class pro86491 {
    public int solution(int[][] sizes) {
        int answer = 0;
        int ga = 0;
        int se = 0;

        for (int[] size : sizes) {
            int a = size[0];
            int b = size[1];

            if (a >= b) {
                ga = Math.max(a, ga);
                se = Math.max(b, se);
            } else {
                ga = Math.max(b, ga);
                se = Math.max(a, se);
            }
        }
        return ga * se;
    }
}
