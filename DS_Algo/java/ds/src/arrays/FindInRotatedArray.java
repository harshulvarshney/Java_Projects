package arrays;

/**
 * Binary-Search in rotated and non-rotated array.
 * 
 * @author harshul.varshney
 *
 */
public class FindInRotatedArray {
	
	static int search(int [] arr, int key) {
		int pivot = findPivot(arr, 0, arr.length-1);
		if(pivot == -1)//array is not rotated
			return binarySearch(arr, 0, arr.length-1, key);
		
		if(arr[pivot] == key)
			return pivot;
		if(arr[0] < key)
			return binarySearch(arr, 0, pivot-1, key);
		return binarySearch(arr, pivot+1, arr.length-1, key);
	}
	
	private static int binarySearch(int[] arr, int low, int high, int key) {
		if(high < low)
			return -1;
		int mid = low + (high-low)/2;
		if(arr[mid] == key)
			return mid;
		if(key > arr[mid])
			return binarySearch(arr, mid+1, high, key);
		return binarySearch(arr, low, mid-1, key);
	}

	static int findPivot(int[] arr, int left, int right) {
		if(left == right)
			return left;
		if(left < right) {
			int mid = left + (right-left)/2;
				
			if(mid < right && arr[mid] > arr[mid+1])
				return mid;
			if(mid > left && arr[mid] < arr[mid-1])
				return mid-1;
			
			if(arr[left] >= arr[mid])
				return findPivot(arr, left, mid-1);
			return findPivot(arr, mid+1, right);
		}
		return -1;
	}
	
	public static void main(String[] args) {
		int[] arr = {3,4,5,6,7,8,9,1,2};
		//System.err.println(findPivot(arr, 0, arr.length-1));
		System.out.println(search(arr, 4));
	}

}
