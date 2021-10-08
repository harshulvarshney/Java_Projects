package tree.lca;

import tree.BTreeFactory;
import tree.TreeNode;

/**
 * finding LCA in 2 node tree can be done by:
 *      Tarjan's offline LCA algo               : for
 *      Binary Lifting                          : for binary tree
 *      Eulerian tour + Range Minimum Query     : for n-array tree
 *
 *
 *
 * Time Complexity: O(n)
 */
public class LCA {

    public static void main(String[] args) {
        TreeNode<Integer> root = BTreeFactory.getBinaryTree();
        TreeNode<Integer> a = new TreeNode<>(3);
        TreeNode<Integer> b = new TreeNode(8);
        TreeNode<Integer> lca = findLca(root, a, b);
        System.out.println("LCA >> " + lca.val);
    }

    static TreeNode<Integer> findLca(TreeNode<Integer> root, TreeNode<Integer> a, TreeNode<Integer> b) {
        if(root == null || root.val == a.val || root.val == b.val)
            return root;

        TreeNode<Integer> left = findLca(root.left, a, b);
        TreeNode<Integer> right = findLca(root.right, a, b);

        if(left != null && right != null)
            return root;

        return left != null ? left : right;
    }
}
