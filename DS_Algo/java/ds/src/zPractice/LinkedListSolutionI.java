package zPractice;

import linkedList.Node;

public class LinkedListSolutionI {

    public static void main(String[] args) {
        Node x = new Node(1);
        x.next = new Node(2);
        x.next.next = new Node(3);
        x.next.next.next = new Node(7);
        x.next.next.next.next = new Node(5);

        print(x);
        Node newHead = revInPair(x);
        System.out.println();
        print(newHead);
    }

    static void print(Node head){
        while(head != null) {
            System.out.print(head.data + "->");
            head = head.next;
        }
        System.out.println();
    }

    static Node revInPair(Node head) {
        if(head == null || head.next == null)
            return head;

        Node next = revInPair(head.next.next);
        Node temp = head.next;
        head.next = next;
        temp.next = head;
        return temp;

    }

    static Node reverse(Node head) {
        if(head == null || head.next == null)
            return head;

        Node last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

}
