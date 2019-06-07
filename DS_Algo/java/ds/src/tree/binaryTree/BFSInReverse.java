package tree.binaryTree;

import java.util.Deque;
import java.util.LinkedList;

import tree.BTreeFactory;
import tree.Node;

public class BFSInReverse {
	
	public static void main(String[] args) {
		BFSInReverse o = new BFSInReverse();
		o.printInReverse(BTreeFactory.getTree());
	}
	
	private void printInReverse(Node<Integer> root) {
		q.offer(root);
		
		while(!q.isEmpty()) {
			Node<Integer> n = q.poll();
			stack.addFirst(n);
			if(n.left != null) q.offer(n.left);
			if(n.right != null) q.offer(n.right);
		}
		while(!stack.isEmpty()) {
			Node n = stack.removeFirst();
			System.out.print(n.data + " ");
		}
	}
	
	private static Deque<Node<Integer>> stack = new LinkedList<>();
	private static Deque<Node<Integer>> q = new LinkedList<>();
	
	private void addNodesToStack(Node<Integer> root) {
		if(root == null)
			return;
		stack.addFirst(root);
		addNodesToStack(root.left);
		addNodesToStack(root.right);
	}

}
