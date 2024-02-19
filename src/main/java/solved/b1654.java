package solved;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

//ㄷㅏ시 풀기
public class b1654 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int n = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(sc.nextInt());
        }

        //이분탐색
        long result = 0;
        long start = 1;
        long max = Collections.max(list);
        long end = max;

        while (start <= end) {
            long mid = (start + end) / 2;
            long total = 0;
            //자른 개수 합치기
            for (int x : list) {
                total += x / mid;
            }
            //개수가 부족하면
            if (total < n) {
                end = mid - 1;
            } else { //개수가 많으면
                result = mid;
                start = mid + 1;
            }
        }
        System.out.println(result);

    }
}
