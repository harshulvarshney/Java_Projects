package tree.binaryTree;

import tree.BTreeFactory;
import tree.TreeNode;


public class Problem {

	public static int deepestLeavesSum(TreeNode<Integer> root) {

		int sum = 0;

		int depth = depth(root);
		System.out.println("Tree depth: " + depth);


		return sum(root, 0, depth-1);
	}

	private static int sum(TreeNode<Integer> root, int level, int depth) {
		if(root == null)
			return 0;

		if(level == depth)
			return root.val;

		level++;

		return sum(root.left, level, depth) + sum(root.right, level, depth);
	}

	private static int depth(TreeNode root) {
		if(root == null)
			return 0;

		return 1 + Math.max(depth(root.left), depth(root.right));
	}

	public static void main(String[] args) {
		TreeNode<Integer> root = BTreeFactory.getBinaryTree();
		System.out.println(deepestLeavesSum(root));
	}

}
