package mission_peace.string;

import java.util.Arrays;

/**
 * O(m+n) -  same as KMP algorithm
 * It works by calculating Z array which is : longest substring starting at position k which is also
 * a prefix of the string.
 * 
 * So, if we have to find a pattern p in string s, then we append s with p separated by a special char
 * i.e. we create a new string s = p<>s. The special char must not exist in any of the strings.
 * now we run z-algorithm on it and find all the substrings which are also equals to prefix p.
 * 
 * @author harshul
 *
 */
public class ZAlgo {
	
	public static void main(String[] args) {
		ZAlgo obj = new ZAlgo();
		String s = "xabcabzabc";
		String p = "abc";
		obj.match(s, p);
	}
	
	private void match(String s, String p) {
		String d = String.join("$", p, s);
		System.out.println(d);
		
		char[] arr = d.toCharArray();
		int[] a = new int[arr.length];
		a[0] = 0;
		
		int i = 1, j = 0;
		int matchCount = 0;
		while(i < arr.length) {
			if(arr[i] == arr[j]) {
				matchCount +=1;
				j++;
			}
			else {
				i = i - matchCount;
				a[i] = matchCount;
				matchCount = 0; j = 0;
			}
			i++;
		}
		
		System.out.println(Arrays.toString(a));
		int pLength = p.length();
		//removing pattern from original array.
		int[] k = Arrays.copyOfRange(a, pLength+1, a.length);
		System.out.println(Arrays.toString(k));
		
		for(int q = 0; q < k.length; q++) {
			if(q == pLength)
				System.out.println("Pattern present at index " + q + " in string.");
		}
			
	}

}
