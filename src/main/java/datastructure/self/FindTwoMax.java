package datastructure.self;

public class FindTwoMax {

    public int[] find(int[] arr) {

        int first = arr[0];
        int second = arr[1];

        if (second > first) {
            int tmp = second;
            second = first;
            first = tmp;
        }

        for (int i = 2; i < arr.length; i++) {
            if (arr[i] > first) {
                second = first;
                first = arr[i];
            } else if (arr[i] > second) {
                second = arr[i];
            }
        }
        return new int[]{first, second};
    }
}
