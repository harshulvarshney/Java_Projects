package tree.binarySearchTree;

import linkedList.DoubleNode;

public class Make_a_BST {
	
	static linkedList.Node head;
	static DoubleNode dllHead;
	
	/**
	 * Time complexity: O(n)
     * Space complexity: O(1) : because in DLL we already have 2 pointers at every node
     * so we dont need to create a BST, just rearrange the prev and next nodes of DLL.
	 * @return
	 */
	static DoubleNode prepareBstFromDLL(int n) {
		if(n <= 0) return null;//base cond.
		
		DoubleNode left = prepareBstFromDLL(n/2);
		DoubleNode root = dllHead;
		root.prev = left;
		dllHead = dllHead.next;
		dllHead.next = prepareBstFromDLL(n -(n/2) -1);
		
		return root;
	}
	
	/**
	 * BST is constructed from leaves to root. 
	 * The idea is to insert nodes in BST in the same order as the appear in Linked List, 
	 * so that the tree can be constructed in O(n) time complexity. 
	 * We first count the number of nodes in the given Linked List. Let the count be n. 
	 * After counting nodes, we take left n/2 nodes and recursively construct the left subtree. 
	 * After left subtree is constructed, we allocate memory for root and link the left subtree with root. 
	 * Finally, we recursively construct the right subtree and link it with root.
     * While constructing the BST, we also keep moving the list head pointer to next so that 
     * we have the appropriate pointer in each recursive call.
     * 
     * Time complexity: O(n)
     * Space complexity: O(n)
	 */
	static Node<Integer> prepareBstFromSLL(int n) {
		if(n <= 0) return null;//base case
		
		Node<Integer> left = prepareBstFromSLL( n/2);
		Node<Integer> root = new Node<Integer>(head.data);
		root.left = left;
		head = head.next;
		root.right = prepareBstFromSLL( n - (n/2) -1);
		
		return root;
	}
	
	/**
	 * this algo is same as used for array.
	 */
	static Node<Integer> prepareBstFromSLL(linkedList.Node head, int start, int end) {
		if(head == null) return null;
		int mid = start+(end-start)/2;
		
		Node<Integer> root = new Node<Integer>(getElement(mid, head).data);
		root.left = prepareBstFromSLL(head, start, mid-1);
		root.right = prepareBstFromSLL(head, mid+1, end);
		return root;
	}
	
	/**
	 * Algo:
	 * -find the middle element of sorted array and make it root
	 * -find the middle element of left part of array and make it left child
	 * -find the middle element of right part of array and make it right child
	 */
	static Node<Integer> prepareBstFromSortedArray(int[] arr, int start, int end) {
		if(start > end) return null;//base condition for recursive call
		
		int mid = start + (end-start)/2;
		Node<Integer> root = new Node<Integer>(arr[mid]);
		root.left = prepareBstFromSortedArray(arr, start, mid-1);
		root.right = prepareBstFromSortedArray(arr, mid+1, end);
		
		return root;
	}
	
	public static void main(String[] args) {
		head = getSampleLinkedList();
		Node<Integer> root = prepareBstFromSLL(findLinkedListLength(head));
		BTreePrinter.printNode(root);
	}
	
	
	/***********************helper methods***************************/
	
	static linkedList.Node getSampleLinkedList() {
		linkedList.Node x = new linkedList.Node(1);
		x.next = new linkedList.Node(3);
		x.next.next = new linkedList.Node(5);
		x.next.next.next = new linkedList.Node(7);
		return x;
	}
	
	static int findLinkedListLength(linkedList.Node head) {
		int n = 0;
		if(head == null) return n;
		
		while(head != null) {
			head = head.next;
			n++;
		}
		return n;
	}
	
	static linkedList.Node getElement(int index, linkedList.Node head) {
		while(head != null && index >= 0) {
			head = head.next;
			index--;
		}
		return head;
	}

}
