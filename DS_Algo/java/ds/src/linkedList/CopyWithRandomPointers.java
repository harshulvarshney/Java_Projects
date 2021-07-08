package linkedList;

/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 */
public class CopyWithRandomPointers {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    static Node deepCopy(Node head) {
        Node temp = head;
        while(temp != null) {
            Node newNode = new Node(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = newNode.next;
        }

        temp = head;
        while(temp != null) {
            temp.next.random = temp.random != null ? temp.random.next : null;
            temp = temp.next.next;
        }

        temp = head;
        Node dummyHead = head.next;
        Node newHead = head.next;
        while(temp != null) {
            temp.next = temp.next.next;
            dummyHead.next = dummyHead.next != null ? dummyHead.next.next : null;
            temp = temp.next;
            dummyHead = dummyHead.next;
        }

        return newHead;
    }

    public static void main(String[] args) {
        Node x = new Node(7);
        x.next = new Node(13);
        x.next.next = new Node(11);
        x.next.next.next = new Node(10);
        x.next.next.next.next = new Node(1);

        x.random = null;
        x.next.random = x;
        x.next.next.random = x.next.next.next.next;
        x.next.next.next.random = x.next.next;
        x.next.next.next.next.random = x;

        print(x);
        System.out.println(x);
        Node dummy = deepCopy(x);
        print(dummy);
        System.out.println(dummy);
    }

    public static void print(Node x) {
        while(x != null) {
            System.out.print(x.val + " -> ");
            x = x.next;
        }
        System.out.println();
    }
}
