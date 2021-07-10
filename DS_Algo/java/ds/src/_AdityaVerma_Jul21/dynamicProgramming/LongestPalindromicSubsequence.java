package _AdityaVerma_Jul21.dynamicProgramming;

public class LongestPalindromicSubsequence {

    public static void main(String[] args) {
        String s = "cbbd";
        System.out.println(longestPalindromeSubseq(s));
    }

    public static int longestPalindromeSubseq(String s) {
        if(s == null)
            return 0;
        if(s.length() == 1)
            return 1;

        int n = s.length();
        char[] cArr = s.toCharArray();
        int[][] dp = new int[n][n];

        for(int i=n-1; i>=0; i--) {
            for(int j=i; j<n; j++) {
                if(i == j)
                    dp[i][j] = 1;
                else if(cArr[i] == cArr[j]) {
                    dp[i][j] = 1 + Math.max(dp[i+1][j], dp[i][j-1]);
                }
                else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }

        return dp[0][n-1];
    }
}
