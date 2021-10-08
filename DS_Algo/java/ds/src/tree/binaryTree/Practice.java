package tree.binaryTree;

import tree.BTreeFactory;
import tree.TreeNode;

public class Practice {
	
	public static void main(String[] args) {
		TreeNode<Integer> root = BTreeFactory.getBinaryTree();
		System.out.println(min(root));
	}
	
	static int min(TreeNode root) {
		if(root == null)
			return 0;
		if(root.left == null && root.right == null)
			return 1;
		if(root.left == null)
			return 1 + min(root.right);
		if(root.right == null)
			return 1 + min(root.left);

		return Math.min(min(root.left), min(root.right)) + 1;
	}

}
