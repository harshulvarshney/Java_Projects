package sorting;

import java.util.Arrays;

/**
 * worst case running time complexity of O(n Log n).
 * in-memory sorting.
 * 
 * @author Harshul
 *
 */
public class HeapSort {

	public static void main(String[] args) {
		int[] a = {7,3,2,5,4,1,6, -1,9, 1};
		HeapSort o = new HeapSort();
		o.sort(a);
		System.out.println(Arrays.toString(a));
	}
	
	private void sort(int[] a) {
		int n = a.length;
		//build max heap.
		for(int i = n/2-1; i>=0; i--) {
			maxHeapify(a, n, i);
		}
		//convert heap in to array form.
		for (int i=n-1; i>=0; i--)
        {
            // Move current root to end
            int temp = a[0];
            a[0] = a[i];
            a[i] = temp;
 
            // call max heapify on the reduced heap
            maxHeapify(a, i, 0);
        }
	}
	
	/**
	 * 
	 * @param a : array input
	 * @param n : length of array
	 * @param i : node to be heapify.
	 */
	private void maxHeapify(int[] a, int n, int i) {
		int l = 2*i + 1;
		int r = 2*i + 2;
		int largest = i;
		if(l < n && a[l] > a[largest]) {
			largest = l;
		}
		if(r < n && a[r] > a[largest]) {
			largest = r;
		}
		
		if(largest != i) {//swap nodes.
			int temp = a[i];
			a[i] = a[largest];
			a[largest]  =temp;
			//heapify the child nodes.
			maxHeapify(a, n, largest);
		}
	}

}
