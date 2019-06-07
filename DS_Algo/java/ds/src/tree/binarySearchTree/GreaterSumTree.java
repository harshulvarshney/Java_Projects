package tree.binarySearchTree;

public class GreaterSumTree {
	
	public static void main(String[] args) {
		Node<Integer> root = BTreeFactory.getBinarySearchTree();
		GreaterSumTree obj = new GreaterSumTree();
		obj.convert(root);
	}
	
	private void convert(Node<Integer> root) {
		if(root == null)
			return;
		Integer data = null;
		convert(root.right);
		int temp = root.data;
		
	}
	
}
