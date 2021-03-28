package linkedList;

public class App {
	
	static void findLoop(Node s) {
		Node ptr1 = s;
		Node ptr2 = s;
		boolean found = false;
		while(!found) {
			ptr1 = ptr1.next;
			ptr2 = ptr2.next.next;
			if(ptr1.data == ptr2.data)
				found = true;
		}
		System.out.println("there is a loop");
		ptr1 = s;
		while(ptr1.data != ptr2.data) {
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		}
		System.out.println("Loop starts at: " + ptr1.data);
	}
	
	public static void main(String[] args) {
		Node x = new Node(1);
		x.next = new Node(3);
		x.next.next = new Node(4);
		x.next.next.next = new Node(9);

//		print(x);

		Node y = new Node(2);
		y.next = new Node(3);
		y.next.next = new Node(8);

		//print(y);

	}
	
	public static void print(Node x) {
		while(x != null) {
			System.out.print(x.data + " -> ");
			x = x.next;
		}
		System.out.println();
	}
	
	static Node reverse(Node curr) {
		Node prev = null;
		Node next = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

}
