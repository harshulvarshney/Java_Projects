package mission_peace.range_queries;

import java.util.Arrays;

/**
 * Its similar to a heap, whose physical representation is arrays 
 * but acts as a tree while solving logical problems.
 * 
 * Segment tree is used to answer question related to range.
 * e.q. find the min value from an array in range 3 to 9 (3 and 9 are indexes).
 * 
 * Time complexity to create segment tree is O(n) since new array will be at max 4n size
 * Space complexity to create segment tree is O(n) since new array will be at max 4n size
 * Time complexity to search in segment tree is O(logn) since you would at max travel 4 depths
 * Time complexity to update in segment tree is O(logn)
 * Time complexity to update range in segment tree is O(range)
 * 
 * @author Harshul
 *
 */
public class SegmentTree {
	
	int[] segArray;
	
	public int getMinInRange(int[] arr, int qLow, int qHigh, int low, int high, int pos) {
		if(qLow <= low && qHigh >= high) {//total overlap
			return arr[pos];
		}
		if(qLow > high || qHigh < low) {//partial overlap
			return Integer.MAX_VALUE;
		}
		int mid = (low+high)/2;
		return Math.min(getMinInRange(arr, qLow, qHigh, low, mid, 2*pos+1), 
				getMinInRange(arr, qLow, qHigh, mid+1, high, 2*pos+2));
			
	}
	
	public void constructSegTree(int[] arr, int low, int high, int pos) {
		if(low == high) {
			segArray[pos] = arr[low];
			return;
		}
		int mid = (low+high)/2;
		constructSegTree(arr, low, mid, 2*pos+1);
		constructSegTree(arr, mid+1, high, 2*pos+2);
		segArray[pos] = Math.min(segArray[2*pos+1], segArray[2*pos+2]);
	}
	
	public static void main(String[] args) {
		SegmentTree obj = new SegmentTree();
		int[] arr = {-1,2,4,0};
		obj.segArray = new int[7];
		obj.constructSegTree(arr, 0, 3, 0);
		System.out.println(Arrays.toString(obj.segArray));
		System.out.println("Min in range 1 to 3 = " + obj.getMinInRange(obj.segArray, 1, 2, 0, 3, 0));
	}

}
