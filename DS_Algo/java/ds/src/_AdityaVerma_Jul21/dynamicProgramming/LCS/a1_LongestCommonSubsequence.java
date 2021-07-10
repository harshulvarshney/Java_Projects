package _AdityaVerma_Jul21.dynamicProgramming.LCS;

import java.util.Arrays;

public class a1_LongestCommonSubsequence {

    public static void main(String[] args) {
        char[] x = {'h', 'e', 'a', 'p'};
        char[] y = {'p', 'e', 'a'};

        System.out.println("recursive :: " + recursive(x, y, x.length, y.length));

        int[][] t = new int[x.length+1][y.length+1];
        for(int[] i: t)
            Arrays.fill(i, -1);
        System.out.println("Memoization :: " + recursiveWithMem(x, y, x.length, y.length, t));

        System.out.println("DP sol :: " + bottomUpDp(x, y));
    }

    static int recursive(char[] x, char[] y, int n, int m) {
        //1- identify the base condition
        if(n == 0 || m == 0)
            return 0;

        //2- make recursive function using choice diagram
        if(x[n-1] == y[m-1])
            return 1 + recursive(x, y, n-1, m-1);
        else
            return Math.max(recursive(x, y, n, m-1), recursive(x, y, n-1, m));
    }

    static int recursiveWithMem(char[] x, char[] y, int n, int m, int[][] t) {
        if(n == 0 || m == 0)
            return 0;

        if(t[n][m] != -1)
            return t[n][m];

        if(x[n-1] == y[m-1]) {
            t[n][m] = 1 + recursive(x, y, n - 1, m - 1);
            return t[n][m];
        }
        else {
            t[n][m] = Math.max(recursive(x, y, n, m - 1), recursive(x, y, n - 1, m));
            return t[n][m];
        }
    }

    static int bottomUpDp(char[] x, char[] y) {
        int n = x.length;
        int m = y.length;
        int[][] t = new int[n+1][m+1];

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(x[i-1] == y[j-1])
                    t[i][j] = 1 + t[i-1][j-1];
                else
                    t[i][j] = Math.max(t[i-1][j], t[i][j-1]);
            }
        }
        return t[n][m];
    }
}
