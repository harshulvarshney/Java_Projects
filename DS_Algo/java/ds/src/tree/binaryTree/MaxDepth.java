package tree.binaryTree;

import tree.BTreeFactory;
import tree.Node;

public class MaxDepth {
	
	public static void main(String[] args) {
		Node root = BTreeFactory.getBinaryTree();
		MaxDepth o = new MaxDepth();
		System.out.println(o.maxDepth(root));
	}
	
	private int maxDepth(Node node) {
		if(node == null)
			return 0;
		
		return 1 + Math.max(maxDepth(node.left), maxDepth(node.right));
	}

}
