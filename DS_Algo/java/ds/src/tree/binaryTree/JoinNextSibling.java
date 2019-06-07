package tree.binaryTree;

import tree.Node;

public class JoinNextSibling {
	
	/**
	 * Using pre-order traversal and without using extra space. 
	 */
	static void joinSigling(Node<Integer> root) {
		//if root is null or leaf node, return
		if(root == null || (root.left == null && root.right == null))
			return;
		
		//join siblings
		if(root.left != null && root.right != null)
			root.left.next = root.right;
		else if(root.left != null)
			root.left.next = getSiblingNode(root);
		else if(root.right != null)
			root.right.next = getSiblingNode(root);
		
		joinSigling(root.right);//this order is important
		joinSigling(root.left);
	}
	
	static Node<Integer> getSiblingNode(Node<Integer> root) {
		while(root.next != null) {
			if(root.next.left != null)
				return root.next.left;
			if(root.next.right != null)
				return root.next.right;
			root = root.next.next;
		}
		return null;
	}

}
