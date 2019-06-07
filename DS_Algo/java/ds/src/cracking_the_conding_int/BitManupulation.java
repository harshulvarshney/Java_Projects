package cracking_the_conding_int;

public class BitManupulation {
	
	public static void printBiary(double number) {
		String[] arr = (Double.toString(number)).split(".");
		int intPart = Integer.parseInt(arr[0]);
		int decPart = Integer.parseInt(arr[1]);
		
		StringBuffer sb = new StringBuffer();
		while(intPart > 0) {
			int r = intPart%2;
			intPart >>=1;
			sb.append(r).append(intPart);
		}
		sb.append(".");
//		while(decPart)
	}
	
	public static void main(String[] args) {
		printBiary(3.72d);
	}

}
