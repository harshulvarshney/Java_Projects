package recursion;

import tree.BTreeFactory;
import tree.BTreePrinter;
import tree.Node;

/**
 * Greater sum tree is a tree in which every node con­tains the sum of all 
 * the nodes which are greater than the node.
 * 
 * @author harshul
 *
 */
public class BSTtoGreaterSum {
	
	private static int sum = 0;
	
	public static void main(String[] args) {
		BSTtoGreaterSum obj = new BSTtoGreaterSum();
		Node root = BTreeFactory.getBinarySearchTree();
		obj.convert(root);
	}
	
	private void convert(Node<Integer> node) {
		if(node == null)
			return;
		convert(node.right);
		int temp = node.data;
		node.data = sum;
		sum = sum+temp;
		convert(node.left);
		
		BTreePrinter.printNode(node);
	}
	
	

}
