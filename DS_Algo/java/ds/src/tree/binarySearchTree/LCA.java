package tree.binarySearchTree;

public class LCA {

    public static void main(String[] args) {
        Node<Integer> root = BTreeFactory.getBinarySearchTree();
        Node<Integer> a = new Node<>(10);
        Node<Integer> b = new Node<>(1);
        Node<Integer> lca = findLca(root, a, b);
        System.out.println("LCA >> " + lca.data);
    }

    static Node<Integer> findLca(Node<Integer> root, Node<Integer> a, Node<Integer> b) {
        if(root == null || root.data == a.data || root.data == b.data)
            return root;

        if(root.data > a.data && root.data < b.data)
            return root;
        else if(root.data < a.data && root.data > b.data)
            return root;

        if(root.data < Math.min(a.data, b.data))
            return findLca(root.right, a, b);
        return findLca(root.left, a, b);
    }


}
