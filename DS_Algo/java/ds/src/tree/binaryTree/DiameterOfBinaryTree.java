package tree.binaryTree;

import tree.BTreePrinter;
import tree.TreeNode;

/**
 * @author harshul
. */
public class DiameterOfBinaryTree {
	@SuppressWarnings("unchecked")
	public static void main(String[] s) {
		TreeNode<Integer> root = new TreeNode<>(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.left.left = new TreeNode(5);
		root.left.left.left.left = new TreeNode(7);
		root.left.right = new TreeNode(3);
		root.left.right.left = new TreeNode(2);
		root.left.right.left.left = new TreeNode(5);
		root.left.right.left.left.right = new TreeNode(11);
		root.left.right.right = new TreeNode(7);
		root.left.right.right.right = new TreeNode(9);
		root.right = new TreeNode(9);
		BTreePrinter.printNode(root);
		DiameterOfBinaryTree obj = new DiameterOfBinaryTree();
		obj.getDiameter(root);
		System.out.println(obj.diameter);
	}

	int diameter = 0;
	private int getDiameter(TreeNode<Integer> treeNode) {
		if(treeNode != null) {
			int left = 1+getDiameter(treeNode.left);
			int right = 1+getDiameter(treeNode.right);
			
			int temp = left+right;
			if(diameter < temp)
				diameter = temp;
			
			return Math.max(left, right);
		}
		return -1;
	}
}
