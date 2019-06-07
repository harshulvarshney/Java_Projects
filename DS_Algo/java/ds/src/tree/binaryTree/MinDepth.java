package tree.binaryTree;

import tree.BTreeFactory;
import tree.Node;

/**
 * Find Minimum Depth of a Binary Tree
 * 
 * http://www.geeksforgeeks.org/find-minimum-depth-of-a-binary-tree/
 * @author harshul.varshney
 *
 */
public class MinDepth {
	
	public static void main(String[] args) {
		Node<Integer> root = BTreeFactory.getBinaryTree();
		System.out.println(find(root));
	}
	
	static int find(Node<Integer> root) {
		if(root == null)
			return 0;
		if(root.left == null && root.right == null)
			return 1;
		if(root.left == null)
			return find(root.right)+1;
		if(root.right == null)
			return find(root.right)+1;
		return Math.min(find(root.left), find(root.right)) +1;
	}

}
