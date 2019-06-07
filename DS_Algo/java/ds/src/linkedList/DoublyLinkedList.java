package linkedList;

/**
 * Required Operations:
 * addAtStart(), addAtEnd(), addAfter(), deleteFromStart(), deleteFromEnd(), elementAt(), print(), 
 * @author harshul.varshney
 *
 */
public class DoublyLinkedList {
	int size = 0;
	DoubleNode head = null;
	DoubleNode tail = null;
	
	public DoubleNode addAtStart(int data) {
		DoubleNode x = new DoubleNode(data);
		if(size == 0) {
			head = x;
			tail = x;
		}
		else {
			x.next = head;
			head.prev = x;
			head = x;
		}
		size++;
		return x;
	}
	
	public DoubleNode addAtEnd(int data) {
		DoubleNode x = new DoubleNode(data);
		if(size == 0) {
			head = x;
			tail = x;
		}
		else {
			tail.next = x;
			x.prev = tail;
			tail = x;
		}
		size++;
		return x;
	}
	
	public DoubleNode addAfter(int data, DoubleNode prevNode){
		if(prevNode == null) {
			return null;
		}
		else if(prevNode == tail) {
			addAtEnd(data);
		}
		else {
			DoubleNode x = new DoubleNode(data);
			DoubleNode next = prevNode.next;
			prevNode.next = x;
			x.prev = prevNode;
			x.next = next;
			next.prev = x;
			size++;
			return x;
		}
		
		
		return null;
	}

}
