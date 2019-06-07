package cracking_the_conding_int;

/**
 * Given an image represented by an NxN matrix, where each pixel in the image is 4 bytes, 
 * write a method to rotate the image by 90 degrees. Can you do this in place
 * 
 * Note: this solution will work for NxN matrinx only, for NxM matrix, we will need some
 * padding, i.e. if M < N, add (M-N) columns on right
 * else if N < M, add (M-N) rows below.
 * 
 * @author harshul.varshney
 */
public class RotateImage {
	
	public static void main(String[] args) {
		int[][] board = new int[4][4]; 
		int i = 0;
		// let's loop through array to populate board 
		for (int row = 0; row < board.length; row++) { 
			for (int col = 0; col < board[row].length; col++) { 
				board[row][col] = i++; 
			}
		}
		solution1(board);
	}
	
	/**
	 * On rotation: column value of a cell will become it's row value in new matrix
	 * and it's column value in new matrix will be noOfCols - oldRowValue.
	 * 
	 * @param matrix
	 */
	private static void solution1(int[][] matrix) {
		printMatrix(matrix);
		int[][] rotatedMatrix = new int[matrix.length][matrix[0].length];
		int maxCol = matrix.length - 1;
		
		int p, k = 0;
		for(int i = 0; i < matrix.length; i++) {
			for(int j = 0; j < matrix[0].length; j++) {
				p = j;
				k = maxCol - i;
				rotatedMatrix[p][k] = matrix[i][j];
			}
		}
				
		
		printMatrix(rotatedMatrix);
	}
	
	private static void printMatrix(int[][] board) {
		System.out.println();
		for (int row = 0; row < board.length; row++) { 
			for (int col = 0; col < board[row].length; col++) { 
				System.out.print(board[row][col] + "\t"); 
			} 
			System.out.println(); 
		}
	}

}
