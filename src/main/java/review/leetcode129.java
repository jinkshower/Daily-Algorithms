package review;

import java.util.ArrayList;
import java.util.List;

public class leetcode129 {

    class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    private List<Integer> list = new ArrayList<>();
    private int answer = 0;

    public int sumNumbers(TreeNode root) {
        //트리를 깊이 우선 탐색하라.
        dfs(root, 0);
        return answer;
    }

    private void dfs(TreeNode cur, int sum) {
        if (cur.left == null && cur.right == null) {
            sum = sum * 10 + cur.val;
            answer += sum;
            return;
        }
        sum = sum * 10 + cur.val;
        if (cur.left != null) {
            dfs(cur.left, sum);
        }
        if (cur.right != null) {
            dfs(cur.right, sum);
        }
    }
}
