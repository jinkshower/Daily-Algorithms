package review;

public class leetcode345 {
    //8/21 leetcode75 다시 품
    public String reverseVowels(String s) {
        //스택풀이
        // char[] result = new char[s.length()];
        // Stack<Character> stack = new Stack<>();

        // for (char c : s.toCharArray()) {
        //     if (isVowel(c)) {
        //         stack.push(c);
        //     }
        // }

        // for (int i = 0; i < s.length(); i++) {
        //     char cur = s.charAt(i);
        //     if (isVowel(cur)) {
        //         result[i] = stack.pop();
        //         continue;
        //     }
        //     result[i] = cur;
        // }
        char[] chars = s.toCharArray();
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            while (left < s.length() && !isVowel(chars[left])) {
                left++;
            }

            while (right >= 0 && !isVowel(chars[right])) {
                right--;
            }

            if (left >= right) {
                break;
            }
            char tmp = ' ';
            tmp = chars[left];
            chars[left] = chars[right];
            chars[right] = tmp;
            left++;
            right--;
        }

        return new String(chars);
    }

    private boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
