package recursion;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Practice {
	private static int[] arr;
	
	public static void main(String[] args) {
		Practice obj = new Practice();
		int [] a = {1,2,3,1,7,8};
		Scanner s = new Scanner(System.in);
		int N = s.nextInt(2);
		String str = s.next();
//		a = Arrays.
//		obj.test(a);
	}
	
	private void test(int[] a) {
		Set<Integer> set = new HashSet<>();
		for(int i : a)
			set.add(i);
		
		int count = 0;
		for(int i = 0; i < a.length; i++) {
			for(int j = i+1; j < a.length; j++) {
				int sum = a[i] + a[j];
				if(set.contains(sum))
					count+=1;
			}
		}
		System.out.println(count);
	}

}
