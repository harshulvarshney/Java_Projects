package sorting;

import java.util.Arrays;

public class Solution {
	
	public static void main(String[] args) {
		int[] a = {9,8,-1,3,2,1,99};
		sortArray(a, 0, a.length-1);
		System.out.println(Arrays.toString(a));
	}
	
	static void sortArray(int[] a, int low, int high) {
		//merge sort
		if(low < high) {
			int mid = low + (high-low)/2;
			sortArray(a, low, mid);
			sortArray(a, mid+1, high);
			merge(a, low, mid, high);
		}
	}

	private static void merge(int[] a, int low, int mid, int high) {
		//get length of 2 sub arrays
		int l1 = mid-low+1;
		int l2 = high-mid;
		
		//initialize 2 arrays
		int[] L1 = new int[l1];
		int[] L2 = new int[l2];
		
		//fill arrays
		for(int i = 0; i < l1; i++)
			L1[i] = a[low+i];
		
		for(int i = 0; i < l2; i++) {
			L2[i] = a[mid+1+i];
		}
		
		int k=low;
		int i=0, j=0;
		while(i < l1 && j < l2) {
			if(L1[i] <= L2[j]) {
				a[k] = L1[i];
				i++;
			}
			else {
				a[k] = L2[j];
				j++;
			}
			k++;
		}
		
		while(i < l1) {
			a[k++] = L1[i++];
		}
		while(j < l2) {
			a[k++] = L2[j++];
		}
	}

}
