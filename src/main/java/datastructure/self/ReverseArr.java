package datastructure.self;

public class ReverseArr {

    public int[] reverseArr(int[] arr) {
        int l = 0;
        int r = arr.length;

        while (l < r) {
            int tmp = arr[r];
            arr[r] = arr[l];
            arr[l] = tmp;
            l++;
            r--;
        }
        return arr;
    }
}
