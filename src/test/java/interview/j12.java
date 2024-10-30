package interview;

public class j12 {
    public int solution(int num) {
        return getCountOfCase(num, 0, num);
//        return getCountOfCaseRec(num);
    }

    // Use while statement
    private int getCountOfCase(int one, int two, int num) {
        int result = 0;
        while (one + two * 2 == num && one >= 0) {
            result += getByRecursion(one + two, two);
            one -= 2;
            two += 1;
        }
        return result;
    }

    public int getByRecursion(int n, int r) {
        int[][] cache = new int[n + 1][r + 1];
        return getByRecursionWithCache(n, r, cache);
    }

    private int getByRecursionWithCache(int n, int r, int[][] cache) {
        if (r == 0 || n == r) {
            return 1;
        }
        if (cache[n][r] != 0) {
            return cache[n][r];
        }
        return cache[n][r] = getByRecursionWithCache(n - 1, r - 1, cache) + getByRecursionWithCache(n - 1, r, cache);
    }

    // test code를 작성하다보니 이것이 피보나치 규칙을 따른다는 것을 알게 되었다.
    // Recursion version
    private int getCountOfCaseRec(int num) {
        if (num < 2) {
            return 1;
        }
        return getCountOfCaseRec(num - 1) + getCountOfCaseRec(num - 2);
    }

}
