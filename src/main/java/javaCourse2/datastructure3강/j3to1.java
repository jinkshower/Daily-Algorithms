package javaCourse2.datastructure3강;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class j3to1 {

    //내풀이 10:40 - 10:48
    public int solution(int[] nums) {
        int answer = 0;
        Arrays.sort(nums);
        Stack<Integer> stack = new Stack<>();
        stack.push(nums[0]);
        int size = -1;
        for (int i = 1; i < nums.length; i++) {
            if (stack.peek() == nums[i]) {
                continue;
            }
            if (stack.peek() == nums[i] - 1) {
                stack.push(nums[i]);
            }
            if (stack.peek() < nums[i] - 1) {
                size = Math.max(size, stack.size());
                stack.clear();
                stack.push(nums[i]);
            }
        }
        size = Math.max(size, stack.size());
        return size;
    }

    //강의풀이
    public int solution2(int[] nums) {
        int answer = 0;
        Set<Integer> set = new HashSet<>();
        for (int x : nums) {
            set.add(x);
        }
        for (int x : set) {
            if (set.contains(x - 1)) {
                continue;
            }
            int cnt = 0;
            while (set.contains(x)) {
                cnt++;
                x++;
            }
            answer = Math.max(cnt, answer);
        }
        return answer;
    }
}
