package logical;

import java.util.Arrays;
/**
 * 1. convert int to binary
 * 2. convert decimal to binary
 * 3. Count number of bits to be flipped to convert A to B
 * 		calculate XOR of A and B and count the number of 1s in it.
 * 
 * @author harshul.varshney
 *
 */
public class ConvertBinary {
	
	static void printBinaryForm(int n) {
		//int l = ((int)Math.log10(n)+1);
		int[] arr = new int[32];
		if(n < 0)
			arr[0] = 1;
		
		for(int i = 31; i > 0; i--) {
			if(n%2 == 0)
				arr[i] = 0;
			else
				arr[i] = 1;
			n = n/2;
		}
		
		System.out.println(Arrays.toString(arr));
	}
	
	public static void main(String[] args) {
		printBinaryForm(-11);
	}

}
