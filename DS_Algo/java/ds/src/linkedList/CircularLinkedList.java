package linkedList;

/**
 * Required operations:
 * addAtStart(), addAtEnd(), getSize(), deleteAtStart(), print()
 * @author harshul.varshney
 *
 */
public class CircularLinkedList {
	int size = 0;
	Node head = null;
	Node tail = null;
	
	public void addNodeAtStart(int data){
		Node x = new Node(data);
		if(size == 0) {
			head = x;
            tail = x;
            x.next = head;
		}
		else {
			x.next = head;
			head = x;
			tail.next = x;
		}
		size++;
	}
	
	public void addNodeAtEnd(int data){
		Node x = new Node(data);
		if(size == 0) {
			addNodeAtStart(data);
		}
		else {
			tail.next = x;
			x.next = head;
			tail = x;
			size++;
		}
	}
	
	public void deleteNodeFromStart() {
		if (size == 0) {
			System.out.println("\nList is Empty");
		} else {
			head = head.next;
			tail.next = head;
			size--;
		}
	}
	
	public void print(){
		if(size == 0) {
			System.out.println("list is empty");
		}
		else {
			Node curr = head;
			do {
				System.out.print(curr.data+", ");
				curr = curr.next;
			} while(curr.next != null && curr != head);
		}
	}
	
	
}
