package linkedList;

import java.util.LinkedList;
import java.util.Queue;

public class Test {

    public Node removeNthFromEnd(Node head, int n) {

        Node t = head;
        int length = 0;
        while(t != null) {
            length++;
            t = t.next;
        }
        System.out.println("length="+length);

        Queue<Node> q = new LinkedList<>();
        int nodeToRemove = length-n+1;
        System.out.println("nodeToRemove="+nodeToRemove);

        int temp = 1;
        while(head != null) {
            if(temp != nodeToRemove) {
                Node newNode = new Node(head.data);
                q.offer(newNode);
            }
            head = head.next;
            temp++;
        }

        head = q.poll();
        t = head;
        while(!q.isEmpty()) {
            t.next = q.poll();
            t = t.next;
        }

        return head;
    }

    public static void main(String[] args) {
        Node x = new Node(1);
        x.next = new Node(2);
        x.next.next = new Node(3);
        x.next.next.next = new Node(4);
        x.next.next.next.next = new Node(5);


        Node y = new Node(1);
        y.next = new Node(2);

        Test obj = new Test();
        obj.removeNthFromEnd(y, 2);
    }

}
