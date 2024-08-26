package review;

public class leetcode443 {
    public int compress(char[] chars) {
        int len = chars.length;
        int i = 0, j = 0;
        while (i < len) {
            int count = 1;
            while (i + 1 < len && chars[i] == chars[i + 1]) {
                i++;
                count++;
            }
            chars[j] = chars[i];
            j++;
            if (count > 1) {
                String countStr = String.valueOf(count);
                for (int k = 0; k < countStr.length(); k++) {
                    chars[j] = countStr.charAt(k);
                    j++;
                }
            }
            i++;
        }
        return j;
        //     if (chars.length == 1) return 1;
        //     int result = 0;
        //     int lt = 0;
        //     int rt = 0;
        //     while (true) {
        //         while (rt < chars.length && chars[lt] == chars[rt]) {
        //             rt++;
        //         }
        //         int cnt = rt - lt;
        //         int digits = countDigit(cnt);
        //         if (cnt != 1) {
        //             result += digits + 1;
        //         } else {
        //             result += 1;
        //         }
        //         compress(chars, lt, rt, digits);

        //         lt = rt;
        //         if (lt >= chars.length) break;
        //     }
        //     System.out.println(result);
        //     return result;
        // }

        // private void compress(char[] chars, int lt, int rt, int digits) {
        //     System.out.println("lt = " + lt + " rt = " + rt);
        //     int cnt = rt - lt;
        //     if (cnt == 1) return;
        //     char original = chars[lt];
        //     int offset = -1;
        //     if (digits == 1) {
        //         chars[lt + 1] = (char) (cnt + '0');
        //         offset = lt + 2;
        //     } else {
        //         char[] cntChars = String.valueOf(cnt).toCharArray();
        //         for (int i = 0; i < cntChars.length; i++) {
        //             chars[lt + 1 + i] = cntChars[i];
        //         }
        //         offset = lt + cntChars.length + 1;
        //     }
        //     if (offset == rt) return;
        //     if (offset >= chars.length) return;
        //     for (int i = rt; i < chars.length; i++) {
        //         if (offset >= chars.length) break;
        //         chars[offset] = chars[i];
        //         offset++;
        //     }
        // }

        // private int countDigit(int input) {
        //     int cnt = 0;
        //     while (input > 0) {
        //         input /= 10;
        //         cnt++;
        //     }
        //     return cnt;
    }
}
