package linkedList;

/**
 * Implementing a stack using linked-list.
 * 
 * Required operations:
	Push() : Insert the element into linked list at the beginning and increase the size of the list. O(1) operation.
	Pop() : Return the element first node from the linked list and move the head pointer to the second node. Decrease the size of the list. O(1) operation.
	getSize(): Return the size of linked list.
	displayStack(): Print the linked list.
 * @author harshul.varshney
 *
 */
public class Stack {
	
	Node head = null;
	int size = 0;
	
	public void push(int data) {
		Node x = new Node(data);
		if(head == null) {
			head = x;
		}
		else {
			x.next = head;
			head = x;
		}
		size++;
	}
	
	public int pop() {
		if(size == 0) {
			return -1;
		}
		else {
			int data = head.data;
			head = head.next;
			size--;
			return data;
		}
	}
	
	public void printStack() {
		Node curr = head;
		while(curr != null) {
			System.out.print(curr.data + ", ");
			curr = curr.next;
		}
	}
	
	public int getSize() {
		return size;
	}

}
