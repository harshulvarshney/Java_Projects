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
		char[] arr = {'w','z','b','a','c','#'};
		sort(arr);
		int[] arr1 = {2,2,2,2};
		System.out.println(Arrays.toString(sort(arr1)));

		int[] arr2 = {1,-2,0,-2,4,5,-1};
		System.out.println(Arrays.toString(sortArrayWithNegatives(arr2)));
	}
	
	static void sort(char[] arr) {
		int n = arr.length;
		int[] aux = new int[256];//there are 256 characters in ASCII code
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

	/**
	 * input array contains 0, 1s and 2s only
	 */
	static int[] sort(int[] arr) {
		int count0 = 0;
		int count1 = 0;
		//int count2 = 0;
		for(int x: arr) {
			if(x == 0)
				count0++;
			else if(x == 1)
				count1++;
			/*else
				count2++;*/
		}

		for(int i=0; i<arr.length; i++) {
			if(count0 > 0) {
				arr[i] = 0;
				count0--;
				continue;
			}
			else if(count1 > 0) {
				arr[i] = 1;
				count1--;
				continue;
			}
			else {
				arr[i] = 2;
			}

		}

		return arr;
	}

	/**
	 * when input array contains -ve int
	 */
	static int[] sortArrayWithNegatives(int[] arr) {
		if(arr == null || arr.length == 0)
			return arr;

		int max = Arrays.stream(arr).max().getAsInt();
		int min = Arrays.stream(arr).min().getAsInt();
		int range = max-min+1;
		int n = arr.length;

		int[] count = new int[range];
		int[] op = new int[n];

		for(int i=0; i<n; i++) {
			int index = arr[i]-min;
			++count[index];
		}

		for(int i=1; i<range; i++) {
			count[i] = count[i] + count[i-1];
		}

		for(int i=0; i<n; i++) {
			int index = arr[i]-min;
			op[count[index]-1] = arr[i];
			--count[index];
		}

		return op;
	}
	

}
