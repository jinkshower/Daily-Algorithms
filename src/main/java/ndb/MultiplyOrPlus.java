package ndb;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MultiplyOrPlus {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        List<Integer> list = new ArrayList<>();
        int n = str.length();

        for (int i = 0; i < n; i++) {
            list.add(str.charAt(i) - '0');
        }

        int result = list.get(0);
        for (int i = 1; i < n; i++) {
            int current = list.get(i);
            int tmp = result * current;
            if (tmp <= result) {
                result += current;
            } else {
                result *= current;
            }
        }
        System.out.println(result);
    }

    //다시 풀기
    public static void main2(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int sum = str.charAt(0) - '0';
        boolean plus = sum < 2 ? true : false;

        for (int i = 1; i < str.length(); i++) {
            int value = str.charAt(i) - '0';
            if (plus) {
                sum += value;
            } else {
                sum *= value;
            }

            plus = value < 2 ? true : false;
        }
        System.out.println(sum);
    }
}
