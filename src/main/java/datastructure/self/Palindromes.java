package datastructure.self;

public class Palindromes {

    public boolean isPalin(String word) {
        int l = 0;
        int r = word.length() - 1;

        while (l < r) {
            if (word.charAt(l) == word.charAt(r)) {
                l++;
                r--;
            } else {
                return false;
            }
        }
        return true;
    }
}
