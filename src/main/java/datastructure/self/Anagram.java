package datastructure.self;

import java.util.Arrays;

public class Anagram {

    public boolean isAnagram(int[] arr1, int[] arr2) {
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        return Arrays.equals(arr1, arr2);
    }

    public boolean isAnagram2(int[] arr1, int[] arr2) {
        int[] char1 = new int[26];
        int[] char2 = new int[26];

        for (int i = 0; i < arr1.length; i++) {
            char1[arr1[i]]++;
            char2[arr2[i]]++;
        }

        return Arrays.equals(char1, char2);
    }
}
