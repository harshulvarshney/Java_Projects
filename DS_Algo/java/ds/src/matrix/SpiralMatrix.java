package matrix;

import java.util.Arrays;

public class SpiralMatrix {
	
	static void printSpiral(int[][] m) {
		int r = m.length;
		int c = m[0].length;
		
		int top=0;
		int bottom = r-1;
		int left = 0;
		int right = c-1;
		
		while(top < bottom) {
			for(int i = left; i <= right; i++)
				System.out.print(m[top][i] + " | ");
			top++;
			
			for(int i = top; i <= bottom; i++)
				System.out.print(m[i][right] + " | ");
			right--;
			
			for(int i = right; i >=left; i--)
				System.out.print(m[bottom][i] + " | ");
			bottom--;
			
			for(int i = bottom; i >=top ;i--)
				System.out.print(m[i][left] + " | ");
			left++;
		}
	}
	
	public static void main(String[] args) {
		int[][] m = {{1,2,3,4},{12,13,14,5},{11,16,15,6},{10,9,8,7}};
		System.out.println(Arrays.deepToString(m));
		System.out.println("----------------");
		printSpiral(m);
	}

}
