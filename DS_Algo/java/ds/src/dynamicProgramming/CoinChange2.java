package dynamicProgramming;

/**
 * https://leetcode.com/problems/coin-change-2/
 *
 * https://www.youtube.com/watch?v=ruMqWViJ2_U
 */
public class CoinChange2 {

    public static void main(String[] args) {
        int [] coins = {1,2,5};
        int t = 5;
        System.out.println(dp2(coins, t));
        System.out.println(effecientDp(coins, t));
    }

    private static int dp2(int[] coins, int t) {
        int n = coins.length;
        int[][] dp = new int[n+1][t+1];

        for(int i=0; i<dp.length; i++) {
            for(int j=0; j<dp[0].length; j++) {
                if(j == 0)
                    dp[i][j] = 1;
                else if(i == 0)
                    dp[i][j] = 0;
                else
                    dp[i][j] = (j-coins[i-1] >= 0) ? dp[i][j-coins[i-1]] + dp[i-1][j] : dp[i-1][j];
            }
        }

        return dp[n][t];
    }

    private static int dp(int[] coins, int t) {
        int[][] dp = new int[coins.length+1][t+1];
        // dp[i][j] = dp[i][j-coins[i]] + dp[i-1][j]

        for(int i=0; i<dp.length; i++)
            dp[i][0] = 1;

        for(int i=1; i<dp[0].length; i++)
            dp[0][i] = 0;

        for(int i=1; i<dp.length; i++) {
            for(int j=1; j<dp[0].length; j++) {
                if(j < coins[i-1]) {
                    dp[i][j] = dp[i-1][j];
                }
                else {
                    dp[i][j] = dp[i-1][j] + dp[i][j-coins[i-1]];
                }
            }
        }

        return dp[coins.length][t];
    }

    private static int effecientDp(int[] coins, int amount) {
        int[] prevRow = new int[amount+1];
        prevRow[0] = 1;
        int prev = 1;

        int resp = 0;
        for(int i=1; i<=coins.length; i++) {
            prev = 1;
            for(int j=1; j<=amount; j++) {
                if(j < coins[i-1]) {
                    resp = prevRow[j];
                }
                else {
                    resp = prevRow[j] + prev;
                    prevRow[j] = resp;
                    prev = prevRow[j - coins[i-1]];
                }
            }
        }
        return resp;
    }
}
