package tree.binaryTree;

import tree.BTreeFactory;
import tree.BTreePrinter;
import tree.Node;

public class MirrorBTree {
	
	public static void main(String[] s) {
		Node root = BTreeFactory.getBinaryTree();
		MirrorBTree o = new MirrorBTree();
		o.createMirror(root);
		BTreePrinter.printNode(root);
	}
	
	/**
	 * do pre-order traversal
	 * for each node
	 * 	change ref of left to right
	 * 	change ref of right to left.
	 * 
	 */
	private void createMirror(Node root) {
		if(root == null) {
			return;
		}
		createMirror(root.left);
		createMirror(root.right);
		Node temp = root.left;
		root.left = root.right;
		root.right = temp;
	}

}
