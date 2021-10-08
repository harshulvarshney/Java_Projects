package _AdityaVerma_Jul21.dynamicProgramming;


import java.util.Arrays;

/**
 * The Longest Increasing Subsequence (LIS) problem is to find the length of the longest
 * subsequence of a given sequence such that all elements of the subsequence are sorted in
 * increasing order. For example, the length of LIS for {10, 22, 9, 33, 21, 50, 41, 60, 80}
 * is 6 and LIS is {10, 22, 33, 50, 60, 80}.
 *
 * **recursive solution by creating a decision tree may not be possible in this case
 * **use the first method only
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
//        int[] input = {1, 3, 6, 2, 4, 7, 1};
        int[] input = {10,9,2,5,3,7,101,18};
//        int[] input = {0,1,0,3,2,3};

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

    // this solution is not working
    static int recursive(int[] arr, int n, int l) {
        if(n < 2)
            return l;

        if(arr[n-1] > arr[n-2]) {
            l = Math.max(recursive(arr, n - 1, l + 1), recursive(arr, n - 1, l));
            return l;
        }
        else {
            l = recursive(arr, n-1, l);
            return l;
        }
    }
}
