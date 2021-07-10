package _AdityaVerma_Jul21.dynamicProgramming;

/**
 * Given an integer array, answer the query: find the sum of elements between indices i and j (inclusive)
 * (there can be n number of queries)
 */
public class RangeSumQuery_PrefixSum {

    public static void main(String[] args) {
        int[] input = {1, -2, 3, 10, -8, 0, 1};
        preprocess(input);
        System.out.println("find(2, 4) :: " + findSumInRange(0, 4));
        System.out.println("find(3, 5) :: " + findSumInRange(3, 5));
    }

    private static int findSumInRange(int i, int j) {
        if(i == 0)
            return sum[j];
        return sum[j] - sum[i-1];
    }

    static int[] sum;
    private static void preprocess(int[] x) {
        sum = new int[x.length];
        sum[0] = x[0];

        for(int i=1; i<x.length; i++) {
            sum[i] = x[i] + sum[i-1];
        }
    }
}
