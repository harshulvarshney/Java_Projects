package tree.binaryTree;

import tree.BTreeFactory;
import tree.Node;

public class HeightOfTree {
	
	public static void main(String[] s) {
		HeightOfTree o = new HeightOfTree();
		System.out.println("min: "+o.minHeight(BTreeFactory.getBinaryTree()));
//		System.out.println("max: "+o.maxHeight(BTreeFactory.getBinaryTree()));
	}

	private Integer maxHeight(Node<Integer> node) {
		if(node == null)
			return 0;
		
		return 1 + Math.max(maxHeight(node.left), maxHeight(node.right));
	}
	
	private int minHeight(Node<Integer> root) {//R
		if(root == null)
			return 0;
		if(root.left == null && root.right == null)
			return 1;
		if(root.left == null)
			return minHeight(root.right)+1;
		if(root.right == null)
			return minHeight(root.left)+1;
		
		return Math.min(minHeight(root.left), minHeight(root.right))+1;
	}

}
