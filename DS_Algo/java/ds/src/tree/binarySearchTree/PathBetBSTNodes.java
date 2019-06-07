package tree.binarySearchTree;

/**
 * Asked in Amazon.
 * 1. first find the LCA - largest common ancestor
 * 1. then count the number of hops from that ancestor to the required node on both side and add the hopes.
 * 
 * @author harshul.varshney
 *
 */
public class PathBetBSTNodes {
	
	static Node<Integer> lca(Node<Integer> root, int k1, int k2) {
		if(root == null)
			return null;
		while((k1 < root.data && k2 < root.data) || (k1 > root.data && k2 > root.data)) {
			if(k1 < root.data && k2 < root.data)
				root = root.left;
			if(k1 > root.data && k2 > root.data)
				root = root.right;
		}
		return root;
	}
	
	static void findShortestPath(Node<Integer> root, int k1, int k2) {
		Node<Integer> lca = lca(root, k1, k2);
		System.out.println("LCA: " + lca.data);
		int path = findHops(lca, k1) + findHops(lca, k2);
		
		System.out.println("Path: " + path);
	}
	
	static int findHops(Node<Integer> root, int k) {
		if(root == null)
			return 0;
		int hopes = 0;
		while(root.data != k) {
			if(k < root.data) 
				root = root.left;
			else if(k > root.data)
				root = root.right;
			hopes++;
		}
		return hopes;
	}
	
	public static void main(String[] args) {
		Node<Integer> root = BTreeFactory.getBinarySearchTree();
		findShortestPath(root, 1, 20);
	}

}
