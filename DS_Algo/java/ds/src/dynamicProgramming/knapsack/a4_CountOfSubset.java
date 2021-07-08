package dynamicProgramming.knapsack;

import java.util.Arrays;

/**
 * https://www.youtube.com/watch?v=F7wqWbqYn9g&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=9
 * find the number of subsets with a sum equal to X.
 *
 * Input: arr[] = {1, 2, 3, 3}, X = 6
 * Output: 3
 * All the possible subsets are {1, 2, 3},
 * {1, 2, 3} and {3, 3}
 *
 *
 * Input: arr[] = {1, 1, 1, 1}, X = 1
 * Output: 4
 */
public class a4_CountOfSubset {

    public static void main(String[] args) {
        int[] arr = {1, 1, 1, 1};
        int n = arr.length;
        int sum = 2;

        System.out.println("recursive sol :: " + recursive(arr, sum, n));

        int[][] t = new int[n+1][sum+1];
        for(int[] i: t) {
            Arrays.fill(i, -1);
        }
        System.out.println("Memoized sol  :: " + recursiveWithMem(arr, sum, n, t));

        System.out.println("top-doen dp   :: " + dp(arr, sum));
    }

    static int recursive(int[] arr, int sum, int n) {
        if(n == 0 && sum == 0)
            return 1;
        if(sum == 0)
            return 1;
        if(n == 0 && sum > 0)
            return 0;

        if(arr[n-1] <= sum) {
            return recursive(arr, sum-arr[n-1], n-1) + recursive(arr, sum, n-1);
        }
        else {
            return recursive(arr, sum, n-1);
        }
    }

    static int recursiveWithMem(int[] arr, int sum, int n, int[][] t) {
        if(n == 0 && sum == 0)
            return 1;
        if(sum == 0)
            return 1;
        if(n == 0 && sum > 0)
            return 0;

        if(t[n][sum] != -1)
            return t[n][sum];

        if(arr[n-1] <= sum) {
            t[n][sum] = recursiveWithMem(arr, sum-arr[n-1], n-1, t)
                    + recursiveWithMem(arr, sum, n-1, t);
            return t[n][sum];
        }
        else {
            t[n][sum] = recursiveWithMem(arr, sum, n-1, t);
            return t[n][sum];
        }
    }

    //iterative solution with table
    static int dp(int[] arr, int sum) {
        int n = arr.length;
        int[][] t = new int[n+1][sum+1];

        for(int[] i : t) {
            i[0] = 1;
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=sum; j++) {
                if(arr[i-1] <= j) {
                    t[i][j] = t[i-1][j - arr[i-1]] + t[i-1][j];
                }
                else {
                    t[i][j] = t[i-1][j];
                }
            }
        }
        return t[n][sum];
    }
}
