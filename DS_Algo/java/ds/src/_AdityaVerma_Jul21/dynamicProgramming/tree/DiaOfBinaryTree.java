package _AdityaVerma_Jul21.dynamicProgramming.tree;

import tree.BTreeFactory;
import tree.TreeNode;

/**
 * Given the root of a binary tree, return the length of the diameter of the tree.
 *
 * The diameter of a binary tree is the length of the longest path between any two nodes in a tree. This path may or may not pass through the root.
 *
 * The length of a path between two nodes is represented by the number of edges between them.
 */
public class DiaOfBinaryTree {
    public static void main(String[] args) {
        TreeNode root = BTreeFactory.getBinaryTree();
        System.out.println(maxDepth(root));
        System.out.println(getDia(root));
        height(root);
        System.out.println(dia);
    }

    //below is a modified maxDepth function
    //this will help in getting the final result in 'dis' statis variable
    static int dia = 0;
    static int height(TreeNode root) {
        //base condition
        if(root == null)
            return 0;

        //hypothesis
        int l = height(root.left);
        int r = height(root.right);

        //induction
        dia = Math.max(dia, 1 +l + r);
        return 1 + Math.max(l, r);
    }

    // this wd be (n2) solution because we are calculating the max depth on each node
    // we should use DP here to avoid calculating something which is already done.
    static int getDia(TreeNode root) {
        if(root == null)
            return 0;

        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        int diaFromRoot = 1 + l + r;

        return Math.max(diaFromRoot, Math.max(getDia(root.left), getDia(root.right)));
    }

    static int maxDepth(TreeNode root) {
        if(root == null)
            return 0;

        int l = maxDepth(root.left);
        int r = maxDepth(root.right);

        return 1 + Math.max(l, r);
    }
}
