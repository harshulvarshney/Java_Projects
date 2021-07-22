package _AdityaVerma_Jul21.dynamicProgramming.knapsack;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/coin-change/submissions/
 *
 * You are given coins of different denominations and a total amount of money amount.
 * Write a function to compute the fewest number of coins that you need to make up
 * that amount. If that amount of money cannot be made up by any combination of the
 * coins, return -1.
 *
 * You may assume that you have an infinite number of each kind of coin.
 *
 * Example 1:
 * Input: coins = [1,2,5], amount = 11
 * Output: 3
 * Explanation: 11 = 5 + 5 + 1
 *
 *
 * Example 2:
 * Input: coins = [2], amount = 3
 * Output: -1
 *
 *
 * Example 3:
 * Input: coins = [1], amount = 0
 * Output: 0
 */
public class b3_CoinChange_MinCoins {

    public static void main(String[] args) {
        int[] coins = {1,2,4};
        int amount = 11;
        //recursive sol
        System.out.println("Rec sol :: " + (int)minCoins(coins, amount, coins.length));

        //Memoized sol
        Double[][] t = new Double[coins.length+1][amount+1];
        for(Double[] i: t) {
            Arrays.fill(i, Double.POSITIVE_INFINITY);
        }
        System.out.println("memoized Sol:: " + minCoinsMemoized(coins, amount, coins.length, t));

        System.out.println("Bottom Up DP: " + coinChange(coins, amount));

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

    static Double minCoinsMemoized(int[] arr, int sum, int n, Double[][] t) {
        if(sum == 0)
            return 0.0;
        else if(n == 0)
            return Double.POSITIVE_INFINITY;

        if(t[n][sum] != Double.POSITIVE_INFINITY)
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

    static int coinChange(int[] coins, int amount) {
        double[][] t = new double[coins.length+1][amount+1];
        for(double[] i: t) {
            Arrays.fill(i, Double.POSITIVE_INFINITY);
            i[0] = 0.0;
        }


        for(int i=1; i<=coins.length; i++) {
            for(int j=1; j<=amount; j++) {
                if(coins[i-1] <= j) {
                    t[i][j] = Math.min(1 + t[i][j - coins[i-1]], t[i-1][j]);
                }
                else {
                    t[i][j] = t[i-1][j];
                }
            }
        }

        return t[coins.length][amount] >= Double.POSITIVE_INFINITY ? -1 : (int) t[coins.length][amount];
    }
}
