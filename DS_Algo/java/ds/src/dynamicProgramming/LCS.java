package dynamicProgramming;

import java.util.Arrays;

/**
 * Longest Common Sub-sequence
 *
 * https://www.youtube.com/watch?v=DuikFLPt8WQ&list=PLSIpQf0NbcClDpWE58Y-oSJro_W3LO8Nb&index=3
 */
public class LCS {

    public static void main(String[] args) {
        String s1 = "JAVA";
        String s2 = "JOJOVA";

        // 1- find the recursive solution
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();
        System.out.println("recursive :: " + recursive(c1, c2, c1.length-1, c2.length-1));

        // 2- optimize recursive solution by memoization
        int[][] mem = new int[c1.length][c2.length];
        System.out.println("memoization :: " + memoization(c1, c2, c1.length-1, c2.length-1, mem));
        //System.out.println(Arrays.deepToString(mem));

        // 3- further optimize it using a table : pure DP
        int[][] dp = new int[c1.length+1][c2.length+1];
        findLcs(c1, c2, dp);
        System.out.println("DP :: " + dp[c1.length][c2.length]);
    }

    private static int recursive(char[] s1, char[] s2, int i, int j) {
        if(i < 0 || j < 0)
            return 0;

        if(s1[i] == s2[j])
            return 1 + recursive(s1, s2, i-1, j-1);

        return Math.max(recursive(s1, s2, i, j-1), recursive(s1, s2, i-1, j));
    }

    private static int memoization(char[] s1, char[] s2, int i, int j, int[][] mem) {
        if(i < 0 || j < 0)
            return 0;

        if(mem[i][j] != 0)
            return mem[i][j];

        if(s1[i] == s2[j]) {
            mem[i][j] = 1 + memoization(s1, s2, i-1, j-1, mem);
            return mem[i][j];
        }

        mem[i][j] = Math.max(memoization(s1, s2, i, j-1, mem), memoization(s1, s2, i-1, j, mem));
        return mem[i][j];
    }

    private static void findLcs(char[] s1, char[] s2, int[][] dp) {

        for(int i=0; i<=s1.length; i++) {
            for(int j=0 ;j<=s2.length; j++) {
                if(i == 0 || j == 0)
                    dp[i][j] = 0;
                else if(s1[i-1] == s2[j-1]) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
                }
            }
        }
    }
}
