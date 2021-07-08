package dynamicProgramming.LCS;

public class a2_LongestCommonSubstring {

    public static void main(String[] args) {
        String x = "abcdxyz";
        String y = "xyzabcr";

        System.out.println("Recursive > " + recursive(x, y, x.length(), y.length(), 0));

        System.out.println("DP sol :: " + bottomUpDp(x, y));//this is giving correct ans
    }

    static int recursive(String x, String y, int n, int m, int max) {
        if(n == 0 || m == 0)
            return max;

        if(x.charAt(n-1) == y.charAt(m-1)) {
            // max++ wont work here, either do ++max or max+1
            max = recursive(x, y, n-1, m-1, ++max);
        }

        max = Math.max(max,
                Math.max(recursive(x, y, n - 1, m, 0),
                        recursive(x, y, n, m - 1, 0)));
        return max;

    }

    static int bottomUpDp(String x, String y) {
        int n = x.length();
        int m = y.length();
        int[][] t = new int[n+1][m+1];

        int max = 0;
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(x.charAt(i-1) == y.charAt(j-1))
                    t[i][j] = 1 + t[i-1][j-1];
                else
                    t[i][j] = Math.max(t[i][j-1], t[i-1][j]);
            }
        }
        return t[n][m];
    }
}
