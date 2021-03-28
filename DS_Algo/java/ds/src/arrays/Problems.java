package arrays;

import java.util.Arrays;

public class Problems {

	public static void main(String[] args) {
		int[] a1 = {1,3};
		int[] a2 = {2,4};
		System.out.println(findMedianSortedArrays(a1, a2));
	}


	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		if(nums1.length == 0 && nums2.length != 0)
			return median(nums2);
		if(nums1.length != 0 && nums2.length == 0)
			return median(nums1);


		int l1 = nums1.length;
		int l2 = nums2.length;
		int[] arr = new int[l1 + l2];
		int pos = 0;
		int p1 = 0;
		int p2 = 0;
		while(p1 < l1 && p2 < l2) {
			if(nums1[p1] <= nums2[p2]) {
				arr[pos++] = nums1[p1++];
			} else {
				arr[pos++] = nums2[p2++];
			}
		}
		if(p1 < l1) {
			while(p1 < l1) {
				arr[pos++] = nums1[p1++];
			}
		} else {
			while(p2 < l2) {
				arr[pos++] = nums2[p2++];
			}
		}
		return median(arr);
	}

	private static double median(int[] arr) {
		int l = arr.length;
		int mid = l/2;
		if(l % 2 == 0) {
			return ((double) arr[mid] + (double) arr[mid-1])/2;
		}
		else {
			return arr[mid];
		}
	}

}
