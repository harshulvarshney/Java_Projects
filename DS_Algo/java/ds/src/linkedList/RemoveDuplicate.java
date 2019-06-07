package linkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * Remove duplicate elements from LinkedList, ex: 1 -> 0 -> 0 -> 7 -> 1 
 * output: 1 -> 0 -> 7 
 * 
 * A 2 pointer approach is user for this solution.
 * Algo:
 * 	1- define a set, define 2 pointers, prev and curr
 * 	2- add head.data to set
 * 	3- assign head to prev and assign head.next to curr
 * 	4- loop over linkedList, until curr is null
 * 	5- if curr.data is found in ser, delete the node, else add data to set and move on.
 * 
 * @author harshul.varshney
 *
 */
public class RemoveDuplicate {
	private Set<Integer> set = new HashSet<>();
	Node prev;
	Node curr;
	private Node remDuplicate(Node head) {
		if(head == null) 
			return null;
		set.add(head.data);
		prev = head;
		curr = head.next;
		while(curr != null) {
			if(set.contains(curr.data)) {
				prev.next = curr.next;
				Node temp = curr;
				curr = curr.next;
				temp.next = null;
			}
			else {
				set.add(curr.data);
				prev = curr;
				curr = curr.next;
			}
		}
		return head;
	}
	
	public static void main(String[] args) {
		Node x = new Node(1);
		x.next = new Node(0);
		x.next.next = new Node(0);
		x.next.next.next = new Node(7);
		x.next.next.next.next = new Node(7);
		
		print(x);
		System.out.println();
		RemoveDuplicate obj = new RemoveDuplicate();
		print(obj.remDuplicate(x));
	}
	
	public static void print(Node x) {
		while(x != null) {
			System.out.print(x.data + " -> ");
			x = x.next;
		}
	}

}
