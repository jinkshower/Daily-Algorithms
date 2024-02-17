package ndb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Adventurers {

    public static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr);

        int count = 0;
        int answer = 0;

        for (int i = 0; i < n - 1; i++) {
            count++;
            if (count >= arr[i]) {
                answer++;
                count = 0;
            }
        }
        System.out.println(answer);
    }

    //다시 풀기
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        Collections.sort(list);

        int count = 0;
        int index = 0;
        while (true) {
            int current = list.get(index);
            index += current;
            if (index < list.size()) {
                count++;
            } else {
                break;
            }
        }
        System.out.println(count);
    }
}
