package mission_peace.string;

import java.util.Arrays;

/**
 * Its the simplest of pattern searching algos.
 * calculate hashCode of the pattern
 * calculate hashCode of the string by changing characters 1-by-1
 * if a match found, match the pattern characters and return the result.
 * 
 * @author harshul
 *
 */
public class RabinKarpAlgo {
	
	private static final Integer PRIME = 101;
	
	public static void main(String[] args) {
		RabinKarpAlgo obj = new RabinKarpAlgo();
		String s = "weewfqwefeqf_x1yzfvdfggf111";
		String p = "xyz";
		System.out.println("String: " + s + "\n" + "pattern: " + p);
		System.out.println("Match found? " + (obj.found(s, p) ? "YES" : "NO"));
	}
	
	private boolean found(String s, String p) {
		char[] strArr = s.toCharArray();
		char[] pArr = p.toCharArray();
		
		int pHash = calcHash(pArr);
		int sHash = calcHash(Arrays.copyOfRange(strArr, 0, pArr.length));
		
		if(isMatch(sHash, pHash, Arrays.copyOfRange(strArr, 0, pArr.length), pArr))
			return true;
		else {
			int reHash = sHash;
			for(int i = 1; i < strArr.length-pArr.length+1; i++) {
				reHash = recalcHash(strArr, i, i+pArr.length-1, reHash, pArr.length);
				char[] subArr = Arrays.copyOfRange(strArr, i, i+pArr.length);
				if(isMatch(reHash, pHash, subArr, pArr))
					return true;
			}
		}
		
		return false;
	}
	
	private boolean isMatch(int strHash, int patternHash, char[] str, char[] p) {
		if(strHash == patternHash && Arrays.equals(str, p))
			return true;
		
		return false;
	}
	
	private int recalcHash(char[] a, int start, int end, int oldHash, int patternLength) {
		int hash = oldHash;
		hash -= a[start-1];
		hash = hash/PRIME;
		hash += a[end]*Math.pow(PRIME, patternLength-1);
		return hash;
	}
	
	private int calcHash(char[] c) {
		int hash = 0;
		if(c != null && c.length > 0) {
			for(int i = 0; i < c.length; i++) {
				hash += c[i]*Math.pow(PRIME, i);
			}
		}
		
		return hash;
	}

}
