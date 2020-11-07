package tree.binaryTree;

import tree.BTreeFactory;
import tree.Node;

public class LCA {

    public static void main(String[] args) {
        Node<Integer> root = BTreeFactory.getBinaryTree();
        Node<Integer> a = new Node<>(3);
        Node<Integer> b = new Node(8);
        Node<Integer> lca = findLca(root, a, b);
        System.out.println("LCA >> " + lca.data);
    }

    static Node<Integer> findLca(Node<Integer> root, Node<Integer> a, Node<Integer> b) {
        if(root == null || root.data == a.data || root.data == b.data)
            return root;

        Node<Integer> left = findLca(root.left, a, b);
        Node<Integer> right = findLca(root.right, a, b);

        if(left != null && right != null)
            return root;

        return left != null ? left : right;
    }
}
