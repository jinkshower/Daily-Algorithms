package review;

import java.util.HashMap;
import java.util.Map;

public class leetcode76 {

    public String minWindow2(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();

        for (char c : t.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        int l = 0, r = 0, len = Integer.MAX_VALUE, idx = -1, cnt = t.length();

        while (r < s.length()) {
            char c = s.charAt(r++);

            if (map.containsKey(c)) {
                if (map.get(c) > 0) {
                    cnt--;
                }

                map.put(c, map.get(c) - 1);
            }

            while (cnt == 0) {
                if (r - l < len) {
                    len = r - l;
                    idx = l;
                }

                char tmp = s.charAt(l++);

                if (map.containsKey(tmp)) {
                    if (map.get(tmp) == 0) {
                        cnt++;
                    }

                    map.put(tmp, map.get(tmp) + 1);
                }
            }
        }
        return idx == -1 ? "" : s.substring(idx, idx + len);
    }

    public String minWindow(String s, String t) {
        Map<Character, Integer> toFind = new HashMap<>();
        for (char c : t.toCharArray()) {
            toFind.put(c, toFind.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> sliding = new HashMap<>();
        int lt = 0;
        int min = Integer.MAX_VALUE;
        String answer = "";
        for (int rt = 0; rt < s.length(); rt++) {
            char cur = s.charAt(rt);
            if (toFind.containsKey(cur)) {
                sliding.put(cur, sliding.getOrDefault(cur, 0) + 1);
            }
            // System.out.println("cur = " + cur + "sliding = " + sliding +"lt = " + lt + "rt = " + rt);
            if (checkCond(sliding, toFind)) {
                if (rt - lt < min) {
                    min = rt - lt;
                    answer = s.substring(lt, rt + 1);
                }

                decrementSliding(sliding, s, lt);
                lt++;
                while (lt < rt && !toFind.containsKey(s.charAt(lt))) {
                    lt++;
                    if (checkCond(sliding, toFind)) {
                        if (rt - lt < min) {
                            min = rt - lt;
                            answer = s.substring(lt, rt + 1);
                        }
                        decrementSliding(sliding, s, lt);
                        lt++;
                    }
                }
            }
        }
        return answer;
    }

    private void decrementSliding(Map<Character, Integer> sliding, String s, int lt) {
        sliding.put(s.charAt(lt), sliding.get(s.charAt(lt)) - 1);
        if (sliding.get(s.charAt(lt)) <= 0) {
            sliding.remove(s.charAt(lt));
        }
    }

    private boolean checkCond(Map<Character, Integer> sliding, Map<Character, Integer> toFind) {
        if (sliding.size() != toFind.size()) {
            return false;
        }
        for (Map.Entry<Character, Integer> entry : sliding.entrySet()) {
            int left = entry.getValue();
            int right = toFind.get(entry.getKey());
            if (left < right) {
                return false;
            }
        }
        return true;
    }
}
