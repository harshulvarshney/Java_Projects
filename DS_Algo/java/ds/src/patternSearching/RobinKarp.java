package patternSearching;

public class RobinKarp {
	
	private static final int PRIME = 101;
	
	public static void main(String[] args) {
		char[] s = "wwasdfghjklpoiuytredcvbnjuyiokm".toCharArray();
		char[] p = "tre".toCharArray();
		
		RobinKarp o = new RobinKarp();
		System.out.println(o.find(s, p));
	}
	
	private int find(char[] s, char[] p) {
		int m = s.length;
		int n = p.length;
		
		long patternHash = calcHash(p, n-1);
		long strHash = calcHash(s, m-1);
		
		for(int i = 1; i < m-n; i++) {
			if(patternHash == strHash && s.equals(p)) {
				return i-1;
			}
			strHash = reCalcHash(s, i-1, i+n-1, strHash, n);
		}
		return -1;
	}
	
	private long reCalcHash(char[] a, int oldIndex, int newIndex, long oldHash, int end) {
		long newHash = oldHash - a[oldIndex];
		newHash = newHash/PRIME;
		newHash += a[newIndex]*Math.pow(PRIME, newIndex);
		return newHash;
	}
	
	private long calcHash(char[] a, int end) {
		long hash = 0;
		for(int i = 0; i <= end; i++) {
			hash += a[i]*Math.pow(PRIME, i);
		}
		
		return hash;
	}

}
