package _AdityaVerma_Jul21.dynamicProgramming.knapsack;

import java.util.Arrays;

/**
 * https://www.youtube.com/watch?v=_gPcYovP7wc&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=7
 *
 * Given a set of non-negative integers, and a value sum, determine if there is a subset of the given set with sum equal to given sum.
 *
 * Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 9
 * Output: True
 * There is a subset (4, 5) with sum 9.
 *
 * Input: set[] = {3, 34, 4, 12, 5, 2}, sum = 30
 * Output: False
 * There is no subset that add up to 30.
 */
public class a2_SubsetSum {

    public static void main(String[] args) {
        int[] arr = {2, 3, 7, 8, 10};
        int sum = 9;
        int n = arr.length;

        System.out.println("Recursive sol :: " + recursive(arr, sum, n));

        int[][] t = new int[n+1][sum+1];
        for(int[] i: t) {
            Arrays.fill(i, -1);
        }
        System.out.println("memozed sol   :: " + (recursiveWithMem(arr, sum, n, t) == 1));

        //top-down dp solution
        System.out.println("dp sol :: " +dp(arr, sum));
    }

    static boolean recursive(int[] arr, int sum, int n) {
        // if arr is empty and sum is 0 > yes, we can hv a empty subset with sum 0
        if(n == 0 && sum == 0)
            return true;
        // if arr is non-empty but target sum is 0 > yes, we can hv a empty subset
        if(n > 0 && sum == 0)
            return true;
        // if arr is empty and sum is non-zero > NO, we cannot hv a subset here
        if(n == 0 && sum > 0)
            return false;

        if(arr[n-1] <= sum) {
            return recursive(arr, sum - arr[n-1], n-1) || recursive(arr, sum, n-1);
        }
        else
            return recursive(arr, sum, n-1);

    }

    static int recursiveWithMem(int[] arr, int sum, int n, int[][] t) {
        // if arr is empty and sum is 0 > yes, we can hv a empty subset with sum 0
        if(n == 0 && sum == 0)
            return 1;
        // if arr is non-empty but target sum is 0 > yes, we can hv a empty subset
        if(n > 0 && sum == 0)
            return 1;
        // if arr is empty and sum is non-zero > NO, we cannot hv a subset here
        if(n == 0 && sum > 0)
            return 0;

        if(t[n][sum] != -1)
            return t[n][sum];

        if(arr[n-1] <= sum) {
            t[n][sum] = Math.max(recursiveWithMem(arr, sum - arr[n-1], n-1, t),
                    recursiveWithMem(arr, sum, n-1, t));
            return t[n][sum];
        }
        else {
            t[n][sum] = recursiveWithMem(arr, sum, n - 1, t);
            return t[n][sum];
        }
    }

    static boolean dp(int[] arr, int sum) {
        int n = arr.length;
        boolean[][] t = new boolean[n+1][sum+1];

        for(boolean[] i: t) {
            i[0] = true;
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=sum; j++) {
                if(arr[i-1 ] <= j) {
                    t[i][j] = t[i-1][j - arr[i-1]] || t[i-1][j];
                } else {
                    t[i][i] = t[i-1][j];
                }
            }
        }
        return t[n][sum];
    }

}
