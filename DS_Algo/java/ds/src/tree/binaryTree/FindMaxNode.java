package tree.binaryTree;

import tree.BTreeFactory;
import tree.TreeNode;

/**
 * Using recursion, find the max element.
 * 
 * @author harshul.varshney
 *
 */
public class FindMaxNode {

	public static void main(String[] s) {
		FindMaxNode o = new FindMaxNode();
		System.out.println(o.getMax(BTreeFactory.getBinaryTree()));
		"text".contains("");
	}

	private int getMax(TreeNode<Integer> root) {
		if(root == null)
			return -1;
		return Math.max(Math.max(root.val, getMax(root.left)), Math.max(root.val, getMax(root.right)));
	} 
}
