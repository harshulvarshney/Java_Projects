package tree.binaryTree;

import tree.BTreeFactory;
import tree.Node;

import java.util.LinkedList;
import java.util.Queue;


public class Problem {

	public static int deepestLeavesSum(Node<Integer> root) {

		int sum = 0;

		int depth = depth(root);
		System.out.println("Tree depth: " + depth);


		return sum(root, 0, depth-1);
	}

	private static int sum(Node<Integer> root, int level, int depth) {
		if(root == null)
			return 0;

		if(level == depth)
			return root.data;

		level++;

		return sum(root.left, level, depth) + sum(root.right, level, depth);
	}

	private static int depth(Node root) {
		if(root == null)
			return 0;

		return 1 + Math.max(depth(root.left), depth(root.right));
	}

	public static void main(String[] args) {
		Node<Integer> root = BTreeFactory.getBinaryTree();
		System.out.println(deepestLeavesSum(root));
	}

}
