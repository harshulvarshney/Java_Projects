package tree;

/**
 * 
 * @author harshul.varshney
 * @since Jun 29, 2016
 */
public class Node<T extends Comparable<?>> {
    public Node<T> left, right, next;
    public T data;
    public boolean rightThread;
    public Node<T> rightSibling;

    public Node(T data) {
        this.data = data;
    }
}
