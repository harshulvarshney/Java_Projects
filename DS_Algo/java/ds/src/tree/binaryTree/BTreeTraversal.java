package tree.binaryTree;

import tree.BTreeFactory;
import tree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

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
		TreeNode<Integer> root = BTreeFactory.FourNodeTree();
	}

	static void postorderRecursive(TreeNode root) {
		if(root == null)
			return;
		
		postorderRecursive(root.left);
		postorderRecursive(root.right);
		System.out.print(root.val +" | ");
	}
	
	/**
	 * Postorder tree traversal
	 * 2 stacks are used
	 * @param root
	 */
	static void postOrderIterative(TreeNode root) {
		if(root == null)
			return;
		
		Deque<TreeNode> stack1 = new LinkedList<>();
		Deque<TreeNode> stack2 = new LinkedList<>();
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
			System.out.print(stack2.pop().val +" | ");
		}
	}

	static void preorderRecursive(TreeNode root) {
		if(root == null)
			return;
		
		System.out.print(root.val +" | ");
		preorderRecursive(root.left);
		preorderRecursive(root.right);
	}

	static void preorderIterative(TreeNode root) {
		if(root == null)
			return;
		
		Deque<TreeNode> stack = new LinkedList<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			root = stack.pop();
			System.out.print(root.val +" | ");
			if(root.right != null)
				stack.push(root.right);
			if(root.left != null)
				stack.push(root.left);
		}
	}

	static void inorderRecursive(TreeNode<Integer> root) {
		if(root == null)
			return;
		
		inorderRecursive(root.left);
		System.out.print(root.val +" | ");
		inorderRecursive(root.right);
	}
	
	static void inorderIterative(TreeNode<Integer> root) {
		if (root == null)
			return;
		Deque<TreeNode<Integer>> s = new LinkedList<>();

		while(root != null || !s.isEmpty()) {
			while(root != null) {
				s.push(root);
				root = root.left;
			}
			root = s.pop();
			System.out.print(root.val + ", ");
			root = root.right;
		}
	}

}
