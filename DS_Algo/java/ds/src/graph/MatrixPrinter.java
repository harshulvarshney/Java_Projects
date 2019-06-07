package graph;

import java.util.Arrays;

public class MatrixPrinter {

	public static void print(char[][] m) {
		for (char[] row : m)
			System.out.println(Arrays.toString(row));
	}

	public static void print(int[][] m) {
		for (int[] row : m)
			System.out.println(Arrays.toString(row));
	}

}
