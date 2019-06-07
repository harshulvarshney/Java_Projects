package sorting;

import java.util.Arrays;

/**
 * Insertion sort is a simple sorting algorithm that works the way we sort playing cards in our hands.
 * 
 * Uses: Insertion sort is used when number of elements is small. It can also be useful when input array
 * is almost sorted, only few elements are misplaced in complete big array.
 *  
 * @author harshul
 *
 */
public class InsertionSort {

	public static void main(String[] args) {
		int[] a = {11,7,3,2,5,4,1,6, -1,9, 1};
		InsertionSort o = new InsertionSort();
		o.sort(a);
	}
	
	private void sort(int []a) {
		
		for(int i = 1; i < a.length; i++) {
			for(int j = i-1; j >= 0; j--) {
				if(a[j+1] < a[j]) {
					int temp = a[j+1];
					a[j+1] = a[j];
					a[j] = temp;
				}
			}
		}
		System.out.println(Arrays.toString(a));
	}

}
