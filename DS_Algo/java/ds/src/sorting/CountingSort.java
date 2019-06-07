package sorting;

import java.util.Arrays;

/**
 * Counting sort is a sorting technique based on keys between a specific range
 * 
 * Time Complexity: O(n+k) where n is the number of elements in input array and k is the range of input.
 * Auxiliary Space: O(n+k)
 * 
 * Counting sort is efficient if the range of input data is not significantly greater than the number 
 * of objects to be sorted.
 * 
 * It is not a comparison based sorting. It running time complexity is O(n) with space proportional to the range of data.
 * It is often used as a sub-routine to another sorting algorithm like radix sort.
 * Counting sort uses a partial hashing to count the occurrence of the data object in O(1).
 * Counting sort can be extended to work for negative inputs also.
 * 
 * @author harshul.varshney
 *
 */
public class CountingSort {
	
	public static void main(String[] args) {
		char[] arr = {'w','z','b','a','c'};
		sort(arr);
	}
	
	static void sort(char[] arr) {
		int n = arr.length;
		int[] aux = new int[256];
		char[] op = new char[n];
		
		for(char c : arr) {
			aux[c] = aux[c] + 1;
		}
		
		for(int i = 1 ; i < 256; i++) {
			aux[i] = aux[i] + aux[i-1];
		}
		
		for(int i = 0; i < n ; i ++) {
			op[aux[arr[i]]-1] = arr[i];
			aux[arr[i]] = aux[arr[i]] - 1;
		}
		
		System.out.println(Arrays.toString(op));
	}
	
	

}
