package review;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class baek19942 {
    static int n;
    static int protein, fat, carbo, vitamin;
    static int[][] ing; // 재료 정보를 저장할 배열
    static int answer = Integer.MAX_VALUE; // 최소 가격 저장
    static List<Integer> used = new ArrayList<>(); // 현재 선택한 재료의 인덱스
    static List<Integer> answerUsed = new ArrayList<>(); // 최소 가격일 때 선택한 재료의 인덱스

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 입력 받기
        n = scanner.nextInt();
        protein = scanner.nextInt();
        fat = scanner.nextInt();
        carbo = scanner.nextInt();
        vitamin = scanner.nextInt();

        ing = new int[n][5]; // 각 재료의 (단백질, 지방, 탄수화물, 비타민, 가격) 저장

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                ing[i][j] = scanner.nextInt(); // 각 재료의 성분 및 가격 입력
            }
        }

        // 재귀 호출로 모든 경우 탐색
        recur(0, 0, 0, 0, 0, 0);

        // 결과 출력
        if (!answerUsed.isEmpty()) {
            System.out.println(answer);
            for (int i : answerUsed) {
                System.out.print(i + " "); // 1-based index로 출력
            }
        } else {
            System.out.println(-1);
        }
    }

    // 재귀 함수
    private static void recur(int idx, int p, int f, int c, int v, int price) {
        if (p >= protein && f >= fat && c >= carbo && v >= vitamin) {
            // 최소 가격 갱신
            if (answer > price) {
                answer = price;
                answerUsed = new ArrayList<>(used); // 현재 선택한 재료 저장
            }
        }

        // 재료를 모두 탐색한 경우 종료
        if (idx == n) {
            return;
        }

        // 현재 재료를 선택하는 경우
        used.add(idx + 1); // 1-based index로 저장
        recur(idx + 1, p + ing[idx][0], f + ing[idx][1], c + ing[idx][2], v + ing[idx][3], price + ing[idx][4]);
        used.remove(used.size() - 1); // 백트래킹: 선택한 재료 제거

        // 현재 재료를 선택하지 않는 경우
        recur(idx + 1, p, f, c, v, price);
    }
}
