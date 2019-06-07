package hackerrank;

public class Solution {
	
	public static void main(String[] args) {
		String s = "aaaaaaazxzzzxx@";
		
		System.out.println(removeDulicate(s));
	}
	
	private static String removeDulicate(String s) {
		if(s == null)
			return null;
		char[] arr = s.toCharArray();
		
		if(arr.length < 2) 
			return arr.toString();
		
		boolean[] a = new boolean[256];
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < arr.length; i++) {
			if(a[arr[i]] == false) {
				a[arr[i]] = true;
				sb.append(arr[i]);
			}
		}
		return sb.toString();
	}

}
