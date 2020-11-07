package tree.binaryTree;

import tree.BTreeFactory;
import tree.Node;

import java.util.LinkedList;
import java.util.Queue;

public class Practice {
	
	public static void main(String[] args) {
		Node<Integer> root = BTreeFactory.getBinaryTree();
		System.out.println(min(root));
	}
	
	static int min(Node root) {
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
