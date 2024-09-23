package review;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class leetcode216 {

    public List<List<Integer>> combinationSum3(int k, int n) {

        int[] numbers = new int[9];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }
        List<List<Integer>> result = new ArrayList<>();

        backtrack(result, numbers, k, n, 0, 0, new HashSet<>());
        return result;
    }

    private void backtrack(List<List<Integer>> result, int[] numbers, int k, int n, int sum, int index,
                           Set<Integer> path) {
        if (path.size() == k) {
            if (sum == n) {
                result.add(new ArrayList<>(path));
            }
            return;
        }
        //why use index , i +1 ? -> 1,2,4 는 잘 찾지만 4 2 1 도 찾을 수 있기 때문에
        //오름차순 정렬된 성질을 이용하고자
        for (int i = index; i < numbers.length; i++) {
            if (!path.contains(numbers[i])) {
                path.add(numbers[i]);
                backtrack(result, numbers, k, n, sum + numbers[i], i + 1, path);
                path.remove(numbers[i]);
            }
        }
    }
}
