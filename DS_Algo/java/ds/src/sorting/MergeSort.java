package sorting;

import java.util.Arrays;

/**
 * It's a divide and concur algorithm.
 * its worst case running time is O(nlogn), O(logn) is for recursive-breaking of array in to small pieces
 * and O(n) is for merging the arrays back.
 * 
 * But it is not in-place algo, it required O(n) space.
 * 
 * @author harshul
 *
 */
public class MergeSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {7,3,2,5,4,1,6, -1,9, 1};
		MergeSort o = new MergeSort();
		o.sort(a, 0, a.length-1);
	}
	
	private void sort(int[] a, int left, int right) {
		if(left < right) {
			int m = (right+left)/2;
			sort(a, left, m);
			sort(a, m+1, right);
			merge(a, left, m, right);
		}
		
	}
	
	private void merge(int [] a, int l, int m, int r) {
		//get size of 2 arrays to be merged
		int l1 = m - l + 1;
		int l2 = r - m;
		//initialize 2 auxilary arrays
		int[] L1 = new int [l1];
		int[] L2 = new int [l2];
		//fill aux arrays
		for(int i = 0; i < l1; ++i)
			L1[i] = a[l+i];
		for(int j = 0; j < l2; ++j)
			L2[j] = a[m+1+j];
		
		//merge the arrays - compare 2 arrays, put smaller no in a[] and increament the
		//array from which number was picked, repeat this process.
		int k = l;
		int i = 0,j = 0;
		while(i < l1 && j < l2) {
			if(L1[i] <= L2[j]) {
				a[k] = L1[i];
				i++;
			}
			else {
				a[k] = L2[j];
				j++;
			}
			k++;
		}
		
		while (i < l1)
        {
            a[k] = L1[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of L[] if any */
        while (j < l2)
        {
            a[k] = L2[j];
            j++;
            k++;
        }
        
        System.out.println(Arrays.toString(a));
	}

}
