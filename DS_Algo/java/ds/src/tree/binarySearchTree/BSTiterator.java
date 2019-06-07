package tree.binarySearchTree;

import java.util.NoSuchElementException;
import java.util.Stack;

/**
 * Implement an iterator over a binary search tree (BST). 
 * Your iterator will be initialized with the root node of a BST. 
 * Calling next() will return the next smallest number in the BST. 
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, 
 * where h is the height of the tree. 
 * 
 * asked in expedia.
 *
 */
public class BSTiterator {
	
	Stack<Node<Integer>> s;
	
	public BSTiterator(Node<Integer> root) {
		s = new Stack<>();
		while(root != null) {
			s.push(root);
			root = root.left;
		}
	}
	
	public boolean hasNext() {
		return !s.isEmpty();
	}
	
	/**
	 * solution is to use BST property that smallest element will be on the left side
	 * use a stack and put all left elements into it, 
	 * return the top element and put all left elements to it's right chld
	 */
	public int next() {
		if(!hasNext())
			throw new NoSuchElementException();
		
		Node<Integer> bstNode = s.pop();
		int result = bstNode.data;
		if(bstNode.right != null) {
			bstNode = bstNode.right;
			while(bstNode != null) {
				s.push(bstNode);
				bstNode = bstNode.left;
			}
		}
		return result;
	}

}
