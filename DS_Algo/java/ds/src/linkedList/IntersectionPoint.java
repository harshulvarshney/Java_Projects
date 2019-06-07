package linkedList;

/**
 * 1 -> 5 -> 2 ->
 * 					7 -> 9 -> 1
 * 			 5 ->
 * Above is an example of intersecting linkedLists, intersection point is Node(7).
 * 
 * Algo:
 * 	1- Join one list end to end
 * 	2- for the second list, fine the node at which loop starts.
 * 
 * @author harshul.varshney
 *
 */
public class IntersectionPoint {
	
	private Node findJoint(Node head1, Node head2) {
		if(head1 == null || head2 == null) {
			return null;
		}
		Node curr1 = head1;
		while(curr1 != null && curr1.next != null) {
			curr1 = curr1.next;
		}
		curr1.next = head1;
		
		//below is how to find the Node at which loop start.
		Node ptr1 = head2;
		Node ptr2 = head2;
		//start 2 pointers, s.t. speed of ptr2 = 2xspeed of ptr1
		//when 2 pointers meet,break and set ptr2 to head
		while(true) {
			ptr1 = ptr1.next;
			ptr2 = ptr2.next.next;
			if(ptr1 == ptr2) {
				ptr2 = head2;
				break;
			}
		}
		//again start both pointers, this time with same speed
		//the point at which pointers meet this time is the required Node.
		while(true) {
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
			if(ptr1 == ptr2) {
				ptr2 = head2;
				break;
			}
		}
		return new Node(ptr1.data);
	}
	
	public static void main(String[] args) {
		Node x = new Node(1);
		x.next = new Node(0);
		x.next.next = new Node(3);
		x.next.next.next = new Node(7);
		
		Node join = x.next.next;
		
		Node y = new Node(9);
		y.next = x.next.next;
		y.next.next = x.next.next.next;
		
		IntersectionPoint obj = new IntersectionPoint();
		print(obj.findJoint(x, y));
	}
	
	public static void print(Node x) {
		while(x != null) {
			System.out.print(x.data + " -> ");
			x = x.next;
		}
	}

}
