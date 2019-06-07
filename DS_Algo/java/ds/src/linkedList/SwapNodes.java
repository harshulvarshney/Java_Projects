package linkedList;

import java.util.LinkedList;

public class SwapNodes {
	
	public static void main(String[] args) {
		LinkedList<Node> list = new LinkedList<>();
		LinkedList<Node> newList = new LinkedList<>();
		
		for(int i = 0 ; i < 7; i++) {
			list.add(new Node(i));
		}
		print(list);
		System.out.println();
		swapListElementsInGroup(2, list);
	}
	
	private static void swapListElementsInGroup(int grpSize, LinkedList<Node> list) {
		LinkedList<Node> newList = new LinkedList<>();
		Stack2 s = new Stack2();
		while(list.size() >= grpSize) {
			for(int i = 0; i < grpSize; i++) {
				s.push(list.getFirst());
				list.removeFirst();
			}
			while(s.size != 0) {
				newList.addLast(s.pop());
			}
		}
		print(newList);
	}
	
	private static void print(LinkedList<Node> list) {
		for(int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).data + ", ");
		}
	}

}

class Stack2 {
	int size = 0;
	Node head;
	public void push(Node node) {
		if(size == 0) {
			head = node;
		}
		else {
			node.next = head;
			head = node;
		}
		size++;
	}
	
	public Node pop() {
		if(size == 0) {
			return null;
		}
		else {
			Node temp = head;
			head = head.next;
			size--;
			return temp;
		}
	}
}
