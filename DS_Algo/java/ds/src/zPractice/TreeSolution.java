package zPractice;

import tree.BTreePrinter;
import tree.TreeNode;

public class TreeSolution {

    public static void main(String[] args) {
//        TreeNode<Integer> root = BTreeFactory.getBinaryTree();
        TreeNode<Integer> root = new TreeNode<>(3);
        root.left = new TreeNode<>(2);
        /*root.left.right = new TreeNode<>(3);
        root.left.left = new TreeNode<>(1);
        root.left.left.right = new TreeNode<>(3);
        root.left.right.right = new TreeNode<>(4);*/

        BTreePrinter.printNode(root);
        maxDia(root);
        System.out.println(dia);
    }

    static int dia = 0;
    static int maxDia(TreeNode<Integer> root) {
        if(root == null)
            return 0;

        int l = maxDia(root.left);
        int r = maxDia(root.right);

        int t = l+r;
        dia = Math.max(dia, t);
        return 1+Math.max(l, r);
    }

}
