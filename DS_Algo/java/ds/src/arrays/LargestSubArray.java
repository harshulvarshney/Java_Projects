package arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * 1- Find the largest subarray with 0 sum
 * 2- Largest subarray with equal number of 0s and 1s
 * 3- 
 * @author harshul.varshney
 *
 */
public class LargestSubArray {
	
	/**
	 * Use a hasnMap to store the SUM (sum += arr[i]), if sum is present in map i.e.
	 * there is a zero sum array between the previous index of sum and current index(i).
	 */
	static void zeroSum(int [] a) {
		if(a.length == 0) System.out.println(-1);
		
		int sum = 0;
		int minIndex = -1, maxIndex = -1;
		Map<Integer, Integer> m = new HashMap<>();
		
		for(int i = 0; i < a.length; i++) {
			sum = sum+a[i];
			if (a[i] == 0 && maxIndex == -1)
				maxIndex = minIndex = i;
			else if(sum == 0) {
				minIndex = 0;
				maxIndex = i;
			}
			else if(m.containsKey(sum)) {
				if(i-m.get(sum) > (maxIndex-minIndex)) {
					minIndex = m.get(sum);
					maxIndex = i;
				}
			}
			else {
				m.put(sum, i);
			}
		}
		System.out.println("Max array with zero sum: " + minIndex + " : " + maxIndex);
	}
	
	static void maxArrayWithEqOneAndZero(int[] a) {
		for(int i = 0; i < a.length; i++) {
			if(a[i] == 0)
				a[i] = -1;
		}
		zeroSum(a);
	}
	
	public static void main(String[] args) {
		int[] a = {1, 0, 1, 1, 1, 0, 0};
		find(a);
	}
	
	static void find(int[] a) {
		int sum = 0;
		int minIndex = 0, maxIndex = 0;
		int maxSubArray = -1;
		
		for(int i = 0; i < a.length-1; i++) {
			sum = a[i] == 0 ? -1 : 1;
			for(int j = i+1; i < a.length; j++) {
				int x = a[j] == 0 ? -1 : 1;
				sum += x;
				if(sum == 0 && maxSubArray < (j-i+1)) {
					maxSubArray = j-1+1;
					minIndex = i;
				}
			}
			maxIndex = minIndex+maxSubArray-1;
		}
		
		System.out.println("Max Sub Array length: " + maxSubArray);
	}

}
