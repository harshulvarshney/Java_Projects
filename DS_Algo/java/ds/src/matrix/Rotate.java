package matrix;

import java.util.Arrays;

public class Rotate {
	
	private void rotate90(int[][] matrix) {
		int l = matrix.length-1;
		
		for(int i = 0; i <= l/2; i++) {
			for(int j = i; j < l-i; j++) {
				int a = matrix[i][j];
				int b = matrix[j][l-i];
				int c = matrix[l-i][l-j];
				int d = matrix[l-j][i];
				
				matrix[i][j] = d;
				matrix[j][l-i] = a;
				matrix[l-i][l-j] = b;
				matrix[l-j][i] = c;
			}
		}
		System.out.println(Arrays.deepToString(matrix));
	}
	
	private void rotate180(int[][] matrix) {
		int l = matrix.length-1;
		
		for(int i = 0; i <= l/2; i++) {
			for(int j = i; j < l-i; j++) {
				int a = matrix[i][j];
				int b = matrix[j][l-i];
				int c = matrix[l-i][l-j];
				int d = matrix[l-j][i];
				
				matrix[i][j] = c;
				matrix[j][l-i] = d;
				matrix[l-i][l-j] = a;
				matrix[l-j][i] = b;
			}
		}
		System.out.println(Arrays.deepToString(matrix));
	}
	
	private void printSpiral() {
		
	}
	
	public static void main(String[] args) {
		int[][] m = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		System.out.println(Arrays.deepToString(m));
		System.out.println("----------------");
		Rotate o = new Rotate();
		o.rotate180(m);
	}

}
