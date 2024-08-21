package review;

public class leetcode151 {
    public String reverseWords(String s) {
        if (s.length() == 1) {
            return s;
        }
        String[] split = s.split(" ");
        // System.out.println(Arrays.toString(split));
        StringBuilder sb = new StringBuilder();
        for (int i = split.length - 1; i >= 0; i--) {
            if (split[i].isEmpty()) {
                continue;
            }
            // System.out.println(split[i]);
            sb.append(" ");
            sb.append(split[i]);
        }
        String result = sb.toString().trim();
        return result;
    }
}
