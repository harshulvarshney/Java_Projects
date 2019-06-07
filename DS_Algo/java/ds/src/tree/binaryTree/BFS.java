package tree.binaryTree;

import java.util.LinkedList;
import java.util.Queue;

import tree.BTreeFactory;
import tree.Node;

/**
 * 	Take a Empty Queue.
	Start from the root, insert the root into the Queue.
	Now while Queue is not empty,
		Extract the node from the Queue and insert all its chil­dren into the Queue.
		Print the extracted node.
		
 * @author harshul.varshney
 *
 */
public class BFS {
	
	public void leavelOrderTraversal(Node<Integer> root) {
		if(root == null)
			return;
		
		Queue<Node<Integer>> q = new LinkedList<>();
		q.add(root);
		Node<Integer> n = null;
		while(!q.isEmpty()) {
			n = q.poll();
			if(n.left != null)
				q.add(n.left);
			if(n.right != null)
				q.add(n.right);
			
			System.out.print(n.data + ", ");
		}
	}
	
	public static void main(String[] s) {
		BFS o = new BFS();
		o.leavelOrderTraversal(BTreeFactory.getBinaryTree());
	}

}
