package dynamicProgramming.knapsack;

import java.util.Arrays;

/**
 * https://www.youtube.com/watch?v=aL6cU5dWmWM&list=PLSIpQf0NbcClDpWE58Y-oSJro_W3LO8Nb&index=4
 */
public class a1_Knapsack {

    public static void main(String[] args) {
        int[] values = {150, 300, 200};
        int[] weights = {1, 4, 3};
        int capacity = 4;
        // 1- find the recursive sol
        System.out.println("recirsive :: " + recursive(values, weights, values.length, capacity));

        // 2- improve recursive sol by memoization
        cache = new int[values.length+1][capacity+1];
        System.out.println("memoization :: " + memoization(values, weights, values.length, capacity));
        System.out.println("cache :: " + Arrays.deepToString(cache));

        // 3- solve optimally by using a table  - bottom-up approach
        dp = new int[values.length+1][capacity+1];
        System.out.println("BottomUp :: " + bottomUp(values, weights, capacity));
        System.out.println("dp :: " + Arrays.deepToString(dp));
    }

    private static int recursive(int[] v, int[] wt, int n, int c) {
        if(n == 0 || c <= 0)
            return 0;

        if(wt[n-1] > c)
            return recursive(v, wt, n-1, c);

        return Math.max((v[n-1] + recursive(v, wt, n-1, c-wt[n-1])), recursive(v, wt, n-1, c));
    }

    static int[][] cache;
    private static int memoization(int[] v, int[] wt, int i, int c) {
        if(i == 0 || c <= 0)
            return 0;

        if(cache[i][c] != 0)
            return cache[i][c];

        if(wt[i-1] > c) {
            cache[i][c] = memoization(v, wt, i-1, c);
            return cache[i][c];
        }


        cache[i][c] = Math.max(v[i-1] + memoization(v, wt, i-1, c-wt[i-1]), memoization(v, wt, i-1, c));

        return cache[i][c];
    }

    static int[][] dp;
    private static int bottomUp(int[] v, int[] wt, int c) {

        for(int i=1; i<=v.length; i++) {
            for(int j=1; j<=c; j++) {

                if(wt[i-1] > j)
                    dp[i][j] = dp[i-1][j];

                else
                    dp[i][j] = Math.max(v[i-1] + dp[i-1][j - wt[i-1]], dp[i-1][j]);

            }
        }

        return dp[v.length][c];
    }

}
