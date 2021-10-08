package zPractice;

import java.util.Arrays;

public class ArraySolution {

    public static void main(String[] args) {
        int[] arr = {3, 2, 1, -1, 4, 2};
        System.out.println(Arrays.toString(arr));
        quick(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    static void quick(int[] arr, int low, int high) {
        if(arr == null || arr.length == 0 || low > high)
            return;

        int i=low;
        int j=high;
        int p = (i + (j-i)/2);
        int mid = arr[p];
        while(i <= j) {
            while(arr[i] < mid)
                i++;
            while(arr[j] > mid)
                j--;

            if(i <= j) {
                //swap
                int t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
                i++;
                j--;
            }
        }

        quick(arr, low, j);
        quick(arr, i, high);
    }
}
