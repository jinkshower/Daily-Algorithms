package CodingPractice;

public class p132267 {

    public int solution(int a, int b, int n) {
        int answer = 0;
        int divisor = 0;
        int returnedBottle = 0;
        while (n >= a) {
            divisor = n / a;
            returnedBottle = divisor * b;
            answer += returnedBottle;
            n = n - (a * divisor) + returnedBottle;
            System.out.println("divisor = " + divisor);
            System.out.println("returnedBottle = " + returnedBottle);
            System.out.println("n = " + n);
        }
        return answer;
    }

    public static void main(String[] args) {
        p132267 prac = new p132267();
        System.out.println(prac.solution(5, 3, 21));
    }
}
