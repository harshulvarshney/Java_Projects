package recursion;

import tree.BTreeFactory;
import tree.Node;

public class SumAllLeftLeaves {
	private static int sum = 0;
	public static void main(String[] args) {
		Node<Integer> root = BTreeFactory.getBinarySearchTree();
		SumAllLeftLeaves obj = new SumAllLeftLeaves();
		obj.sum(root, false);
		System.out.println(sum);
	}
	
	private void sum(Node<Integer> node, boolean flag) {
		if(node == null)
			return;
		
		sum(node.left, true);
		//visit
		if(node.left == null && node.right == null && flag)
			sum = sum + node.data;
		
		sum(node.right, false);
	}

}
