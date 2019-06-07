package hackerrank;

import java.util.HashSet;
import java.util.Set;

/**
 * Pangram: a sentence containing every letter of the alphabet
 * 
 * @author harshul.varshney
 *
 */
public class CheckPangram {
	
	public static void main(String[] args) {
		String[] strings = new String[4];
		strings[0] = "we promptly judged antique ivory buckles for the next prize";
		isPangram(strings);
	}
	
	static String isPangram(String[] strings) {
		Set<Character> charSet = new HashSet<>(0);
		StringBuilder result = new StringBuilder();
		for(int i = 0; i < strings.length; i++) {
			String s = strings[i].replaceAll("\\s", "");
			for(char c : s.toCharArray()) {
				charSet.add(c);
			}
			if(charSet.size() == 26) {
				result.append(1).append(" ");
			}
		}
		return result.toString();
    }
	
	static int kDifference(int[] a, int k) {
		Set set = new HashSet(a.length);
		int count = 0;
		for(int i : a)
			set.add(i);
		
		for (int value : a) {

			int target = k - value;
			if (!set.contains(target)) {
				set.add(value);
			} else {
				count+=1;
			}
		}
		return count;
	}

}
