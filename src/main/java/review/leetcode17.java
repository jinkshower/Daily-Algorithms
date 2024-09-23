package review;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class leetcode17 {

    public List<String> letterCombinations(String digits) {
        if (digits.equals("")) {
            return new ArrayList<>();
        }
        //to put results
        List<String> result = new ArrayList<>();
        // map to point digits
        Map<String, String> map = Map.of(
                "2", "abc",
                "3", "def",
                "4", "ghi",
                "5", "jkl",
                "6", "mno",
                "7", "pqrs",
                "8", "tuv",
                "9", "wxyz");
        backtrack(digits, result, map, 0, "");
        return result;
    }

    private void backtrack(String digits, List<String> result, Map<String, String> map, int index, String product) {
        // if we completed one branch
        if (product.length() == digits.length()) {
            result.add(product);
            return;
        }

        String curDigits = map.get(digits.charAt(index) + "");

        for (char c : curDigits.toCharArray()) {
            backtrack(digits, result, map, index + 1, product + String.valueOf(c));
        }
    }
}
