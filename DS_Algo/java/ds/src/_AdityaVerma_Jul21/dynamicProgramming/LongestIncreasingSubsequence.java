package _AdityaVerma_Jul21.dynamicProgramming;


import java.util.Arrays;

/**
 * The Longest Increasing Subsequence (LIS) problem is to find the length of the longest
 * subsequence of a given sequence such that all elements of the subsequence are sorted in
 * increasing order. For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80}
 * is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 *
 * https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/
 *
 * https://www.udemy.com/course/dynamic-programming-i/learn/lecture/10881032#questions/5650468
 */
public class LongestIncreasingSubsequence {

    /**
     * LIS(i) = 1 + max(LIS(i-1), LIS(i-2) ... LIS(0))
     */
    public static void main(String[] args) {
        int[] input = {1, 3, 6, 2, 4, 7, 1};
        System.out.println("LIS :: " + findLis(input));

        System.out.println(recursive(input, input.length, 0));
    }


    private static int findLis(int [] arr) {

        int[] lis = new int[arr.length];
        Arrays.fill(lis, 1);

        int max = lis[0];
        for(int i=1; i< arr.length; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i] && lis[i] < lis[j] + 1) {
                    lis[i] = 1 + lis[j];
                    max = Math.max(max, lis[i]);
                }
            }
        }
        return max;
    }

    static int recursive(int[] arr, int n, int l) {
        if(n < 2)
            return l + n;

        if(arr[n-1] > arr[n-2]) {
            l = Math.max(recursive(arr, n - 1, l + 1), recursive(arr, n - 1, l));
            return l;
        }
        else {
            l = recursive(arr, n-1, l);
            return l;
        }
    }

    static int memoized(int[] arr, int n, int l, int[] t) {
        if(n < 2)
            return l + n;

        if(t[n-1] != -1)
            return t[n-1];

        if(arr[n-1] > arr[n-2]) {
            l = Math.max(memoized(arr, n - 1, l + 1, t), memoized(arr, n - 1, l, t));
            t[n-1] = l;
            return l;
        }
        else {
            l = memoized(arr, n-1, l, t);
            t[n-1] = l;
            return l;
        }
    }

    static int bottomUpDp(int[] arr) {
        if(arr.length == 0)
            return 0;

        int[] t = new int[arr.length];
        Arrays.fill(t, 1);

        int max = 1;
        for(int i=1; i<arr.length; i++) {
            if(arr[i] > arr[i-1] && arr[i] > max) {
                t[i] = 1 + max;
            }
            else if(arr[i] > arr[i-1]) {
                t[i] = 1 + t[i-1];
            }
            else {
                t[i] = 1;
            }
            max = Math.max(max, t[i]);
        }
        return t[arr.length-1];
    }
}
