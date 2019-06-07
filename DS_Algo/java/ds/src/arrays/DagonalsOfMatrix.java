package arrays;

/**
 * Print all the diagonals of a matrix
 * @author harshul.varshney
 *
 */
public class DagonalsOfMatrix {

	private int[][] m = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
	public static void main(String[] s) {
		DagonalsOfMatrix obj = new DagonalsOfMatrix();
		System.out.println();
		
		int len = obj.m.length;
		obj.diagonals(len, obj.m);
		s[0].intern();
	}
	
	
	private void diagonals(int index, int[][] m) {
		int r = 0;
		while(r < index) {
			int j = r;
			for(int i =0; i<=r ; i++) {
				System.out.print(m[i][j] + " ");
				j--;
			}
			System.out.println();
			r++;
		}
		
		r = 1;
		while(r < index) {
			int j = index-1;
			for(int i = r; i < index ; i++) {
				System.out.print(m[r][j] + " ");
				j--;
			}
			System.out.println();
			r++;
		}
	}
}
