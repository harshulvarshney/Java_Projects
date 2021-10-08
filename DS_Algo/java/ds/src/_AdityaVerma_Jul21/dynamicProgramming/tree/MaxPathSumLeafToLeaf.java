package _AdityaVerma_Jul21.dynamicProgramming.tree;

import tree.BTreePrinter;
import tree.TreeNode;

/**
 * https://www.youtube.com/watch?v=ArNyupe-XH0&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=50
 */
public class MaxPathSumLeafToLeaf {
    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode(10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(-20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        BTreePrinter.printNode(root);
        maxPathSum(root);
        System.out.println("Result :: " + MAX);
    }

    static int MAX = Integer.MIN_VALUE;
    static int maxPathSum(TreeNode<Integer> root) {
        if(root == null)
            return 0;
        if(root.left == null && root.right == null)//this is important in this case
            return root.val;

        int l = maxPathSum(root.left);
        int r = maxPathSum(root.right);

        MAX = Math.max(MAX, root.val + l + r);
        return root.val + Math.max(l, r);
    }

}
