package review;

import java.util.Scanner;

public class baek15652 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();  // 1부터 n까지의 숫자
        int m = scanner.nextInt();  // 선택할 숫자의 개수
        int[] arr = new int[m];  // 선택한 숫자를 저장할 배열
        StringBuilder sb = new StringBuilder();  // 출력을 모아서 한 번에 처리할 StringBuilder

        // 재귀 함수 호출
        recur(0, 1, n, m, arr, sb);

        // 출력
        System.out.println(sb.toString());
    }

    private static void recur(int depth, int start, int n, int m, int[] arr, StringBuilder sb) {
        // M개의 숫자를 모두 선택한 경우 StringBuilder에 추가
        if (depth == m) {
            for (int i = 0; i < arr.length; i++) {
                sb.append(arr[i]).append(" ");
            }
            sb.append("\n");  // 한 줄 끝나면 개행 추가
            return;
        }

        // 중복을 허용하기 때문에 항상 1부터 n까지 선택할 수 있음
        for (int i = start; i <= n; i++) {
            arr[depth] = i;  // 현재 depth에 숫자 저장
            recur(depth + 1, i, n, m, arr, sb);  // 다음 숫자를 선택하기 위해 재귀 호출
        }
    }
}
