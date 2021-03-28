package dynamicProgramming;

/**
 * https://www.youtube.com/watch?v=UflHuQj6MVA
 *
 *https://leetcode.com/problems/longest-palindromic-substring/
 */
public class LongestPalindromicSubstring {

    public static void main(String[] args) {
        String s = "aaabcba";
        System.out.println(longestPalindrome(s));
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
}
