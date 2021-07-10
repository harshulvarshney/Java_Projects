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
    private static int findLis(int [] arr) {

        int[] lis = new int[arr.length];
        Arrays.fill(lis, 1);

        for(int i=1; i< arr.length; i++) {
            for(int j=0; j<i; j++) {
                if(arr[j] < arr[i] && lis[i] < lis[j] + 1) {
                    lis[i] = 1 + lis[j];
                }
            }
        }
        int max = lis[0];
        for(int i=1; i< arr.length; i++) {
            if(lis[i] > max)
                max = lis[i];
        }

        return max;
    }

    public static void main(String[] args) {
        int[] input = {10, 22, 9, 33, 21, 50, 41, 60};
        System.out.println("LIS :: " + findLis(input));
    }
}
