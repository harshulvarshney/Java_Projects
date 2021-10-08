package tree.threadedTree;

import tree.BTreeFactory;
import tree.TreeNode;

/**
 * Each node is threaded towards either the in-order pre�de�ces�sor 
 * or suc�ces�sor (left orright) means all right null point�ers will point to 
 * inorder suc�ces�sor OR all left null point�ers will point to inorder predecessor.
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
	 * @param treeNode
	 * @param parent
	 */
	public void convert(TreeNode<Integer> treeNode, TreeNode<Integer> parent) {
		if(treeNode == null)
			return;
		
		convert(treeNode.right, parent);//reverse in-order.
		if(treeNode.right == null && parent != null) {
			treeNode.right = parent;
			treeNode.rightThread = true;
		}
		convert(treeNode.left, treeNode);//pass node as parent of left node.
	}
	
	/**
	 * Threaded binary tree makes the tree tra�ver�sal faster 
	 * since we do not need stack or recur�sion for traversal.
	 * 
	 * @param root
	 */
	public void traverseThreadedTree(TreeNode<Integer> root) {
		TreeNode<Integer> curr = findLeftMostNode(root);
		while(curr != null) {
			System.out.print(curr.val + " ");
			if(curr.rightThread)
				curr = curr.right;
			else
				curr = findLeftMostNode(curr.right);
		}
	}
	
	private TreeNode<Integer> findLeftMostNode(TreeNode<Integer> treeNode) {
		if(treeNode != null) {
			while(treeNode.left != null) {
				treeNode = treeNode.left;
			}
			return treeNode;
		}
		return null;
	}
	
	public static void main(String[] args) {
		SingleThreadedTreeConverter obj = new SingleThreadedTreeConverter();
		TreeNode<Integer> root = BTreeFactory.getBinaryTree();
		obj.convert(root, null);
		obj.traverseThreadedTree(root);
	}

}
