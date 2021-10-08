package tree;

/**
 * 
 * @author harshul.varshney
 * @since Jun 30, 2016
 */
public class BTreeFactory {
	
	public static void main(String[] args) {
		new BTreeFactory().getBinarySearchTree();
	}
	
	
	public static TreeNode<Integer> getTree() {
		TreeNode<Integer> root = new TreeNode<>(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
//		root.left.right = new Node(5);
//		root.right.left = new Node(6);
//		root.right.right = new Node(7);
//		root.right.left.left = new Node(8);
//		root.left.left.right = new Node(9);
		
		BTreePrinter.printNode(root);
		return root;
	}

	public static TreeNode FourNodeTree() {
        TreeNode<Integer> root = new TreeNode<Integer>(1);
        root.left= new TreeNode<Integer>(2);
        root.right = new TreeNode<Integer>(5);
        root.left.left = new TreeNode<Integer>(3);
        root.left.right = new TreeNode<Integer>(4);

        BTreePrinter.printNode(root);
        return root;
    }
	
	public static TreeNode<Integer> getBinaryTree() {
		TreeNode<Integer> root = new TreeNode<Integer>(2);
        TreeNode<Integer> n11 = new TreeNode<Integer>(7);
        TreeNode<Integer> n12 = new TreeNode<Integer>(5);
        TreeNode<Integer> n21 = new TreeNode<Integer>(6);
        TreeNode<Integer> n22 = new TreeNode<Integer>(3);
        TreeNode<Integer> n23 = new TreeNode<Integer>(6);
        TreeNode<Integer> n31 = new TreeNode<Integer>(3);
        TreeNode<Integer> n32 = new TreeNode<Integer>(8);
        TreeNode<Integer> n33 = new TreeNode<Integer>(2);

        root.left = n11;
        root.right = n12;

        n11.left = n21;
        n11.right = n22;

        n12.right = n23;
        
        n22.left = n31;
        n22.right = n32;

        n21.left = new TreeNode(5);
        n21.right = new TreeNode(11);
        n21.right.left = new TreeNode(12);
        n23.right = n33;

        n31.right = new TreeNode(13);
        n31.right.left = new TreeNode(14);
        n33.left = new TreeNode(9);
        
        BTreePrinter.printNode(root);
        return root;
	}
	
	public static TreeNode<Integer> getBinarySearchTree() {
		TreeNode<Integer> root = new TreeNode<Integer>(10);
        TreeNode<Integer> n11 = new TreeNode<Integer>(5);
        TreeNode<Integer> n12 = new TreeNode<Integer>(12);
        TreeNode<Integer> n21 = new TreeNode<Integer>(8);
        TreeNode<Integer> n22 = new TreeNode<Integer>(3);
        TreeNode<Integer> n23 = new TreeNode<Integer>(15);
        /*Node<Integer> n31 = new Node<Integer>(0);
        Node<Integer> n32 = new Node<Integer>(4);
        Node<Integer> n33 = new Node<Integer>(20);*/

        root.left = n11;
        root.right = n12;

        n11.right = n21;
        n11.left = n22;

        n12.right = n23;
        
        /*n22.left = n31;
        n22.right = n32;

        n23.right = n33;*/
//        n23.left = new Node(13);
        
        BTreePrinter.printNode(root);
        return root;
	}

}
