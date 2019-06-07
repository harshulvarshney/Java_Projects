package mission_peace.string;

/**
 * O(m+n) algorithm. (Same as Z-algo)
 * where m is the length of string and n is the length of pattern.
 * algo:
 * 	start comparing char of string and pattern 1-by-1
 * 	if a mismatch found
 * 		reset counter at pattern and start again.
 * 
 * @author harshul
 *
 */
public class KMPSubstringSearch {
	
	public static void main(String[] args) {
		String s = "abxabcabcaby";
		String p = "abcaby";
		
		FindPrefixSuffixInString obj = new FindPrefixSuffixInString();
		int [] arr = obj.getPrefixArrayForKMP(p);
		
		KMPSubstringSearch o = new KMPSubstringSearch();
		System.out.println(o.match(s, p, arr));
	}
	
	private boolean match(String s, String p, int[] a) {
		char[] sArr = s.toCharArray();
		char[] pArr = p.toCharArray();
		
		int i = 0, j = 0;
		while(i < sArr.length) {
			if(sArr[i] == pArr[j]) {
				i++; j++;
			}
			else {
				j = a[j];
				if(sArr[i] == pArr[j]) {
					i++; j++;
				}
				else {
					i++;
				}
			}
		}
		if(i == sArr.length)
			return true;
		else
			return false;
	}

}
