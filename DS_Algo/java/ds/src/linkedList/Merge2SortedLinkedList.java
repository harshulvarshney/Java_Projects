package linkedList;

public class Merge2SortedLinkedList {


    static Node merge(Node n1, Node n2) {
        if(n1 == null)
            return n2;
        if(n2 == null)
            return n1;

        if(n1.data < n2.data) {
            n1.next = merge(n1.next, n2);
            return n1;
        } else {
            n2.next = merge(n1, n2.next);
            return n2;
        }
    }

    public static void main(String[] args) {
        Node n1 = new Node(0);
        n1.next = new Node(3);
        n1.next.next = new Node(4);

        Node n2 = new Node(2);
        n2.next = new Node(4);
        n2.next.next = new Node(7);
        n2.next.next.next = new Node(9);


        print(n1);
        print(n2);

        Node ret = merge(n1, n2);

        print(ret);
    }

    public static void print(Node x) {
        while(x != null) {
            System.out.print(x.data + " -> ");
            x = x.next;
        }
        System.out.println();
    }

}
