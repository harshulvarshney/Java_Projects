package mission_peace.string;

import java.util.Arrays;

/**
 * 
 * @author harshul
 *
 */
public class WildCardMatching {

	public static void main(String[] args) {
		
		String s = "xaylmz";
		String p = "x?y**z";
		
		WildCardMatching obj = new WildCardMatching();
		System.out.println(obj.match(s, p) ? "match found" : "no match");
	}
	
	private boolean match(String s, String p) {
		char[] sArr = s.toCharArray();
		
		System.out.println("String: " + Arrays.toString(sArr));
		System.out.println("Pattern: " + Arrays.toString(p.toCharArray()));
		String updatedPattern = updatePattern(p);
		System.out.println("Updated Pattern: " + updatedPattern);
		
		char[] pArr = updatedPattern.toCharArray();
		boolean[][] matrix = new boolean[sArr.length+1][pArr.length+1];
		matrix[0][0] = true;
		
		for(int i = 1; i < sArr.length+1; i++) {
			for(int j = 1; j < pArr.length+1; j++) {
				if(pArr[j-1] == '?' || sArr[i-1] == pArr[j-1]) {
					matrix[i][j] = matrix[i-1][j-1];
				}
				else if(pArr[j-1] == '*') {
					matrix[i][j] = matrix[i][j-1] || matrix[i-1][j];
				}
			}
		}
		
		print(matrix);
		return matrix[sArr.length][pArr.length];
	}
	
	/**
	 * Need to replace multiple consecutive * with single *
	 * @param pArr
	 */
	private String updatePattern(String p) {
		StringBuilder sb = new StringBuilder();
		char[] pArr = p.toCharArray();
		
		boolean found = false;
		for(char c : pArr) {
			if(c == '*' && !found) {
				sb.append(c);
				found = true;
			}
			if(c != '*') {
				sb.append(c);
				found = false;
			}
		}
		
		return sb.toString();
	}
	
	private void print(boolean[][] matrix) {
		for(boolean[] b: matrix) 
			System.out.println(Arrays.toString(b));
	}

}
