package searching;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ArrayProblems {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println("Input array :: " + Arrays.toString(arr));
        System.out.println(binarySearch(arr, 8, 0, arr.length-1));
    }

    static int findInRotatedSortedArray(int[] arr, int k) {
        if(arr == null || arr.length == 0)
            return -1;

        int l = 0;
        int r = arr.length-1;
        int mid = -1;
        while(l <= r) {
            mid = l + (r-l)/2;
            if(k == arr[mid])
                return mid;
            else if(arr[l] <= arr[mid]) {
                if(k >= arr[l] && k <= arr[mid])
                    r = mid-1;
                else
                    l = mid + 1;
            }
            else {
                if(k >= arr[mid] && k <= arr[r])
                    l = mid + 1;
                else
                    r = mid - 1;
            }
        }
        return -1;
    }

    static int binarySearch(int[] arr, int k, int l, int r) {
        if(arr == null || arr.length == 0)
            return -1;

        while(l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == k)
                return mid;
            else if (k >= arr[mid + 1])
                return binarySearch(arr, k, mid + 1, r);
            else
                return binarySearch(arr, k, l, mid - 1);
        }
        return -1;
    }

    /**
     * find two numbers whose sum is k
     */
    static void twoSum(int[] arr, int k) {
        Map<Integer, Integer> diffToIndexMap = new HashMap<>();
        for(int i=0; i<arr.length; i++) {
            int diff = k - arr[i];
            if(diffToIndexMap.containsKey(arr[i])) {
                System.out.println("Two numbers are: " + arr[diffToIndexMap.get(arr[i])] + " and " +  arr[i]);
            }
            else {
                diffToIndexMap.put(diff, i);
            }
        }
    }

    static void threeSum(int[] arr) {

    }

    /**
     * you are given an array containing numbers from 1 to n.
     * find one missing number.
     */
    static void findMissingNumber(int[] arr) {
        int n = arr.length+1;
        int sumOF_n = (n*(n+1))/2;
        int providedNumSum = 0;
        for(int i=0; i<arr.length; i++) {
            providedNumSum = providedNumSum + arr[i];
        }
        int missingNum = sumOF_n - providedNumSum;
        System.out.println(missingNum);
    }


}
