package tree.binarySearchTree;

import java.io.IOException;

public class Practice {

	static int k = 11;
	public static void main(String[] args) throws IOException {
		Node<Integer> root = BTreeFactory.getBinarySearchTree();
		findK(root);
	}
	
	static void findK(Node<Integer> root) {
		if(root == null)
			return;
		findK(root.left);
		if(k == 1)
			System.out.println("kth smallest element: " + root.data);
		k--;
		findK(root.right);
	}

}
