package _AdityaVerma_Jul21.dynamicProgramming;

import java.util.Arrays;

public class MaxSquareInMatrix {

    public static void main(String[] args) {
        int[][] m = {{0, 1, 0, 1}, {1, 1, 1, 1}, {1, 1, 1, 1}};
        System.out.println(Arrays.deepToString(m));
        System.out.println(maxSquareRec(m, m.length-1, m[0].length-1));


        int[][] t = new int[m.length][m[0].length];
        for(int i=0; i<m.length; i++) {
            for(int j=0; j<m[0].length; j++) {
                t[i][j] = -1;
                if(i == 0 || j == 0)
                    t[i][j] = m[i][j];
            }
        }
        System.out.println(maxSquareMemoized(m, m.length-1, m[0].length-1, t));

        System.out.println(bottomUpDp(m));
    }

    static int maxSquareRec(int[][] m, int i, int j) {
        if(i == 0 || j == 0)
            return m[i][j];

        if(m[i][j] == 1)
            return 1 + Math.min(maxSquareRec(m, i-1, j-1), Math.min(maxSquareRec(m, i, j-1), maxSquareRec(m, i-1, j)));
        else
            return 0;
    }

    static int maxSquareMemoized(int[][] m, int i, int j, int[][] t) {
        if(i == 0 || j == 0)
            return m[i][j];

        if(t[i][j] != -1)
            return t[i][j];

        if(m[i][j] == 1) {
            t[i][j] = 1 + Math.min(maxSquareMemoized(m, i - 1, j - 1, t),
                            Math.min(maxSquareMemoized(m, i, j - 1, t), maxSquareMemoized(m, i-1, j, t)));
            return t[i][j];
        }
        else {
            t[i][j] = 0;
            return 0;
        }
    }

    static int bottomUpDp(int[][] m) {
        int[][] t = new int[m.length][m[0].length];
        for(int i=0; i<m.length; i++) {
            for(int j=0; j<m[0].length; j++) {
                t[i][j] = -1;
                if(i == 0 || j == 0)
                    t[i][j] = m[i][j];
            }
        }

        for(int i=1; i<m.length; i++) {
            for (int j = 1; j < m[0].length; j++) {
                if(m[i][j] == 1)
                    t[i][j] = 1 + Math.min(t[i-1][j-1], Math.min(t[i][j-1], t[i-1][j]));
                else
                    t[i][j] = 0;
            }
        }
        return t[m.length-1][m[0].length-1];
    }
}
