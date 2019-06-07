package tree.binaryTree;

import tree.Node;

/**
 * BST (Binary Search Tree) is a Binary Tree s.t. 
 * value of left node must be less than the node and value of right node must be greater then the node.
 * 
 * @author harshul.varshney
 * 
 * http://algorithms.tutorialhorizon.com/binary-search-tree-complete-implementation
 *
 */
public class BST {
	
	Node<Integer> root;
	
	public Node<Integer> insert(Node<Integer> root, int n) {
		if(root == null) {
			root = new Node<Integer>(n);
			return root;
		}
		
		if(root.data < n) {
			if(root.right == null)
				root.right = new Node(n);
			else
				insert(root.right, n);
		}
		else if(root.data >= n) {
			if(root.left == null)
				root.left = new Node(n);
			else
				insert(root.left, n);
		}
		return root;
	}
	
	public boolean find(Node<Integer> node, int n) {
		if(node != null) {
			if(node.data == n)
				return true;
			if(node.data < n)
				return find(node.right, n);
			else
				return find(node.left, n);
		}
		return false;
	}
	
	public boolean delete(int n) {
		if(root == null)
			return false;;
		
		Node<Integer> curr = root;
		Node<Integer> parent = root;
		boolean isLeftChild = false;
		while(curr.data != n) {
			if(curr.data < n) {
				parent = curr;
				curr = curr.right;
			}
			else {
				isLeftChild = true;
				parent = curr;
				curr = curr.left;
			}
			if(curr == null)
				return false;
		}
		
		//if curr has no children
		if(curr.left == null && curr.right == null) {
			if(curr == root)
				root = null;
			if(isLeftChild)
				parent.left = null;
			else
				parent.right = null;
		}
		//if curr has 1 child
		else if(curr.right == null) {
			if(curr == root)
				root = root.left;
			else if(isLeftChild)
				parent.left = curr.left;
			else
				parent.right = curr.left;
		}
		else if(curr.left == null) {
			if(curr == root)
				root = root.right;
			else if(isLeftChild)
				parent.left = curr.right;
			else
				parent.right = curr.right;
		}
		//if curr has 2 childres
		else {
			
		}
		return true;
	}

}
