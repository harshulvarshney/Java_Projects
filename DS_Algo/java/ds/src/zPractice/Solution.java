package zPractice;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] coins = {1,2,4};
        int amount = 11;

        System.out.println("Rec sol :: " + (int)minCoins(coins, amount, coins.length));

        int[][] t = new int[coins.length+1][amount+1];
        for(int[] i: t) {
            Arrays.fill(i, -1);
        }
        System.out.println("memoized Sol:: " + minCoinsMemoized(coins, amount, coins.length, t));
    }

    static double minCoins(int[] arr, int sum, int n) {
        if(sum == 0)
            return 0;
        else if(n == 0)
            return Double.POSITIVE_INFINITY;

        if(arr[n-1] <= sum)
            return Math.min(1 + minCoins(arr, sum-arr[n-1], n), minCoins(arr, sum, n-1));
        else
            return minCoins(arr, sum, n-1);
    }

    static int minCoinsMemoized(int[] arr, int sum, int n, int[][] t) {
        if(sum == 0)
            return 0;
        else if(n == 0)
            return Integer.MAX_VALUE;

        if(t[n][sum] != -1)
            return t[n][sum];

        if(arr[n-1] <= sum) {
            t[n][sum] = Math.min(1 + minCoinsMemoized(arr, sum - arr[n - 1], n, t), minCoinsMemoized(arr, sum, n - 1, t));
            return t[n][sum];
        }
        else {
            t[n][sum] = minCoinsMemoized(arr, sum, n - 1, t);
            return t[n][sum];
        }
    }

}
