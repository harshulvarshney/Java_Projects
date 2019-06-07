package mission_peace.recursion;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Print all the permutations of a given string in lexographical (alphabetic)
 * sorted order.
 * 
 * no. of permutations = fact(no. of chars)/fact(no. of repeated chars).
 * 
 * @author harshul
 * 
 * https://www.youtube.com/watch?v=nYFd7VHKyWQ&index=1&t=11s&list=PLrmLmBdmIlpslxZUHHWmfOzNn6cA7jvyh
 *
 */
public class StringPremutation {
	
	public static void main(String[] args) {
		StringPremutation obj = new StringPremutation();
		obj.premute("AABC");
	}
	
	private void premute(String s) {
		Map<Character, Integer> charMap = getMap(s);
		System.out.println();
	}
	
	private void premuteRec(Map<Character, Integer> map) {
		
	}
	
	private Map<Character, Integer> getMap(String s) {
		char[] c = s.toCharArray();
		Map<Character, Integer> map = new LinkedHashMap<>();
		for(char ch : c) {
			if(map.containsKey(ch))
				map.put(ch, map.get(ch)+1);
			else
				map.put(ch, 1);
		}
		
		return map;
	}

}
