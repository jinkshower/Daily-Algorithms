package CodingPractice;

public class p161989 {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int paint = 0;
        for (int s : section) {
            if (s >= paint) {
                paint = s + m;
                answer++;
            }
        }
        return answer;
    }


    public static void main(String[] args) {
        p161989 prac = new p161989();
        System.out.println(prac.solution(10, 2, new int[]{1, 3, 6, 8, 10}));
    }
}
