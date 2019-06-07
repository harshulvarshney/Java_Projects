package matrix;

import java.util.Arrays;

public class BinarySearch {

	public static void main(String[] args) {
		int[][] m = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		System.out.println(Arrays.deepToString(m));
		System.out.println("----------------");
		System.out.println(find(m, 0));
	}
	
	static boolean find(int[][] m, int k) {
		
		if(m == null || m.length == 0 || m[0].length == 0)
			return false;
		
		int r = m.length;
		int c = m[0].length;
		
		int start = 0;
		int end = r*c-1;
		
		while(start <= end) {
			int mid = start + (end-start)/2;
			int midX = mid/c;//remember this
			int midY = mid%c;//remember this
			if(k == m[midX][midY])
				return true;
			else if(k > m[midX][midY])
				start=mid+1;
			else if(k < m[midX][midY])
				end=mid-1;
		}
		
		return false;
	}
	
}
