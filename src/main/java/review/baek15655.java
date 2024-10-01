package review;

import java.util.Arrays;
import java.util.Scanner;

public class baek15655 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  // n개의 숫자
        int m = scanner.nextInt();  // 선택할 숫자의 개수

        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        Arrays.sort(numbers);

        int[] arr = new int[m];  // 선택한 숫자를 저장할 배열
        StringBuilder sb = new StringBuilder();  // 출력을 모아서 한 번에 처리할 StringBuilder
        // boolean[] visited = new boolean[n];
        // 재귀 함수 호출
        recur(0, numbers, n, m, arr, sb, 0);

        // 출력
        System.out.println(sb.toString());
    }

    private static void recur(int depth, int[] numbers, int n, int m, int[] arr, StringBuilder sb, int start) {
        if (depth == m) {
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");  // 한 줄 끝나면개행 추가
            return;
        }

        for (int i = start; i < n; i++) {
            arr[depth] = numbers[i];
            recur(depth + 1, numbers, n, m, arr, sb, i + 1);
        }
    }
}
