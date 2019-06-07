package sorting;

import java.util.Arrays;

/**
 * Time Complexity: O(n2) as there are two nested loops.
 * 
 * The selection sort algorithm sorts an array by repeatedly finding the minimum element 
 * (considering ascending order) from unsorted part and putting it at the beginning. 
 * 
 * The good thing about selection sort is it never makes more than O(n) swaps 
 * and can be useful when memory write is a costly operation.
 * 
 * @author harshul
 *
 */
public class SelectionSort {
	
	public static void main(String[]s) {
		int[] a = {7,3,2,5,4,1,6, -1,9};
		SelectionSort o = new SelectionSort();
		o.sort(a);
	}
	
	private void sort(int[] a) {
		if(a.length == 0)
			return;
		//start loop
		for(int i = 0; i < a.length-1; i++) {
			int min = i;
			//find the min
			for(int j = i+1; j < a.length; j++) {
				if(a[j] < a[min]) {
					min = j;
				}
			}
			//swap
			int temp = a[i];
			a[i] = a[min];
			a[min] = temp;
		}
		
		System.out.println(Arrays.toString(a));
	}

}
