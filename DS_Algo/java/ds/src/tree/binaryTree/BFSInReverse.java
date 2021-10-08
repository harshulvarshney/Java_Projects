package tree.binaryTree;

import java.util.Deque;
import java.util.LinkedList;

import tree.BTreeFactory;
import tree.TreeNode;

public class BFSInReverse {
	
	public static void main(String[] args) {
		BFSInReverse o = new BFSInReverse();
		o.printInReverse(BTreeFactory.getTree());
	}
	
	private void printInReverse(TreeNode<Integer> root) {
		q.offer(root);
		
		while(!q.isEmpty()) {
			TreeNode<Integer> n = q.poll();
			stack.addFirst(n);
			if(n.left != null) q.offer(n.left);
			if(n.right != null) q.offer(n.right);
		}
		while(!stack.isEmpty()) {
			TreeNode n = stack.removeFirst();
			System.out.print(n.val + " ");
		}
	}
	
	private static Deque<TreeNode<Integer>> stack = new LinkedList<>();
	private static Deque<TreeNode<Integer>> q = new LinkedList<>();
	
	private void addNodesToStack(TreeNode<Integer> root) {
		if(root == null)
			return;
		stack.addFirst(root);
		addNodesToStack(root.left);
		addNodesToStack(root.right);
	}

}
