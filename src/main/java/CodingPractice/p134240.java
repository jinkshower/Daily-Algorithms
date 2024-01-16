package CodingPractice;

public class p134240 {
    public String solution(int[] food) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i < food.length; i++) {
            int size = food[i] / 2;
            String num = i + "";
            stringBuilder.append(num.repeat(size));
        }
        String former = stringBuilder.toString();
        String latter = stringBuilder.reverse().toString();
        return former + 0 + latter;
    }

    public static void main(String[] args) {
        p134240 prac = new p134240();
        System.out.println(prac.solution(new int[]{1, 3, 4, 6}));
    }
}
