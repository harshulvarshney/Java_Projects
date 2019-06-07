package graph;

/**
 * The basic idea of the following solution is merging adjacent lands, 
 * and the merging should be done recursively.
 *
 */
public class CountOfIselands {
	
	private int getCountOfIselands(char[][] m) {
		int count = 0;
		
		if(m != null && m.length > 0 && m[0].length > 0) {
			int r = m.length;
			int c = m[0].length;
			
			for(int i = 0; i < r; i++) {
				for(int j = 0; j < c; j++) {
					if(m[i][j] == '1') {
						count++;
						merge(m, i, j);
					}
				}
			}
		}
		return count;
	}
	
	private void merge(char[][] m, int i, int j) {
		int r = m.length;
		int c = m[0].length;
		if(i < 0 || i >= r || j < 0 || j >= c || m[i][j] != '1')
			return;
		
		m[i][j] = 'X';
		merge(m, i-1, j);
		merge(m, i+1, j);
		merge(m, i, j-1);
		merge(m, i, j+1);
	}
	
	public static void main(String[] args) {
		char mat[][] = { { '1', '0', '1', '0' },
		                 { '1', '0', '0', '0' },
		                 { '0', '0', '1', '1' } };
		MatrixPrinter.print(mat);
		CountOfIselands o = new CountOfIselands();
		System.out.println("iseland count: " + o.getCountOfIselands(mat));
	}

}
