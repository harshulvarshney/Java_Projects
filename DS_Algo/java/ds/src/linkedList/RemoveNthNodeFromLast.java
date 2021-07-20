package linkedList;

public class RemoveNthNodeFromLast {

    public static void main(String[] args) {
        Node x = new Node(1);
        x.next = new Node(2);
        x.next.next = new Node(3);
        x.next.next.next = new Node(4);
        x.next.next.next.next = new Node(5);

        //Test obj = new Test();
        //Node head = obj.removeNthFromEnd(x, 1);
        x = removeNth(x, 2);
        while(x != null) {
            System.out.print(x.data + "-->");
            x = x.next;
        }
    }

    static Node removeNth(Node head, int n) {
        Node p1 = head;
        Node p2 = head;
        while(n-- > 0)
            p2 = p2.next;
        if(p2 == null) {
            return head.next;
        }
        while(p2.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        p1.next = p1.next.next;
        return head;
    }
}
