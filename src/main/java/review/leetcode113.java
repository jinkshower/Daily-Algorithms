package review;

import java.util.ArrayList;
import java.util.List;

public class leetcode113 {

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

	public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
		List<List<Integer>> list = new ArrayList<>();
		find(root, targetSum, list, 0, new ArrayList<>());
		return list;
	}

	private void find(TreeNode node, int target, List<List<Integer>> list, int sum,
		List<Integer> path) {
		if (node == null) {
			return;
		}

		sum += node.val;
		path.add(node.val);

		if (node.left == null && node.right == null) {
			if (sum == target) {
				list.add(new ArrayList<>(path));
			}
		}

		find(node.left, target, list, sum, path);
		find(node.right, target, list, sum, path);

		path.remove(path.size() - 1);
	}
}
