package arrays;

import java.util.concurrent.ConcurrentHashMap;

public class FindFirstRepeating {
	
	public static void main(String[] args) {
		String s = "axxotestii";
		find(s);
	}
	
	static void find(String s) {
		char[] arr = s.toCharArray();
		int[] newArr = new int[256];
		
		for(char c : arr) {
			int v = newArr[c] + 1;
			newArr[c] = v;
		}
		for(char c : arr) {
			if(newArr[c] > 1) {
				System.out.println("First repeating character is: " + c);
				break;
			}
		}
	}

}
