package _AdityaVerma_Jul21.dynamicProgramming.LCS.palindrome;

public class p1_LongestPalindromicSubsequence {

    public static void main(String[] args) {
        String x = "bbbab";
        String y = new StringBuilder(x).reverse().toString();

        int[][] t = new int[x.length()+1][x.length()+1];
        findLcs(x, y, t);
        System.out.println("LCS length :: " + t[x.length()][x.length()]);
        System.out.println("Longest Palindrome :: " + getLongestPalindromicSubsequence(x, y, t));
    }

    static String getLongestPalindromicSubsequence(String x, String y, int[][] t) {
        int i = x.length();
        int j = x.length();

        StringBuilder sb = new StringBuilder();
        while(i>0 && j>0) {
            if(x.charAt(i-1) == y.charAt(j-1)) {
                sb.append(y.charAt(j-1));
                i--;
                j--;
            }
            else if(t[i][j-1] > t[i-1][j]) {
                j--;
            }
            else {
                i--;
            }
        }
        return sb.toString();
    }

    static void findLcs(String x, String y, int[][] t) {
        int n = x.length();

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(x.charAt(i-1) == y.charAt(j-1))
                    t[i][j] = 1 + t[i-1][j-1];
                else
                    t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
            }
        }
    }
}
