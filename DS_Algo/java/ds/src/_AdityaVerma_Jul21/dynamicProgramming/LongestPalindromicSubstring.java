package _AdityaVerma_Jul21.dynamicProgramming;

import java.util.Arrays;

/**
 * https://www.youtube.com/watch?v=UflHuQj6MVA
 *
 *https://leetcode.com/problems/longest-palindromic-substring/
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String s = "aaibcba";
        System.out.println("DP :: " + longestPalindrome(s));

        String rev = new StringBuilder(s).reverse().toString();
        System.out.println(recursive(s, rev, s.length(), s.length(), 0));

        int[][] t = new int[s.length()+1][s.length()+1];
        for(int[] i: t) {
            Arrays.fill(i, -1);
        }
        System.out.println("memoized :: " + memoized(s, rev, s.length(), s.length(), t));

        System.out.println(print(s, rev, t));




    }

    public static String longestPalindrome(String s) {
        if(s == null || s.length() < 2)
            return s;

        String resp = null;
        int n = s.length();
        char[] cArr = s.toCharArray();
        boolean[][] dp = new boolean[n][n];

        for(int i=n-1; i>=0; i--) {
            for(int j=i; j<n; j++) {
                dp[i][j] = cArr[i] == cArr[j] && (i == j || dp[i+1][j-1]);

                if(dp[i][j] && (resp == null || (j-i+1) > resp.length())) {
                    resp = s.substring(i, j+1);
                }

            }
        }

        return resp;
    }

    static int recursive(String s1, String s2, int n, int m, int max) {
        if(n == 0 || m == 0)
            return max;

        if(s1.charAt(n-1) == s2.charAt(m-1) && n != m) {
            max = recursive(s1, s2, n-1, m-1, ++max);
        }

        max = Math.max(max, Math.max(recursive(s1, s2, n-1, m, 0), recursive(s1, s2, n, m-1, 0)));

        return max;
    }

    static int memoized(String s1, String s2, int n, int m, int[][] t) {
        if(n == 0 || m == 0)
            return 0;

        if(t[n][m] != -1)
            return t[n][m];

        if(s1.charAt(n-1) == s2.charAt(m-1) && n != m) {
            t[n][m] = 1 + memoized(s1, s2, n-1, m-1, t);
        }
        else {
            t[n][m] = Math.max(memoized(s1, s2, n - 1, m, t), memoized(s1, s2, n, m - 1, t));
        }

        return t[n][m];

    }

    static String print(String s1, String s2, int[][] t) {
        int i = s1.length();
        int j = s1.length();

        StringBuilder sb = new StringBuilder();
        while(i > 0 && j > 0) {
            if(sb.length() == t[s1.length()][s1.length()])
                break;
            if(s1.charAt(i-1) == s2.charAt(j-1)) {
                sb.append(s1.charAt(i-1));
                i--;
                j--;
            }
            else if(t[i][j-1] > t[i-1][j])
                j--;
            else
                i--;
        }
        return sb.reverse().toString();
    }

}
