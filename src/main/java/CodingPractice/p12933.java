package CodingPractice;

import java.util.Arrays;

public class p12933 {
    public static void main(String[] args) {
        long n = 118372;
        String[] list = String.valueOf(n).split("");
        Arrays.sort(list);

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = list.length - 1; i >= 0; i--) {
            System.out.println(list[i]);
            stringBuilder.append(list[i]);
        }
        System.out.println(stringBuilder);
    }
}
