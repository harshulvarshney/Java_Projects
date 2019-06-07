package arrays;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Find intersection point, given that both arrays are sorted.
 * 
 * @author harshul.varshney
 *
 */
public class IntersectionPoint {
	
	public static void main(String[] s) {
		int[] a = { 1, 2, 3, 6, 8, 10, 20 };
		int[] b = { 0, 4, 5, 11, 15, 20 };
		IntersectionPoint o = new IntersectionPoint();
		System.out.println(o.find(a, b));
	}
	
	private int find(int[]a, int[]b) {
		int lenA = a.length;
		int lenB = b.length;
		int r = Math.max(lenA, lenB);
		
		int i = 0,j = 0;
		while(i < lenA && j < lenB) {
			if(a[i] == b[j]) {
				return a[i];
			}
			else if (a[i] > b[j]) {
				j++;
			}
			else {
				i++;
			}
		}
		
		
		return 0;
	}

}
