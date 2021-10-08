package tree.binaryTree;

import tree.BTreeFactory;
import tree.TreeNode;

import java.util.Stack;

/**
 * 	First add the root to Stack.
	Pop out an ele�ment from Stack and add its right and left chil�dren to stack.
	Pop out an ele�ment and print it and add its children.
	Repeat the above two steps until the Stack id empty.
 * @author harshul.varshney
 *
 */
public class DFS {
	
	public void deapthFirstSearch(TreeNode<Integer> root) {
		if(root == null)
			return;
		
		Stack<TreeNode> stack = new Stack<>();
		stack.push(root);
		while(!stack.isEmpty()) {
			TreeNode x = stack.pop();
			System.out.print(x.val + " ");
			if(x.right != null) stack.push(x.right);
			if(x.left != null) stack.push(x.left);
		}
	}
	
	public static void main(String[] s) {
		DFS o = new DFS();
		o.deapthFirstSearch(BTreeFactory.getBinaryTree());
	}

}
