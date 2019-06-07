package string;

import java.util.Arrays;

public class ReverseWords {
	private static char[] s = null;
	public static void main(String[] s) {
		String ss = "It's not late to start.";
		ReverseWords o = new ReverseWords();
		o.reverse(ss);
	}
	
	private void reverse(String in) {
		String[] str = in.split(" ");
		int i = 0;
		for(String s : str) {
			String k = revCharArray(s.toCharArray());
			str[i] = k;
			i++;
		}
		
		System.out.println(Arrays.toString(str));
	}
	
	private String revCharArray(char[] s) {
		int i = 0;
		int j = s.length-1;
		while(i<j) {
			char temp = s[i];
			s[i] = s[j];
			s[j] = temp;
			i++;
			j--;
		}
		return Arrays.toString(s);
	}

}
