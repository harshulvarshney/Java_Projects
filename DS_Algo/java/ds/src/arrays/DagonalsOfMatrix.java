package arrays;

/**
 * Print all the diagonals of a matrix
 * @author harshul.varshney
 *
 */
public class DagonalsOfMatrix {

	public static void main(String[] s) {
		int[][] m = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};

		printDiagonals(m);
	}

	private static void printDiagonals(int[][] a) {
		if(a == null || a.length == 0 || a[0].length == 0)
			return;

		int m = a.length;
		int n = a[0].length;
		int x = 0; int y = 0;
		//loop-1
		for(int i=0; i<n; i++) {
			x = 0;
			y = i;
			while(y >= 0) {
				System.out.print(a[x++][y--]);
			}
			System.out.println();
		}


		//loop-2
		for(int i=1; i<m; i++) {
			x = i;
			y = n-1;
			while(x < m) {
				System.out.print(a[x++][y--]);
			}
			System.out.println();
		}
	}
}
