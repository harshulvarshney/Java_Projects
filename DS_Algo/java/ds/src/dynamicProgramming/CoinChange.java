package dynamicProgramming;

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
public class CoinChange {

    public static void main(String[] args) {

    }

    public int coinChange(int[] coins, int amount) {
        double[][] dp = new double[coins.length+1][amount+1];

        for(int i=0; i<=coins.length; i++) {
            for(int j=0; j<=amount; j++) {
                if(j ==0)
                    dp[i][j] = 0d;
                else if(i == 0)
                    dp[i][j] = Double.POSITIVE_INFINITY;
                else if(j < coins[i-1])
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = Math.min(dp[i-1][j], 1+dp[i][j - coins[i-1]]);
            }
        }

        return dp[coins.length][amount] >= Double.POSITIVE_INFINITY ? -1 : (int)dp[coins.length][amount];
    }
}
