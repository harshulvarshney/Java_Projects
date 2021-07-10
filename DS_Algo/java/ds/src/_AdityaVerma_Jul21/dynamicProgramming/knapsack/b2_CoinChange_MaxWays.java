package _AdityaVerma_Jul21.dynamicProgramming.knapsack;

/**
 * Given a value N, if we want to make change for N cents,
 * and we have infinite supply of each of S = { S1, S2, .. , Sm} valued coins,
 * how many ways can we make the change? The order of coins doesn’t matter.
 *
 * For example, for N = 4 and S = {1,2,3},
 * solutions: {1,1,1,1},{1,1,2},{2,2},{1,3}
 * output should be 4.
 */
public class b2_CoinChange_MaxWays {

    public static void main(String[] args) {
        int[] den = {1, 2, 5};
        int target = 5;
        System.out.println("Max ways: " + findMaxWays(den, target));
    }

    static int findMaxWays(int[] den, int target) {
        int n = den.length;
        int[][] t = new int[n+1][target+1];

        for(int[] i: t) {
            i[0] = 1;
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=target; j++) {
                if(den[i-1] <= j) {
                    t[i][j] = t[i][j - den[i-1]] + t[i-1][j];
                } else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][target];
    }
}
