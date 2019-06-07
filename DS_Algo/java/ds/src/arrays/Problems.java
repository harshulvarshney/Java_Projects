package arrays;

import java.util.Arrays;

public class Problems {
	
	/**
	 * Check palindrome
	 */
	static boolean checkPalindrom(int n) {
		int divisor = 1;
		while(n/divisor >= 10) {
			divisor *= 10;
		}
		while(n > 0) {
			int start = n/divisor;
			int last = n%10;
			if(start != last)
				return false;
			n = (n%divisor)/10;
			divisor = divisor/100;
		}
		return true;
	}
	
	/**
	 * sort an array of 0, 1 and 2
	 */
	static void sortArrayOfZeroOneAndTwo(int[] a) {
		int s = 0;
		int mid = 0;
		int e = a.length-1;
		
		while(mid <= e) {
			if(a[mid] == 0) {
				int t = a[mid];
				a[mid] = a[s];
				a[s] = t;
				mid++; s++;
			} else if(a[mid] == 1) {
				mid++;
			} else if(a[mid] == 2) {
				int t = a[mid];
				a[mid] = a[e];
				a[e] = t;
				e--;
			}
		}
		System.out.println(Arrays.toString(a));
	}
	
	public static void main(String[] args) {
		int [] a = {1,0,2,2,2,1,0,0,1,2,0,1};
		System.out.println(checkPalindrom(14341));
	}

}
