package zPractice;

import tree.Node;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class BottomView {
    public static void main(String[] args) {
        Node<Integer> root = new Node(20);
        root.left = new Node(8);
        root.left.left = new Node(5);
        root.left.right = new Node(3);
        root.left.right.left = new Node(10);
        root.left.right.right = new Node(14);
        root.right = new Node(22);
        root.right.right = new Node(25);

        Map<Integer, Integer> map = new HashMap<>();
        solve(root, map, 0);
        System.out.println(map.values());
    }

    static class Tupple {
        Node<Integer> treeNode;
        int depth;
        Tupple(Node n, int d) {
            this.treeNode = n;
            this.depth = d;
        }
    }
    static void solve(Node<Integer> root, Map<Integer, Integer> bv, int d) {
        if(root == null)
            return;

        Queue<Tupple> q = new LinkedList<>();
        q.offer(new Tupple(root, 0));
        q.offer(null);
        while(!q.isEmpty()) {
            Tupple curr = q.poll();
            if(curr != null) {
                bv.put(curr.depth, curr.treeNode.data);
                if(curr.treeNode.left != null)
                    q.offer(new Tupple(curr.treeNode.left, curr.depth-1));
                if(curr.treeNode.right != null)
                    q.offer(new Tupple(curr.treeNode.right, curr.depth+1));
            }
            else {
                if(!q.isEmpty()) {
                    q.offer(null);
                }
            }
        }
    }
}
