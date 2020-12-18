package dynamicProgramming;

import java.util.Arrays;

/**
 * https://www.udemy.com/course/graph-theory-algorithms/learn/lecture/20329239#overview
 * https://cp-algorithms.com/data_structures/sparse-table.html
 *
 * Sparse Table is a DS that can answer range min/max queries in O(1) time
 * it can also answer sum/product range queries in O(log n) time
 * the input array must be immutable.
 *
 * This DS works by pre-computing a 2D array and store answers for some ranges into it
 * this is like breaking the problem into smaller sections and storing the results -- dynamic programming
 *
 * To compute the 2D array:
 *      1- create an array of size: int[][] dp = [1 + floor(log n)][n]
 *      2- fill first row with input array
 *      3- fill rest of the rows with formula: dp[i][j] = func(dp[i-1][j], dp[i-1][j+pow(2, i-1)]  -- where func could be min/max
 *
 * To answer range queries:
 *      1- calculate p = floor(log n) -- this will be the row in which we will hv our answer
 *      2- calculate k = pow(2, p)
 *      3- return func( dp[p-1][l], dp[p-1][r-k+1])                                                -- where func could be min/max
 */
public class SparseTable {

    static int[][] dp;
    public static void main(String[] args) {
        int[] arr = {4,2,3,7,1,5,3,3,9,6,7,-1,4};
        int l = 3; int r = 5;
        prepareMinSparseTable(arr);
        System.out.println(Arrays.deepToString(dp));
        System.out.println("Min in range: " + findMinInRange(arr, l, r));
    }

    private static int findSumofRange(int[] arr, int l, int r) {
        //better use prefix sum array instead of Sparse Table for sum/product queries to get better time complexity
        return 0;
    }

    private static int findMinInRange(int[] arr, int l, int r) {
        int p = (int) Math.log(arr.length);
        int k = 1 << p;
        return Math.min(dp[p-1][l], dp[p-1][r-k+1]);
    }

    private static void prepareMinSparseTable(int[] arr) {
        int p = (int) (Math.log(arr.length)/Math.log(2));
        dp = new int[p+1][arr.length];

        for(int i=0; i<arr.length; i++) dp[0][i] = arr[i];

        for(int i=1; i<=p; i++) {
            for(int j=0; j+(1<<i)<=arr.length; j++) {
                dp[i][j] = Math.min( dp[i-1][j], dp[i-1][j + (1 << (i-1))]);
            }
        }

    }
}
