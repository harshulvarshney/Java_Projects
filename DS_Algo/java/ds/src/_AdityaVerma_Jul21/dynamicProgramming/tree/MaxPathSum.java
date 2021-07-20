package _AdityaVerma_Jul21.dynamicProgramming.tree;

import tree.BTreePrinter;
import tree.Node;

/**
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */
public class MaxPathSum {
    public static void main(String[] args) {
        Node<Integer> root = new Node(10);
        root.left = new Node(-9);
       /* root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);*/

        BTreePrinter.printNode(root);
        maxPathSum(root);
        System.out.println("Result :: " + MAX);
    }

    static int MAX = Integer.MIN_VALUE;
    static int maxPathSum(Node<Integer> root) {
        if(root == null)
            return 0;

        int l = maxPathSum(root.left);
        l = l > 0 ? l : 0;
        int r = maxPathSum(root.right);
        r = r > 0 ? r : 0;

        MAX = Math.max(MAX, root.data + l + r);
        return root.data + (Math.max(l, r) > 0 ? Math.max(l, r) : 0);
    }


}
