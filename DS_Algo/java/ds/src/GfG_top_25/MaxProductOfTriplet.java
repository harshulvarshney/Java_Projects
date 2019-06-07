package GfG_top_25;

import java.util.Arrays;

/**
 * Given an integer array, find a maximum product of a triplet in array.
 * @author harshul.varshney
 */
public class MaxProductOfTriplet {
	
	public static void main(String[] args) {
		int[] arr = {-10, -3, -5, -6, -20};
		findMaxProduct(arr);
	}
	
	static void findMaxProduct(int [] arr) {
		int n = arr.length;
		int[] temp = Arrays.copyOf(arr, n);
		
		//Sol-1: with sorting | O(nlogn) due to sorting.
		Arrays.sort(arr);
		int m1 = arr[n-1]*arr[n-2]*arr[n-3];
		int m2 = arr[n-1]*arr[0]*arr[1];
		System.out.println("Sol-1: max: " + (m1 > m2 ? m1 : m2));
		
		//Sol-2: without sorting | O(n) time
		Integer max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE, min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
		for(int i : temp) {
			if(i > max1) {
				max3 = max2;
				max2 = max1;
				max1 = i;
			}
			else if(i > max2) {
				max3 = max2;
				max2 = i;
			}
			else if(i > max3) {
				max3 = i;
			}
			
			if(i < min1) {
				min2 = min1;
				min1 = i;
			}
			else if(i < min2) {
				min2 = i; 
			}
		}
		m1 = max1*max2*max3;
		m2 = max1*min1*min2;
		System.out.println("Sol-2: max: " + (m1 > m2 ? m1 : m2));
	}

}
