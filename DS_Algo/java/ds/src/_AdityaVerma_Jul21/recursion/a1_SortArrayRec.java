package _AdityaVerma_Jul21.recursion;


import java.util.Arrays;

/**
 *
 * To understand recursion, it is important to practice this problem.
 *
 * Problem Statement: give an array, sort is by using recursion
 *
 */
public class a1_SortArrayRec {

    public static void main(String[] args) {
        int[] arr = {1, 0, 5, 2};
        sort(arr, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    static void sort(int[] arr, int n) {
        if(n == 1)
            return;

        int x = arr[n-1];
        sort(arr, n-1);

        //place x at correct location
        int i = insert(arr, n-1, x);
        int l = n-1;
        while(l > i) {
            arr[l] = arr[l-1];
            l--;
        }
        arr[i] = x;
    }

    static int insert(int[] arr, int n, int x) {
        if(n == 0)
            return 0;
        if(arr[n-1] < x)
            return n;

        return insert(arr, n-1, x);
    }
}
