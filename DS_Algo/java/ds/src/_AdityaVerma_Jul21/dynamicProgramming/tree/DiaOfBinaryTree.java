package _AdityaVerma_Jul21.dynamicProgramming.tree;

import tree.BTreeFactory;
import tree.Node;

public class DiaOfBinaryTree {
    public static void main(String[] args) {
        Node root = BTreeFactory.getBinaryTree();
        System.out.println(maxDepth(root));
        System.out.println(getDia(root));
        height(root);
        System.out.println(dia);
    }

    //below is a modified maxDepth function
    //this will help in getting the final result in 'dis' statis variable
    static int dia = 0;
    static int height(Node root) {
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
    static int getDia(Node root) {
        if(root == null)
            return 0;

        int l = maxDepth(root.left);
        int r = maxDepth(root.right);
        int diaFromRoot = 1 + l + r;

        return Math.max(diaFromRoot, Math.max(getDia(root.left), getDia(root.right)));
    }

    static int maxDepth(Node root) {
        if(root == null)
            return 0;

        int l = maxDepth(root.left);
        int r = maxDepth(root.right);

        return 1 + Math.max(l, r);
    }
}
