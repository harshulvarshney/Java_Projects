package tree.binaryTree;

import java.util.Map;
import java.util.TreeMap;

import tree.BTreeFactory;
import tree.Node;

/**
 * bottom view: https://www.geeksforgeeks.org/bottom-view-binary-tree/
 * diagonal view: http://www.techiedelight.com/print-diagonal-traversal-binary-tree/
 * 
 * @author harshul.varshney
 *
 */
public class BottonView {
	
	private static Map<Integer, Integer> map = new TreeMap<>();
	
	private void printBottonView(Node<Integer> root, int d) {
		if(root == null)
			return;
		map.put(d, root.data);
		int l = d-1;
		printBottonView(root.left, l);
		int r = d+1;
		printBottonView(root.right, r);
	}
	
	private void printDiognalView(Node<Integer> root, int d) {
		if(root == null)
			return;
		map.put(d, root.data);
		int l = d;
		printDiognalView(root.left, d);
		int r = d+1;
		printDiognalView(root.right, r);
	}
	
	public static void main(String[] args) {
		Node<Integer> root = BTreeFactory.getTree();
		BottonView o = new BottonView();
		o.printBottonView(root, 0);
		map.entrySet().stream().forEach(e -> System.out.print(" " + e.getValue()));
		map.entrySet().clear();
		System.out.println();
		o.printDiognalView(root, 0);
		map.entrySet().stream().forEach(e -> System.out.print(" " + e.getValue()));
	}

}
