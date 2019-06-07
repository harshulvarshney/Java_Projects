package tree.binaryTree;

import tree.BTreePrinter;
import tree.Node;

/**
 * @author harshul
. */
public class DiameterOfBinaryTree {
	@SuppressWarnings("unchecked")
	public static void main(String[] s) {
		Node<Integer> root = new Node<>(1);
		root.left = new Node(2);
		root.left.left = new Node(4);
		root.left.left.left = new Node(5);
		root.left.left.left.left = new Node(7);
		root.left.right = new Node(3);
		root.left.right.left = new Node(2);
		root.left.right.left.left = new Node(5);
		root.left.right.left.left.right = new Node(11);
		root.left.right.right = new Node(7);
		root.left.right.right.right = new Node(9);
		root.right = new Node(9);
		BTreePrinter.printNode(root);
		DiameterOfBinaryTree obj = new DiameterOfBinaryTree();
		obj.getDiameter(root);
		System.out.println(obj.diameter);
	}

	int diameter = 0;
	private int getDiameter(Node<Integer> node) {
		if(node != null) {
			int left = 1+getDiameter(node.left);
			int right = 1+getDiameter(node.right);
			
			int temp = left+right;
			if(diameter < temp)
				diameter = temp;
			
			return Math.max(left, right);
		}
		return -1;
	}
}
