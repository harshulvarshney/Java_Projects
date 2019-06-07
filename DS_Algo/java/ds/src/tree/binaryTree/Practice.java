package tree.binaryTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

import javax.management.Query;

import tree.BTreeFactory;
import tree.Node;

public class Practice {
	
	public static void main(String[] args) {
		Node<Integer> root = BTreeFactory.getBinaryTree();
		//BTreePrinter.printNode(root);
		print(root);
	}
	
	static void print(Node<Integer> root) {
		if(root == null)
			return;
		
		print(root.left);
		if(root.left == null && root.right == null)
			System.out.print(root.data + ", ");
		print(root.right);
		
	}

}
