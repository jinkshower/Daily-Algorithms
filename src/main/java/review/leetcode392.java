package review;

public class leetcode392 {

    public boolean isSubsequence(String s, String t) {
        // Map<Character, List<Integer>> hash = new HashMap<>();
        // for (int i= 0; i < t.length(); i++) { // O(m)
        //     hash.putIfAbsent(t.charAt(i), new ArrayList<>());
        //     hash.get(t.charAt(i)).add(i);
        // }
        // // System.out.println(hash);
        // int before = -1;
        // for (int i = 0; i < s.length(); i++) { // O(n)
        //     if (!hash.containsKey(s.charAt(i))) {
        //         return false;
        //     }
        //     int nextBigger = findNext(hash, before, s.charAt(i));// O(m)
        //     if (before < nextBigger) {
        //         before = nextBigger;
        //     } else {
        //         return false;
        //     }
        // }
        // return true;
        int n = s.length();
        int m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
            }
        }
        return i == n;
    }

    // private int findNext(Map<Character, List<Integer>> hash, int before, char target) {
    //     List<Integer> found = hash.get(target);
    //     if (found.size() == 1) {
    //         return found.get(0);
    //     }
    //     for (int i : found) {
    //         if (i > before) {
    //             return i;
    //         }
    //     }
    //     return -2;
    // }
}
