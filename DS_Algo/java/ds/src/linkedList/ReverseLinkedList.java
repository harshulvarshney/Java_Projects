package linkedList;

import java.util.Stack;

public class ReverseLinkedList {

	Node prev;
	Node next;
	/**
	 * In this method 2 pointers - next & prev are used.
	 * we access every node one by one and move both pointers
	 * in the end we assign prev to head/curr
	 */
	private Node reverserWithPointers(Node curr) {
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		curr = prev;
		return curr;
	}
	
	public static Node head;
	private Node reverseRecursive(Node curr) {
		if(curr == null) {
			return null;
		}
		if(curr.next == null) {
			head = curr;
			return null;
		}
		reverseRecursive(curr.next);
		curr.next.next = curr;
		curr.next = null;
		return head;
	}
	
	public static void main(String[] args) {
		Node x = new Node(1);
		x.next = new Node(0);
		x.next.next = new Node(0);
		x.next.next.next = new Node(7);
		
		print(x);
		ReverseLinkedList obj = new ReverseLinkedList();
		head = x;
		Node y = obj.reverseRecursive(head);
		System.out.println();
		print(y);
	}
	
	public static void print(Node x) {
		while(x != null) {
			System.out.print(x.data + " -> ");
			x = x.next;
		}
	}

}
