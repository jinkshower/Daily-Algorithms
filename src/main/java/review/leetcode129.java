package review;

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

    public int sumNumbers(TreeNode root) {
        //트리를 깊이 우선 탐색하라.
        return find(root, 0);
    }

    private int find(TreeNode node, int sum) {
        if (node == null) {
            return 0;
        }

        sum = sum * 10 + node.val;
        if (node.left == null && node.right == null) {
            return sum;
        }

        return find(node.left, sum) + find(node.right, sum);
    }
}
