package _AdityaVerma_Jul21.recursion;

import tree.BTreeFactory;
import tree.TreeNode;

public class b2_HeighOfBinaryTree {

    public static void main(String[] args) {
        TreeNode root = BTreeFactory.getBinaryTree();
        System.out.println(calHeight(root));
    }

    static int calHeight(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int l = calHeight(root.left);
        int r = calHeight(root.right);
        return 1 + Math.max(l, r);
    }
}
