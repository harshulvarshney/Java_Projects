package GfG_top_25;

import tree.BTreeFactory;
import tree.Node;

/**
 * http://www.geeksforgeeks.org/lowest-common-ancestor-in-a-binary-search-tree/
 * @author harshul.varshney
 */
public class LCAinBinarySearchTree {
	
	public static void main(String[] args) {
		Node<Integer> root = BTreeFactory.getBinarySearchTree();
		System.out.println(findLca(root, new Node(15), new Node(8)).data);
	}
	
	static Node<Integer> findLca(Node<Integer> node, Node<Integer> n1, Node<Integer> n2) {
		if(node == null)
			return null;
		
		if(node.data < n1.data && node.data < n2.data)
			return findLca(node.right, n1, n2);
		if(node.data > n1.data && node.data > n2.data)
			return findLca(node.right, n1, n2);
		
		return node;
	}

}
