package _AdityaVerma_Jul21.dynamicProgramming.tree;

import tree.BTreePrinter;
import tree.Node;

/**
 * https://www.youtube.com/watch?v=ArNyupe-XH0&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=50
 */
public class MaxPathSumLeafToLeaf {
    public static void main(String[] args) {
        Node<Integer> root = new Node(10);
        root.left = new Node(9);
        root.right = new Node(-20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        BTreePrinter.printNode(root);
        maxPathSum(root);
        System.out.println("Result :: " + MAX);
    }

    static int MAX = Integer.MIN_VALUE;
    static int maxPathSum(Node<Integer> root) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)//this is important in this case
            return root.data;

        int l = maxPathSum(root.left);
        int r = maxPathSum(root.right);

        MAX = Math.max(MAX, root.data + l + r);
        return root.data + Math.max(l, r);
    }

}
