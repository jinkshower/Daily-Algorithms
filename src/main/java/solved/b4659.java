package solved;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class b4659 {

    public static List<Character> moList = Arrays.asList('a', 'e', 'i', 'o', 'u');

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (true) {
            String s = sc.nextLine();
            if (s.equals("end")) {
                break;
            }

            sb.append("<").append(s).append("> is ");
            if (isHighQuality(s)) {
                sb.append("is acceptable.");
            } else {
                sb.append("is not acceptable.");
            }
            System.out.println(sb.toString());
        }
    }

    private static boolean isHighQuality(String s) {
        char[] cArr = s.toCharArray();
        List<Character> cList = new ArrayList<>();
        for (char c : cArr) {
            cList.add(c);
        }
        if (!haveMo(cList)) {
            return false;
        }

        //자음 혹은 모음 연속 3개
        for (int i = 0; i < cArr.length - 2; i++) {
            if (isMo(cArr[i]) && isMo(cArr[i + 1]) && isMo(cArr[i + 2])) {
                return false;
            }
            if (!isMo(cArr[i]) && !isMo(cArr[i + 1]) && !isMo(cArr[i + 2])) {
                return false;
            }
        }

        //ee, oo 제외한 연속 2개 있는지
        for (int i = 0; i < cArr.length - 1; i++) {
            if (cArr[i] == cArr[i + 1] && cArr[i] != 'e' && cArr[i] != 'o') {
                return false;
            }
        }
        return true;
    }

    private static boolean haveMo(List<Character> cList) {
        List<Character> tmp = new ArrayList<>(cList);
        tmp.retainAll(moList);
        return !tmp.isEmpty();
    }

    private static boolean isMo(char c) {
        return moList.contains(c);
    }
}
