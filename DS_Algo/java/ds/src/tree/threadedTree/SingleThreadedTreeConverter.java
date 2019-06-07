package tree.threadedTree;

import tree.BTreeFactory;
import tree.Node;

/**
 * Each node is threaded towards either the in-order pre­de­ces­sor 
 * or suc­ces­sor (left orright) means all right null point­ers will point to 
 * inorder suc­ces­sor OR all left null point­ers will point to inorder predecessor.
 * 
 * ref: http://algorithms.tutorialhorizon.com/introduction-to-threaded-binary-tree/
 * 
 * @author harshul varshney
 * May 17, 2017
 */
public class SingleThreadedTreeConverter {
	
	/**
	 * To convert a normal binary tree to threaded binary tree,
	 * do in-order traversal in reverse and pass parent while traversing left.
	 * 
	 * @param node
	 * @param parent
	 */
	public void convert(Node<Integer> node, Node<Integer> parent) {
		if(node == null)
			return;
		
		convert(node.right, parent);//reverse in-order.
		if(node.right == null && parent != null) {
			node.right = parent;
			node.rightThread = true;
		}
		convert(node.left, node);//pass node as parent of left node.
	}
	
	/**
	 * Threaded binary tree makes the tree tra­ver­sal faster 
	 * since we do not need stack or recur­sion for traversal.
	 * 
	 * @param root
	 */
	public void traverseThreadedTree(Node<Integer> root) {
		Node<Integer> curr = findLeftMostNode(root);
		while(curr != null) {
			System.out.print(curr.data + " ");
			if(curr.rightThread)
				curr = curr.right;
			else
				curr = findLeftMostNode(curr.right);
		}
	}
	
	private Node<Integer> findLeftMostNode(Node<Integer> node) {
		if(node != null) {
			while(node.left != null) {
				node = node.left;
			}
			return node;
		}
		return null;
	}
	
	public static void main(String[] args) {
		SingleThreadedTreeConverter obj = new SingleThreadedTreeConverter();
		Node<Integer> root = BTreeFactory.getBinaryTree();
		obj.convert(root, null);
		obj.traverseThreadedTree(root);
	}

}
