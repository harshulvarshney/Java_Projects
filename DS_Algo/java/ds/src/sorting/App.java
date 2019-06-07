package sorting;

import java.util.Arrays;

public class App {

	public static void main(String[] args) {
		int[] a = {3,1,7,6,9,-1,0,3,5,-2};
		insertionSort(a);
		System.out.println(Arrays.toString(a));
	}
	
	static void insertionSort(int[] a) {
		for(int i = 1; i < a.length; i++) {
			for(int j = i-1; j >=0; j--) {
				if(a[j] > a[j+1]) {
					int temp = a[j+1];
					a[j+1] = a[j];
					a[j] = temp;
				}
			}
		}
	}

}
