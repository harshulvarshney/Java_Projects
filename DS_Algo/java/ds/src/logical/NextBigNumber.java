package logical;

import java.util.Arrays;

/**
 * Find next big number from the same digits in a given number.
 * given: 135794
 * next : 135947
 * next : 135974
 * next : 137459
 * next : 137495
 * 
 * @author harshul.varshney
 *
 * idea is to start comparing digits from right to left and find next smaller digit.
 * take 2 pointers i and j s.t i=array.length-1 and j=array.length-2
 * decrement j and i s.t. j - i is never > 1
 * when array[j] < array[i], swap the digits and sort the digits after j+1.
 */
public class NextBigNumber {
	
	static void next(int n) {
		int l = (int)Math.log10(n) + 1;
		int[] a = new int[l];
		int d = (int) Math.pow(10, (l-1));
		for(int i = 0; i < l; i++) {
			a[i] = n/d;
			n = n%d;
			d = d/10;
		}
		System.out.println(Arrays.toString(a));
		
		int i = l-1;
		int j = l-2;
		while(!compareAndSwap(a, i, j)) {
			if(j-i == 1) j--;
			else i--;
		}
	}
	
	static boolean compareAndSwap(int[] a, int i, int j) {
		if(a[j] < a[i]) {
			int temp = a[i];
			a[i] = a[j];
			a[j] = temp;
			Arrays.sort(a, j-1, a.length-1);
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		next(135794);
	}

}
