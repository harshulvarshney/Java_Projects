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
	
	
	public static Node<Integer> getTree() {
		Node<Integer> root = new Node<>(1);
		root.left = new Node(2);
		root.right = new Node(3);
		root.left.left = new Node(4);
//		root.left.right = new Node(5);
//		root.right.left = new Node(6);
//		root.right.right = new Node(7);
//		root.right.left.left = new Node(8);
//		root.left.left.right = new Node(9);
		
		BTreePrinter.printNode(root);
		return root;
	}
	
	public static Node<Integer> getBinaryTree() {
		Node<Integer> root = new Node<Integer>(2);
        Node<Integer> n11 = new Node<Integer>(7);
        Node<Integer> n12 = new Node<Integer>(5);
        Node<Integer> n21 = new Node<Integer>(6);
        Node<Integer> n22 = new Node<Integer>(3);
        Node<Integer> n23 = new Node<Integer>(6);
        Node<Integer> n31 = new Node<Integer>(3);
        Node<Integer> n32 = new Node<Integer>(8);
        Node<Integer> n33 = new Node<Integer>(2);

        root.left = n11;
        root.right = n12;

        n11.left = n21;
        n11.right = n22;

//        n12.right = n23;
        
        n22.left = n31;
        n22.right = n32;

        n21.left = new Node(5);
        n21.right = new Node(11);
        n21.right.left = new Node(12);
//        n23.right = n33;

        n31.right = new Node(13);
        n31.right.left = new Node(14);
//        n33.left = new Node(9);
        
        BTreePrinter.printNode(root);
        return root;
	}
	
	public static Node<Integer> getBinarySearchTree() {
		Node<Integer> root = new Node<Integer>(10);
        Node<Integer> n11 = new Node<Integer>(5);
        Node<Integer> n12 = new Node<Integer>(12);
        Node<Integer> n21 = new Node<Integer>(8);
        Node<Integer> n22 = new Node<Integer>(3);
        Node<Integer> n23 = new Node<Integer>(15);
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
