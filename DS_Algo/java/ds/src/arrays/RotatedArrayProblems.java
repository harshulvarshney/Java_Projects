package arrays;

/**
 * 
 * @author harshul.varshney
 *
 */
public class RotatedArrayProblems {
	
	/*
	 * Search an element in a sorted and rotated array
	 * NOTE: there are no duplicates.
	 */
	static int searchElement(int[] a, int start, int end, int k) {
		//not found
		if(end < start) return -1;
		
		int mid = start + (end-start)/2;
		if(a[mid] == k)
			return mid;
		
		if(a[start] <= a[mid]) {//left side array is sorted
			if(a[start] <= k && k < a[mid])
				return searchElement(a, start, mid-1, k);
			return searchElement(a, mid+1, end, k);
		}
		//if left is not sorted, right must be sorted
		if(a[mid] < k && k <= a[end])
			return searchElement(a, mid+1, end, k);
		return searchElement(a, start, mid-1, k);
	}
	
	/*
	 * find minimum element in a sorted and rotated array
	 */
	static int findMin(int[] a, int start, int end) {
		//when there are no elements in array
		if(end < start) return Integer.MIN_VALUE;
		//when there is only one element
		if(end == start) return a[start];
		
		int mid = start + (end-start)/2;
		if(mid > start && a[mid] < a[mid-1])
			return a[mid];
		if(mid < end && a[mid+1] < a[mid])
			return a[mid+1];
		
		if(a[end] > a[mid])
			return findMin(a, start, mid-1);
		return findMin(a, mid+1, end);
		
	}
	
	public static void main(String[] args) {
		int[] a = {4,5,6,1,2,3};
		System.out.println(searchElement(a, 0, a.length-1, 2));
	}

}
