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
		int[] a = {9,8,-1,3,2,1,99,0,5,7,-2,0};

		// 1- original quick sort algo
		//quickSort(a, 0, a.length-1);
		quickSort(a, 0, a.length-1);
		System.out.println(Arrays.toString(a));

		// 2- sort an array containing 0, 1s and 2s
		int[] arr = {2,0,1,0,0,1,1,1,0};
		sort0_1_2(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void sort(int[] arr, int low, int high) {
		if(arr == null || arr.length == 0 || low >= high)
			return;

		int i = low;
		int j = high;
		int pivot = arr[low + (high-low)/2];
		while(i < j) {
			while(arr[i] < pivot)
				i++;
			while(pivot < arr[j])
				j--;
			if(i < j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}

		sort(arr, low, i-1);
		sort(arr, j+1, high);
	}
	public static void quickSort(int[] arr, int low, int high) {
		if(arr == null || arr.length == 0 || low >= high)
			return;

		int i = low;
		int j = high;
		int mid = low + (high - low)/2;
		int p = arr[mid];
		while(i < j) {
			while(arr[i] < p)
				i++;

			while(p < arr[j])
				j--;

			if(i < j) {
				int t = arr[i];
				arr[i] = arr[j];
				arr[j] = t;
				i++;
				j--;
			}
		}

		sort(arr, low, i-1);
		sort(arr, j, high);
	}


	private static void sort0_1_2(int [] a) {
		int lo = 0;
		int hi = a.length-1;
		int index = 0;

		while(index <= hi) {
			switch (a[index]) {
				case 0:
					int t = a[lo];
					a[lo] = a[index];
					a[index] = t;
					lo++;
					index++;
					break;
				case 1:
					index++;
					break;
				case 2:
					int y = a[hi];
					a[hi] = a[index];
					a[index] = y;
					hi--;
					break;
			}
		}
	}


}
