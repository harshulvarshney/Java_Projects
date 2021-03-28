package linkedList;

public class ReverseLinkedList {

	private static Node prev;
	private static Node next;
	/**
	 * In this method 2 pointers - next & prev are used.
	 * we access every node one by one and move both pointers
	 * in the end we assign prev to head/curr
	 */
	public static Node reverse(Node head) {
		if(head == null || head.next == null)
			return head;

		while(head.next != null) {
			next = head.next;
			head.next = prev;
			prev = head;
			head = next;
		}

		head.next = prev;
		return head;
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
		x.next = new Node(2);
		x.next.next = new Node(3);
		x.next.next.next = new Node(7);
		
		print(x);
		Node newHead = reverse(x);
		System.out.println();
		print(newHead);
	}
	
	public static void print(Node x) {
		while(x != null) {
			System.out.print(x.data + " -> ");
			x = x.next;
		}
	}

}
