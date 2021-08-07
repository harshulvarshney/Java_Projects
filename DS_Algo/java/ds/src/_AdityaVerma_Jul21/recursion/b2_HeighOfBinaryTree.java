package _AdityaVerma_Jul21.recursion;

import tree.BTreeFactory;
import tree.Node;

public class b2_HeighOfBinaryTree {

    public static void main(String[] args) {
        Node root = BTreeFactory.getBinaryTree();
        System.out.println(calHeight(root));
    }

    static int calHeight(Node root) {
        if(root == null) {
            return 0;
        }

        int l = calHeight(root.left);
        int r = calHeight(root.right);
        return 1 + Math.max(l, r);
    }
}
