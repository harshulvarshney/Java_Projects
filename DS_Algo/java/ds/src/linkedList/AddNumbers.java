package linkedList;

/**
 * Add 2 numbers present in the form of linked list, like
 * 1 -> 0 -> 0 -> 7 & 9 -> 3
 * 
 * output should be 1 -> 1 -> 0 -> 0
 * 
 * @author harshul.varshney
 *
 */
public class AddNumbers {
	
	private Node newHead = null;
	private int carry = 0;
	public Node add(Node head1, Node head2) {
		int size1 = 0;
		int size2 = 0;
		
		Node curr1 = head1;
		Node curr2 = head2;
		while(curr1 != null) {
			size1++;
			curr1 = curr1.next;
		}
		
		while(curr2 != null) {
			size2++;
			curr2 = curr2.next;
		}
		
		if(size1 > size2) {
			int nodesToAdd = size1-size2;
			while(nodesToAdd > 0) {
				Node x = new Node(0);
				x.next = head2;
				head2 = x;
				nodesToAdd--;
			}
		}
		else if(size2 > size1) {
			int nodesToAdd = size2-size1;
			while(nodesToAdd > 0) {
				Node x = new Node(0);
				x.next = head1;
				head1 = x;
				nodesToAdd--;
			}
		}
		Node newHead = null;
		newHead = addrecursively(head1, head2);
		return newHead;
	}
	
	private Node addrecursively(Node head1, Node head2) {
		
		if(head1 == null) {
			return null;
		}
		
		addrecursively(head1.next, head2.next);
		
		int sum =  head1.data + head2.data + carry;
		
		if(sum > 9) {
			Node x = new Node(0);
			x.next = newHead;
			newHead = x;
			carry =  1;
		}
		else{
			Node x = new Node(sum);
			x.next = newHead;
			newHead = x;
			carry =  0;
		}
		return newHead;
	}
	
	public static void main(String[] args) {
		Node x = new Node(1);
		x.next = new Node(0);
		x.next.next = new Node(0);
		x.next.next.next = new Node(7);
		
		Node y = new Node(9);
		y.next = new Node(3);
		
		AddNumbers obj = new AddNumbers();
		print(obj.add(x, y));
	}
	
	public static void print(Node x) {
		while(x != null) {
			System.out.print(x.data + " -> ");
			x = x.next;
		}
	}

}
