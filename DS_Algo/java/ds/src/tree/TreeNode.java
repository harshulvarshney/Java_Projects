package tree;

/**
 * 
 * @author harshul.varshney
 * @since Jun 29, 2016
 */
public class TreeNode<T extends Comparable<?>> {
    public TreeNode<T> left, right, next;
    public T val;
    public boolean rightThread;
    public TreeNode<T> rightSibling;

    public TreeNode(T val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return val +"";
    }


}
