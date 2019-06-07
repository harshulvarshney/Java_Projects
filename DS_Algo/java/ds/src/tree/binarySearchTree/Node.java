package tree.binarySearchTree;

/**
 * 
 * @author harshul.varshney
 * @since Jun 29, 2016
 */
class Node<T extends Comparable<?>> {
    Node<T> left, right;
    T data;

    public Node(T data) {
        this.data = data;
    }
}
