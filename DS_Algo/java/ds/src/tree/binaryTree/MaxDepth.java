package tree.binaryTree;

import tree.BTreeFactory;
import tree.TreeNode;

public class MaxDepth {
	
	public static void main(String[] args) {
		TreeNode root = BTreeFactory.getBinaryTree();
		MaxDepth o = new MaxDepth();
		System.out.println(o.maxDepth(root));
	}
	
	private int maxDepth(TreeNode treeNode) {
		if(treeNode == null)
			return 0;
		
		return 1 + Math.max(maxDepth(treeNode.left), maxDepth(treeNode.right));
	}

}
