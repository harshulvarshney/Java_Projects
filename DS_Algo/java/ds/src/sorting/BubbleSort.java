package sorting;

import java.util.Arrays;

/**
 * Bubble Sort is the simplest sorting algorithm that works by repeatedly swapping the adjacent elements 
 * if they are in wrong order.
 * 
 * Average and Worst case complexity = O(n2)
 * 
 * Advantage: it can detect an already sorted array in O(n) time
 * 
 * @author harshul
 *
 */
public class BubbleSort {
	
	public static void main(String[]s) {
		int[] a = {7,3,2,5,4,1,6, -1,9, 1};

		System.out.println(Arrays.toString(a));
	}
	
	static void bubbleSort(int[] a) {
		boolean swaped = true;
		for(int i = 0; i < a.length && swaped; i++) {
			swaped = false;
			for(int j = 0; j < a.length - i - 1; j++) {
				if(a[j] > a[j+1]) {
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
					swaped = true;
				}
			}
		}
	}
	
	private void sort(int[] a) {
		for(int i = 0; i < a.length; i++) {
			for(int j = 0; j < a.length-i-1; j++) {
				if(a[j] > a[j+1]) {//compare in pairs and swap.
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(a));
	}

}
