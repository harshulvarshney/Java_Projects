package arrays;


public class FindFirstRepeating {
	
	public static void main(String[] args) {
		String s = "axyooatestii";
		find(s);
	}
	
	static void find(String s) {
		char[] arr = s.toCharArray();
		boolean[] newArr = new boolean[256];
		
		for(char c : arr) {
			if(newArr[c]) {
				System.out.println("First repeating character is: " + c);
				return;
			}
			newArr[c] = true;
		}
	}

}
