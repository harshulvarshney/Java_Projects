package tree.binaryTree;

/**
 * 
 * @author harshul.varshney
 * @since Jun 29, 2016
 */
public class BinaryTree<T extends Comparable<T>> {
	
	static class Node<T extends Comparable<T>> {
		Node<T> left, right;
		T data;
		
		public Node(T data) {
			this.data = data;
		}
		
		public Node(T data, Node<T> left, Node<T> right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
		
		public T getData() {
			return this.data;
		}
		
		public Node<T> getLeft() {
			return this.left;
		}
		
		public Node<T> getRight() {
			return this.right;
		}
	}
	
	public Node<T> addNodeLeft(T data, Node<T> head) {
		Node<T> node = new Node<>(data);
		if(head == null)
			return node;
		head.left = node;
		return node;
	}
	
	public Node<T> addNodeRight(T data, Node<T> head) {
		Node<T> node = new Node<>(data);
		if(head == null)
			return node;
		head.right = node;
		return node;
	}

}
