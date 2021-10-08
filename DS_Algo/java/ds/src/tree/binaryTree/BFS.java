package tree.binaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import tree.BTreeFactory;
import tree.TreeNode;

/**
 * 	Take a Empty Queue.
	Start from the root, insert the root into the Queue.
	Now while Queue is not empty,
		Extract the node from the Queue and insert all its chil�dren into the Queue.
		Print the extracted node.
		
 * @author harshul.varshney
 *
 */
public class BFS {
	
	public void leavelOrderTraversal(TreeNode<Integer> root) {
		if(root == null)
			return;
		
		Queue<TreeNode<Integer>> q = new LinkedList<>();
		q.offer(root);
		q.offer(null);
		TreeNode<Integer> n = null;
		boolean invert = true;
		List<List<Integer>> resp = new ArrayList<>();
		List<Integer> level = new ArrayList<>();
		while(!q.isEmpty()) {
			n = q.poll();
			if(n.left != null)
				q.offer(n.left);
			if(n.right != null)
				q.offer(n.right);
			
			System.out.print(n.val + ", ");
		}
	}
	
	public static void main(String[] s) {
		BFS o = new BFS();
		o.leavelOrderTraversal(BTreeFactory.getBinaryTree());
	}

}
