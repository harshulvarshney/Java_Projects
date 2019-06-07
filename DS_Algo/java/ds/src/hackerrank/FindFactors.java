package hackerrank;

/**
 * if i is a factor of n then n/i will also be a factor of n.
 * 
 * @author harshul.varshney
 *
 */
public class FindFactors {
	
	public static void main(String[] args) {
		FindFactors f = new FindFactors();
		f.printAllFactors(100);
	}
	
	public void printAllFactors(int n) {
		int max = (int) Math.sqrt(n);
		StringBuilder sb = new StringBuilder();
		sb.append(1).append(" ");
		for(int i=2; i < max; i++) {
			if(n%i == 0) {
				sb.append(i).append(" ").append(n/i).append(" ");
			}
		}
		sb.append(n);
		System.out.println(sb);	
	}

}
