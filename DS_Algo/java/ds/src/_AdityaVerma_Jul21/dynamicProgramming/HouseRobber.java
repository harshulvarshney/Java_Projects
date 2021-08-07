package _AdityaVerma_Jul21.dynamicProgramming;

import java.util.Arrays;

/**
 * https://www.youtube.com/watch?v=ge_Fv2ZQAaE
 *
 * find the max um in an array s.t. no 2 elements are adjacent
 */
public class HouseRobber {

    //static int[] cache;
    public static void main(String[] args) {
        int[] inp = {2,7,9,3,1};
        //cache = new int[inp.length];
        System.out.println(maxCashRec(inp, inp.length, 0));


        int[] t = new int[inp.length+1];
        Arrays.fill(t, -1);
        System.out.println(maxCashMem(inp, inp.length, 0, t));



        // house robber-r: https://leetcode.com/problems/house-robber-ii/solution/
    }

    static int maxCashRec(int[] arr, int n, int max) {
        if(n <= 0)
            return max;

        return Math.max(maxCashRec(arr, n-2, max+arr[n-1]), maxCashRec(arr, n-1, max));
    }

    static int maxCashMem(int[] arr, int n, int max, int[] t) {
        if(n <= 0)
            return max;

        if(t[n] != -1)
            return t[n];

        return Math.max(maxCashMem(arr, n-2, max+arr[n-1], t), maxCashMem(arr, n-1, max, t));
    }

    private static int findMaxEffecient(int[] inp) {
        //int[] dp = new int[inp.length];
        int prev2 = inp[0];
        int prev1 = Math.max(inp[0], inp[1]);

        int resp = 0;
        for (int i = 2; i < inp.length; i++) {
            resp = Math.max(inp[i] + prev2, prev1);
            prev2 = prev1;
            prev1 = resp;
        }

        return resp;
    }
}

