package GfG_top_25;

import tree.BTreePrinter;
import tree.Node;
import tree.BTreeFactory;

public class LCAinBinaryTree {
	
	public static void main(String[] args) {
		Node<Integer> root = BTreeFactory.getTree();
		System.out.println(findLca(root, new Node(6), new Node(7)).data);
	}
	
	static Node<Integer> findLca(Node<Integer> node, Node<Integer> n1, Node<Integer> n2) {
		//base case
		if(node == null)
			return null;
		
		if(node.data == n1.data || node.data == n2.data)
			return node;
		
		Node left = findLca(node.left, n1, n2);
		Node right = findLca(node.right, n1, n2);
		
		if(left != null && right != null)
			return node;
		
		return left != null ? left : right;
	}

}
