package dynamicProgramming;

import java.util.Arrays;

/**
 * We have an array of integers and a set of range queries. For every query, we need to find product of elements in the given range.
 *
 * Input : arr[] = {5, 10, 2, 0, 25}
 *         queries[] = {(0, 2), (1, 2), (1, 4)}
 *         Output : 100, 20, 0
 *
 * https://www.geeksforgeeks.org/range-product-queries-in-an-array/
 * Algo:
 *      the product of elements between i and j will be:
 *          product (0, j) / product (0, i-1) ; given that there is no 0 between i and j
 *          0 ; if there is a 0 between i and j
 */
public class RangeProductQuery {

    public static void main(String[] args) {
        int[] inp = {5, 10, 2, 0, 25};
        preprocess(inp);
        System.out.println("(0, 2) :: " + productInRange(0, 2));
        System.out.println("(1, 2) :: " + productInRange(1, 2));
        System.out.println("(1, 4) :: " + productInRange(1, 4));
    }

    private static long productInRange(int i, int j) {
        if(countOfZeros[j] - countOfZeros[i] > 0)
            return 0;
        if(i == 0)
            return product[j];
        return product[j] / product[i-1];
    }

    static long[] product;
    static int[] countOfZeros;
    private static void preprocess(int[] inp) {
        product = new long[inp.length];
        countOfZeros = new int[inp.length];

        int count = 0;
        long prod = 1;
        for(int i=0; i< inp.length; i++) {
            if(inp[i] == 0) {
                count++;
            } else {
                prod = prod * inp[i];
            }

            product[i] = prod;
            countOfZeros[i] = count;
        }
        System.out.println(Arrays.toString(product));
    }
}
