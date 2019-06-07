package sorting;

import java.util.Arrays;

/**
 * Divide and conquer algorithm.
 * worst case time complexity is O(n2) 
 * Average case time complexity is O(nlogn) 
 * 
 * Although it's worst case time complexity is poorer than other sorting algos, 
 * in most practical cases it performs better.
 * 
 * Quick Sort in its general form is an in-place sort (i.e. it doesn’t require any extra storage) 
 * whereas merge sort requires O(N) extra storage.
 * 
 * Most practical implementations of Quick Sort use randomized version, which decreases the possibility
 * of O(n2) in worst case.
 * 
 * MergeSort is preferred over QuickSort for Linked Lists:
 * Unlike arrays, linked list nodes may not be adjacent in memory. Unlike array, in linked list, we can 
 * insert items in the middle in O(1) extra space and O(1) time. Therefore merge operation of merge sort 
 * can be implemented without extra space for linked lists.
 * 
 * https://www.youtube.com/watch?v=COk73cpQbFQ&list=PL2_aWCzGMAwKedT2KfDMB9YA5DgASZb3U&index=7
 * 
 * 
 * @author harshul
 *
 */
public class QuickSort {

	public static void main(String[] args) {
		int[] a = {9,8,-1,3,2,1,99};
		quickSort(a, 0, a.length-1);
		System.out.println(Arrays.toString(a));
	}
	
	static void quickSort(int[] a, int low, int high) {
		if(a == null || a.length == 0)
			return;
		
		if(low >= high)
			return;
		
		int mid = low+(high-low)/2;
		int pivot = a[mid];
		int i = low; int j = high;
		while(i <= j) {
			while(a[i] < pivot)
				i++;
			while(pivot < a[j])
				j--;
			if(i <= j) {
				int t = a[i];
				a[i] = a[j];
				a[j] = t;
				i++;
				j--;
			}
		}
		quickSort(a, low, j);
		quickSort(a, i, high);
	}
}
