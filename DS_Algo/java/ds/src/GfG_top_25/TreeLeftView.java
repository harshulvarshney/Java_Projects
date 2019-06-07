package GfG_top_25;

import java.util.LinkedList;
import java.util.Queue;

import tree.BTreeFactory;
import tree.Node;

/**
 * http://www.geeksforgeeks.org/print-left-view-binary-tree/
 * @author harshul.varshney
 */
public class TreeLeftView {
	
	public static void main(String[] args) {
		Node<Integer> root = BTreeFactory.getTree();
		printLeftView(root);
	}
	
	static void printLeftView(Node<Integer> node) {
		//do a level order traversal and print the first element of each level
		
		Queue<Node<Integer>> q = new LinkedList<>();
		q.offer(node);
		q.offer(null);
		System.out.print(node.data);
		while(!q.isEmpty()) {
			Node temp = q.poll();
			if(temp != null) {
				if(temp.left != null) q.offer(temp.left);
				if(temp.right != null) q.offer(temp.right);
			}
			else {
				if(!q.isEmpty())
					System.out.print(" " + q.peek().data);
				q.offer(null);
			}
		}
		
	}

}
