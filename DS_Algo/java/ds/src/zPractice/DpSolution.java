package zPractice;

import java.util.*;

public class DpSolution {


    public static void main(String[] args) {
        int n = 2;

        int[] t = new int[n+1];
        Arrays.fill(t, -1);
        System.out.println(maxProduct(n, n, t));
    }

    static int maxProduct(int orig, int n, int[] t) {
        if(n <= 1)
            return 1;

        if(t[n] != -1)
            return t[n];

        int max = Integer.MIN_VALUE;
        for(int i=1; i<=n/2; i++) {
            max = Math.max(max, i*maxProduct(orig, n-i, t));
        }
        t[n] = n == orig ? max : Math.max(n, max);
        return t[n];
    }
}
