package linkedList;

import java.util.LinkedList;

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
		x.next = new Node(2);
		x.next.next = new Node(3);
		x.next.next.next = new Node(4);
		x.next.next.next.next = new Node(5);
		x.next.next.next.next.next = new Node(6);
		x.next.next.next.next.next.next = x.next.next;
		
		//print(x);
		System.out.println();
		/*LinkedList<Node> list = new LinkedList<>();
		
		for(int i = 0 ; i < 8; i++) {
			list.add(new Node(i));
		}*/
		//print(list);
		findLoop(x);
	}
	
	public static void print(Node x) {
		while(x != null) {
			System.out.print(x.data + " -> ");
			x = x.next;
		}
	}
	
	private static void print(LinkedList<Node> list) {
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).data + ", ");
		}
	}

}
