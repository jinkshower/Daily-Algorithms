package ndb;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class BasicSwap {

    public static int n, k;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        Integer[] arrA = new Integer[n];
        Integer[] arrB = new Integer[n];

        for (int i = 0; i < n; i++) {
            arrA[i] = sc.nextInt();
        }
        for (int j = 0; j < n; j++) {
            arrB[j] = sc.nextInt();
        }

        Arrays.sort(arrA);
        Arrays.sort(arrB, Collections.reverseOrder());
        int tmp = 0;

        for (int i = 0; i < k; i++) {

            if (arrA[i] < arrB[i]) {
                tmp = arrA[i];
                arrA[i] = arrB[i];
                arrB[i] = tmp;
            } else {
                break;
            }
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            answer += arrA[i];
        }
        System.out.println(answer);
    }

    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        List<Integer> listA = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            listA.add(sc.nextInt());
        }

        List<Integer> listB = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            listB.add(sc.nextInt());
        }

        Collections.sort(listA);
        Collections.sort(listB, Collections.reverseOrder());

        int indexA = 0;
        int indexB = 0;
        int count = 0;
        while (true) {
            if (count >= k || indexA >= n) {
                break;
            }
            int currentA = listA.get(indexA);
            int currentB = listB.get(indexB);
            if (currentA < currentB) {
                listA.set(indexA, currentB);
                count++;
                indexA++;
                indexB++;
            } else {
                break;
            }
        }

        int sum = 0;
        for (int x : listA) {
            sum += x;
        }
        System.out.println(sum);
    }
}
