package review;

public class leetcode605 {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        // Deque<Integer> stack = new ArrayDeque<>();
        // for (int i = 0; i < flowerbed.length; i++) {
        //     if (flowerbed[i] == 1) {
        //         if (!stack.isEmpty()) {
        //             stack.pollLast();
        //         }
        //         i++;
        //     } else {
        //         stack.push(0);
        //     }
        // }
        // int available = stack.size();
        // return available >= n ? true : false;
        int len = flowerbed.length;
        int[] tmp = new int[len + 2];
        tmp[0] = 0;
        tmp[len + 1] = 0;
        for (int i = 0; i < len; i++) {
            tmp[i + 1] = flowerbed[i];
        }

        for (int i = 0; i < n; i++) {
            int index = findFirst(tmp);
            if (index == -1) {
                return false;
            }
            tmp[index] = 1;
        }
        return true;
    }

    private int findFirst(int[] tmp) {
        for (int i = 1; i < tmp.length - 1; i++) {
            if (tmp[i - 1] == 0 && tmp[i] == 0 && tmp[i + 1] == 0) {
                return i;
            }
        }
        return -1;
    }
}
