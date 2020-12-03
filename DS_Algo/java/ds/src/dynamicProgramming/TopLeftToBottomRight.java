package dynamicProgramming;

/**
 * The problem is to count all the possible paths from top left to bottom right of a mXn matrix
 * with the constraints that from each cell you can either move only to right or down
 *
 * ref: https://www.udemy.com/course/dynamic-programming-i/learn/lecture/10878968#questions
 * <img src="./dynProg-1.png">
 *
 * Java Solution: https://www.geeksforgeeks.org/count-possible-paths-top-left-bottom-right-nxm-matrix/
 */
public class TopLeftToBottomRight {

    public static void main(String[] args) {
        System.out.println("Possible ways =" + dynamic(3, 3));
    }

    private static int dynamic(int m, int n) {
        int[][] resp = new int[m][n];

        for(int i=0; i<m; i++) resp[i][n-1] = 1;
        for(int i=0; i<n; i++) resp[m-1][i] = 1;

        for(int i = m-2; i>=0; i--) {
            for(int j = n-2; j>=0; j--) {
                resp[i][j] = resp[i][j+1] + resp[i+1][j];
            }
        }

        return resp[0][0];
    }
}
