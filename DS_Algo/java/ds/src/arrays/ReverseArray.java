package arrays;

import java.util.Arrays;

public class ReverseArray {
	
	private static int[] x;
	public static void main(String [] s) {
		x = new int[]{1,2,3,4};
		System.out.println(Arrays.toString(x));
		ReverseArray obj = new ReverseArray();
		obj.reverse(0, x.length-1);
		System.out.println(Arrays.toString(x));
	}
	
	private void reverse(int start, int end) {
		if(start <= end) {
			int temp = x[start];
			x[start] = x[end];
			x[end] = temp;
			start++;
			end--;
			reverse(start, end);
		}
	}

}
