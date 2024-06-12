package solved;

import java.util.Arrays;

public class b4673 {

    static boolean[] isSelf = new boolean[10050];

    public static void main(String[] args) {
        Arrays.fill(isSelf, true);

        for (int i = 1; i <= 10000; i++) {
            int cur = i;
            String curS = String.valueOf(cur);
            int sum = cur;
            for (char c : curS.toCharArray()) {
                cur += c - '0';
            }
            isSelf[cur] = false;
        }
        for (int i = 1; i <= 10000; i++) {
            if (isSelf[i]) {
                System.out.println(i);
            }
        }
    }
}
