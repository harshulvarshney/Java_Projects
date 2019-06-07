package arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Q1)
 * Given  integers, count the number of pairs of integers whose difference is .
   Input Format
		The first line contains N and K
		The second line contains  numbers of the set. All the  numbers are unique.
		
 * Q2)
 * Write an algo­rithm to find out whether in a given array there exists or not 
 * two num­bers whose sum is exactly equals to a given num­ber.
 * Out­put: True or false based upon we have found any two num­bers in array arrA[] whose sum is equal to k
 * 
 * @author harshul
 *
 */
public class FindPair {
	
	public static void main(String[] args) {
		Scanner in  = new Scanner(System.in);
		String l1 = in.nextLine();
		String l2 = in.nextLine();
		
		String[] l1Arr = l1.split(" ");
		String[] l2Arr = l2.split(" ");
		int n = Integer.parseInt(l1Arr[0]);
		int k = Integer.parseInt(l1Arr[1]);
		int[] a = new int[n];
		for(int i = 0; i<n; i++) {
			a[i] = Integer.parseInt(l2Arr[i]);
		}
		in.close();
		System.out.println(findWithDiff2(a, k));
	}

/****************************************Problem-1************************************************/
	private static int findWithDiff(int[] arr, int k) {
		Arrays.sort(arr);
		int i=0, j=1, count=0;
		while(j < arr.length) {
			int t = arr[j] - arr[i];
			if(t == k) {
				count++;
				i++;
				j++;
			}
			else if(t < k)
				j++;
			else if(t > k)
				i++;
		}
		return count;
	}
	
	private static int findWithDiff2(int[] arr, int k) {
		Set<Integer> set = new HashSet<>(0);
		int count = 0;
		for(int i : arr) {
			if(set.contains(i+k))
				count++;
			if(set.contains(i-k))
				count++;
			set.add(i);
		}
		return count;
	}

	/****************************************Problem-2************************************************/

}
