package tree.binarySearchTree;

import java.util.Deque;
import java.util.LinkedList;

public class Problems {
	
	/**
	 * Check if a given array can represent pre-order Traversal of Binary Search Tree
	 */
	static boolean preOrder(int [] a) {
		Integer root = Integer.MIN_VALUE;
		Deque<Integer> s = new LinkedList<>();
		
		for(int i=0; i < a.length; i++) {
			if(a[i] < root)
				return false;
			//this solution is same as finding the next big element in an array.
			while(!s.isEmpty()) {
				if(a[i] > a[s.peek()])
					root = a[s.pop()];
				else
					break;
			}
			s.push(i);
		}
		
		return true;
	}
	
	public static void main(String[] args) {
		int[] a = {2,4,3};
		
		System.out.println(preOrder(a));
	}

}
