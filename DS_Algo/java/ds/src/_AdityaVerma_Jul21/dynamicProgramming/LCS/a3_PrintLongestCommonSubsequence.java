package _AdityaVerma_Jul21.dynamicProgramming.LCS;

import java.util.Arrays;

/**
 * https://www.youtube.com/watch?v=x5hQvnUcjiM&list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go&index=23
 *
 * To solve this:
 *  1- prepare the recursive solution
 *  2- prepare the table with bpttom-up approach
 *  3- use the table to identify common characters
 */
public class a3_PrintLongestCommonSubsequence {

    public static void main(String[] args) {
        String x = "abcdxyz";
        String y = "xyzabcd";

        System.out.println("Recursive :: " + recursive(x, y, x.length(), y.length()));

        int[][] t = new int[x.length()+1][y.length()+1];
        prepareTableForLCS(x, y, t);
        System.out.println("bottomUpDp :: " + t[x.length()][y.length()]);

        print(x, y, t);
    }

    // direct solution to pring lcs *******************
    private String longestCommonSubSeq(String str1, String str2) {
        String[][] dp = new String[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i < dp.length; i++)
            Arrays.fill(dp[i], "");
        for (int i = 1; i <= str1.length(); i++)
            for (int j = 1; j <= str2.length(); j++)
                if (str1.charAt(i-1) == str2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1] + str1.charAt(i-1);
                else
                    dp[i][j] = dp[i-1][j].length()>dp[i][j-1].length() ?  dp[i-1][j] : dp[i][j-1];
        return dp[str1.length()][str2.length()];
    }

    static int recursive(String x, String y, int n, int m) {
        if(n == 0 || m == 0)
            return 0;

        if(x.charAt(n-1) == y.charAt(m-1))
            return 1 + recursive(x, y, n-1, m-1);
        else
            return Math.max(recursive(x, y, n-1, m), recursive(x, y, n, m-1));
    }

    static void prepareTableForLCS(String x, String y, int[][] t) {
        for(int i=1; i<t.length; i++) {
            for(int j=1; j<t[0].length; j++) {
                if(x.charAt(i-1) == y.charAt(j-1))
                    t[i][j] = 1 + t[i-1][j-1];
                else
                    t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
            }
        }
    }

    static void print(String x, String y, int[][] t) {

        StringBuffer sb = new StringBuffer();
        int i=t.length-1;
        int j=t[0].length-1;
        while(i>0 && j>0) {
                if(x.charAt(i-1) == y.charAt(j-1)) {
                    sb.append(x.charAt(i-1));
                    i--;
                    j--;
                } else if(t[i][j-1] > t[i-1][j]){
                    j--;
                } else if(t[i][j-1] < t[i-1][j]){
                    i--;
                } else
                    break;
        }
        sb = sb.reverse();
        System.out.println(sb.toString());
    }
}
