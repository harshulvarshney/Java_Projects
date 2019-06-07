package tree.binaryTree;

import tree.BTreeFactory;
import tree.Node;

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

	private int getMax(Node<Integer> root) {
		if(root == null)
			return -1;
		return Math.max(Math.max(root.data, getMax(root.left)), Math.max(root.data, getMax(root.right)));
	} 
}
