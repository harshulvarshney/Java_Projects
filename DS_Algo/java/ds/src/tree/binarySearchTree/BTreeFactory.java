package tree.binarySearchTree;

/**
 * 
 * @author harshul.varshney
 * @since Jun 30, 2016
 */
public class BTreeFactory {
	
	public static void main(String[] args) {
		new BTreeFactory().getBinarySearchTree();
	}
	
	public static Node<Integer> getBinaryTree() {
		Node<Integer> root = new Node<Integer>(2);
        Node<Integer> n11 = new Node<Integer>(7);
        Node<Integer> n12 = new Node<Integer>(5);
        Node<Integer> n21 = new Node<Integer>(2);
        Node<Integer> n22 = new Node<Integer>(6);
        Node<Integer> n23 = new Node<Integer>(9);
        Node<Integer> n31 = new Node<Integer>(5);
        Node<Integer> n32 = new Node<Integer>(8);
        Node<Integer> n33 = new Node<Integer>(4);

        root.left = n11;
        root.right = n12;

        n11.left = n21;
        n11.right = n22;

        n12.right = n23;
        
        n22.left = n31;
        n22.right = n32;

        n23.right = n33;
        
        n33.left = new Node(99);
        
        BTreePrinter.printNode(root);
        return root;
	}
	
	public static Node<Integer> getBinarySearchTree() {
		Node<Integer> root = new Node<Integer>(10);
        Node<Integer> n11 = new Node<Integer>(6);
        Node<Integer> n12 = new Node<Integer>(15);
        Node<Integer> n21 = new Node<Integer>(9);
        Node<Integer> n22 = new Node<Integer>(3);
        Node<Integer> n23 = new Node<Integer>(19);
        Node<Integer> n31 = new Node<Integer>(1);
        Node<Integer> n32 = new Node<Integer>(4);
        Node<Integer> n33 = new Node<Integer>(20);

        root.left = n11;
        root.right = n12;

        n11.right = n21;
        n11.left = n22;

        n12.right = n23;
        
        n22.left = n31;
        n22.right = n32;

        n23.right = n33;
        
        BTreePrinter.printNode(root);
        return root;
	}

}
