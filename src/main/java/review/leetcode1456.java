package review;

public class leetcode1456 {
    public int maxVowels(String s, int k) {
        char[] chars = s.toCharArray();
        int charCount = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel(chars[i])) {
                charCount++;
            }
        }
        int result = Math.max(0, charCount);
        int rt = k;
        for (int lt = 1; rt < chars.length; lt++) {
            if (isVowel(chars[lt - 1])) {
                charCount--;
            }
            if (isVowel(chars[rt])) {
                charCount++;
            }
            result = Math.max(result, charCount);
            rt++;
        }
        return result;
    }

    private boolean isVowel(char input) {
        if (input == 'a' || input == 'e' || input == 'i' || input == 'o' || input == 'u') {
            return true;
        }
        return false;
    }
}
