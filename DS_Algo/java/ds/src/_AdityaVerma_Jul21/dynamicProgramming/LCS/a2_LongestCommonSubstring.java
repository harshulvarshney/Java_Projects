package _AdityaVerma_Jul21.dynamicProgramming.LCS;

public class a2_LongestCommonSubstring {

    public static void main(String[] args) {
        String x = "abaxx";
        String y = "xxaba";

        System.out.println("Recursive :: " + recursive(x, y, x.length(), y.length(), 0));

        System.out.println("bottomUpDp  :: " + bottomUpDp(x, y));//this is giving correct ans


        int[][] t = new int[x.length()+1][y.length()+1];
        /*for(int[] i: t) {
            Arrays.fill(i, -1);
        }*/
        //System.out.println("Memoized :: " + mwmoized(x, y, x.length(), y.length(), t));
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

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(x.charAt(i-1) == y.charAt(j-1))
                    t[i][j] = 1 + t[i-1][j-1];
                else
                    t[i][j] = 0;
            }
        }
        int max = 0;
        for(int i=0; i<t.length; i++) {
            for(int j=0; j<t[0].length; j++) {
                max = Math.max(max, t[i][j]);  // in case of substring, we may not get ans at t[n][m] because substring can be anywhere in the string
            }
        }
        return max;
    }

    static void printLCSubStr(String X, String Y, int m, int n)
    {
        // Create a table to store lengths of longest common
        // suffixes of substrings.   Note that t[i][j]
        // contains length of longest common suffix of X[0..i-1]
        // and Y[0..j-1]. The first row and first column entries
        // have no logical meaning, they are used only for
        // simplicity of program
        int[][] t = new int[m + 1][n + 1];

        // To store length of the longest common substring
        int len = 0;

        // To store the index of the cell which contains the
        // maximum value. This cell's index helps in building
        // up the longest common substring from right to left.
        int row = 0, col = 0;

        /* Following steps build t[m+1][n+1] in bottom
           up fashion. */
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    t[i][j] = 0;

                else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    t[i][j] = t[i - 1][j - 1] + 1;
                    if (len < t[i][j]) {
                        len = t[i][j];
                        row = i;
                        col = j;
                    }
                }
                else
                    t[i][j] = 0;
            }
        }

        // if true, then no common substring exists
        if (len == 0) {
            System.out.println("No Common Substring");
            return;
        }

        // allocate space for the longest common substring
        String resultStr = "";

        // traverse up diagonally form the (row, col) cell
        // until t[row][col] != 0
        while (t[row][col] != 0) {
            resultStr = X.charAt(row - 1) + resultStr; // or Y[col-1]
            --len;

            // move diagonally up to previous cell
            row--;
            col--;
        }

        // required longest common substring
        System.out.println(resultStr);
    }
}
