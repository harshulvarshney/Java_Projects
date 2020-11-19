package linkedList;

public class RemoveNthNodeFromLast {

    public Node removeNthFromEnd(Node head, int n) {

        Node temp = new Node(0);
        Node fast = temp, slow = temp;
        temp.next = head;

        for(int i=1; i<=n+1; i++) {
            fast = fast.next;
        }

        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next != null ? slow.next.next : null;

        return temp.next;
    }

    public static void main(String[] args) {
        Node x = new Node(1);
        x.next = new Node(2);
        /*x.next.next = new Node(3);
        x.next.next.next = new Node(4);
        x.next.next.next.next = new Node(5);*/

        Test obj = new Test();
        Node head = obj.removeNthFromEnd(x, 1);
        while(head != null) {
            System.out.print(head.data + "-->");
            head = head.next;
        }
    }
}
