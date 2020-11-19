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

	public Node add(Node l1, Node l2) {
		int car = 0;
		Node l3 = null;
		Node curr = null;
		while(l1 != null || l2 != null) {
			int a = l1 != null ? l1.data : 0;
			int b = l2 != null ? l2.data : 0;

			int sum = a + b + car;
			car = 0;
			if(sum > 9) {
				car = 1;
				sum = sum % 10;
			}

			if(l3 == null) {
				l3 = new Node(sum);
				curr = l3;
			} else {
				curr.next = new Node(sum);
				curr = curr.next;
			}

			l1 = l1 != null? l1.next : null;
			l2 = l2 != null ? l2.next : null;
		}

		if(car == 1)
			curr.next = new Node(1);

		return l3;
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
