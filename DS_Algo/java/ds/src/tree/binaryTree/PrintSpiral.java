package tree.binaryTree;

import java.util.Stack;

import tree.BTreeFactory;
import tree.TreeNode;

/**
 * 1-Use 2 stacks s1 and s2
 * 2-push root in s1
 * 2-while s1-notEmpty or s2-notEmpty
 * 3-while s1-notEmpty, pop from s1, print it's data and push it's child to s2 > right then left
 * 4-while s2-notEmpty, pop from s2, print it's data and push it's child to s1 > left then right
 * 
 * @author harshul.varshney
 *
 */
public class PrintSpiral {
	
	public static void main(String[] args) {
		spiral(BTreeFactory.getTree());
		//System.out.println(i);
	}
	
	static void spiral(TreeNode<Integer> root) {
		Stack<TreeNode<Integer>> s1 = new Stack();
		Stack<TreeNode<Integer>> s2 = new Stack();
		
		s1.push(root);
		while(!s1.isEmpty() || !s2.isEmpty()) {
			while(!s1.isEmpty()) {
				TreeNode<Integer> n = s1.pop();
				System.out.print(" " + n.val);
				if(n.left != null) s2.push(n.left);
				if(n.right != null) s2.push(n.right);
			}
			while(!s2.isEmpty()) {
				TreeNode<Integer> n = s2.pop();
				System.out.print(" " + n.val);
				if(n.right != null) s1.push(n.right);
				if(n.left != null) s1.push(n.left);
			}
		}
	}
}
