package dynamicProgramming.knapsack;

/**
 * Given a rod of length n inches and an array of prices that includes prices of
 * all pieces of size smaller than n. Determine the maximum value obtainable by cutting
 * up the rod and selling the pieces.
 *
 * length   | 1   2   3   4   5   6   7   8
 * --------------------------------------------
 * price    | 1   5   8   9  10  17  17  20
 * Sol: 22
 */
public class b1_RodCutting {

    public static void main(String[] args) {
        int[] prices = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println("MAx profit: " + dp(prices));
    }

    static int dp(int[] prices) {
        int n = prices.length;

        int[] cutLength = new int[n];
        for(int i=0; i<n; i++)
            cutLength[i] = i+1;

        int[][] t = new int[n+1][n+1];

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(cutLength[i-1] <= j) {
                    t[i][j] = Math.max(prices[i-1] + t[i][j - cutLength[i-1]],
                            t[i-1][j]);
                }
                else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][n];
    }
}
