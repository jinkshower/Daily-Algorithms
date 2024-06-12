package CodingPractice;

public class p42842 {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        //yellow -> brown
        //약수
        //(a * 2) + (b * 2) + 4 = brown
        // a + 2 = width
        // b + 2 = height
        int a = 0;
        int b = 0;
        int aAndB = (brown - 4) / 2;
        //width + height = aAndB + 4;
        for (int i = 1; i * i <= yellow; i++) {
            if (yellow % i == 0) {
                b = yellow / i;
                if ((i + b) == aAndB) {
                    a = i;
                    break;
                } else {
                    b = 0;
                }
            }
        }
        answer[0] = b + 2;
        answer[1] = a + 2;
        return answer;
    }
}
