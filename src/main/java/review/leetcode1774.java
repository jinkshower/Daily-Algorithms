package review;

public class leetcode1774 {

    class Solution {

        private int[] perm;
        //if we found exact, no need to find anymore
        private boolean flag;
        private int result = Integer.MAX_VALUE;

        public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
            //at most tow of each type of topping
            //0, 1, 2
            // 1<= n, m <= 10
            //one or more types of toppings.
            //for each baseCosts, find combination of the sum

            perm = new int[toppingCosts.length];

            for (int baseCost : baseCosts) {
                // pruning - if baseCost == target, no need to find
                if (baseCost == target) {
                    return baseCost;
                }
                find(baseCost, toppingCosts, target, 0);
            }
            // I don't think there's must be another data structure to store
            return result;
        }

        private void find(int baseCost, int[] toppingCosts, int target, int level) {
            if (flag) {
                return;
            }
            if (level == toppingCosts.length) {
                //calculate sum
                int sum = 0;
                int idx = 0;
                for (int x : perm) {
                    //ex) 0, 0, 1, 1
                    sum += toppingCosts[idx] * x;
                    idx++;
                }
                sum += baseCost;
                if (sum == target) {
                    flag = true;
                    result = sum;
                }
                int branchGap = Math.abs(sum - target);
                int currentGap = Math.abs(result - target);
                if (branchGap <= currentGap) {
                    if (branchGap == currentGap) {
                        result = sum < result ? sum : result;
                    } else {
                        result = sum;
                    }
                }
            } else {
                for (int i = 0; i < 3; i++) {
                    perm[level] = i;
                    find(baseCost, toppingCosts, target, level + 1);
                }
            }
        }
    }
}
