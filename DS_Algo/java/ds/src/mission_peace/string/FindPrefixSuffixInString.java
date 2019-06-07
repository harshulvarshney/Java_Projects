package mission_peace.string;

import java.util.Arrays;

/**
 * Demonstrates how to identify if same prefix-sufix exist in a String.
 * @author harshul
 *
 */
public class FindPrefixSuffixInString {
	
	public static void main(String[] args) {
		String w = "aabaabaaab";
		FindPrefixSuffixInString obj = new FindPrefixSuffixInString();
		obj.getPrefixArrayForKMP(w);
	}
	
	/*
	 * Explaination:
	 * 		input: a a b a a b a a a b
	 * 		outp: [0,1,0,1,2,3,4,5,2,3]
	 * 
	 * from above input and output, check last element, which is 3, it says that in this input
	 * there exist a suffix of length 3 which is also a prefix.
	 * check 7th element, which is 4, it says that until 7th element in this word, there exist
	 * a suffix of length 4 which is also a prefix.
	 */
	
	public int[] getPrefixArrayForKMP(String w) {
		char[] c = w.toCharArray();
		int [] a = new int[c.length];
		a[0] = 0;
		
		int j = 0;
		int i = 1;
		while(i < c.length) {
			if(c[i] == c[j]) {
				a[i] = j+1;
				j++;
				i++;
			}
			else {
				if(j!=0)
					j = a[j-1];
				else {
					a[i] = 0;
					i++;
				}
				
			}
		}
		
		System.out.println(Arrays.toString(a));
		return a;
	}
	
	

}
