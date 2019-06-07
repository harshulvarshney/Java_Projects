package tree.binaryTree;

import java.util.Deque;
import java.util.LinkedList;

import tree.BTreeFactory;
import tree.Node;

/**
 * Contains Recursive and Non-Recursive approach for
 * 	1- Post-order
 * 	2- In-order and
 * 	3- Pre-order traversal
 * 
 * @author harshul.varshney
 *
 */
public class BTreeTraversal {

	public static void main(String[] args) {
		BTreeTraversal btree = new BTreeTraversal();
		btree.postOrderIterative(BTreeFactory.getBinaryTree());
	}
	
	private void postorderRecursive(Node root) {
		if(root == null)
			return;
		
		postorderRecursive(root.left);
		postorderRecursive(root.right);
		System.out.print(root.data+" | ");
	}
	
	/**
	 * Postorder tree traversal
	 * 2 stacks are used
	 * @param root
	 */
	private void postOrderIterative(Node root) {
		if(root == null)
			return;
		
		Deque<Node> stack1 = new LinkedList<>();
		Deque<Node> stack2 = new LinkedList<>();
		stack1.add(root);
		
		while(!stack1.isEmpty()) {
			root = stack1.pop();
			if(root.left != null){
				stack1.push(root.left);
			}
			if(root.right != null) {
				stack1.push(root.right);
			}
			stack2.push(root);
		}
		
		while(!stack2.isEmpty()) {
			System.out.print(stack2.pop().data+" | ");
		}
	}
	
	private void preorderRecursive(Node root) {
		if(root == null)
			return;
		
		System.out.print(root.data+" | ");
		preorderRecursive(root.left);
		preorderRecursive(root.right);
	}
	
	private void preorderIterative(Node root) {
		if(root == null)
			return;
		
		Deque<Node> stack = new LinkedList<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			root = stack.pop();
			System.out.print(root.data+" | ");
			if(root.right != null)
				stack.push(root.right);
			if(root.left != null)
				stack.push(root.left);
		}
	}
	
	private void inorderRecursive(Node<Integer> root) {
		if(root == null)
			return;
		
		inorderRecursive(root.left);
		System.out.print(root.data+" | ");
		inorderRecursive(root.right);
	}
	
	private void inorderIterative(Node<Integer> root) {
		if (root == null)
			return;
		Deque<Node<Integer>> s = new LinkedList<>();
		
		while(true) {
			if(root != null) {
				s.push(root);
				root = root.left;
			}
			else {
				if(s.isEmpty())
					break;
				
				root = s.pop();
				System.out.print(root.data+" | ");
				root = root.right;
			}
		}
	}

}
