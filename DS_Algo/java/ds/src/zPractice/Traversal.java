package zPractice;

import java.util.Arrays;

public class Traversal {
    static int recursive(int[] arr, int n, int l) {
        if(n < 2)
            return l + n;

        if(arr[n-1] > arr[n-2]) {
            l = Math.max(recursive(arr, n - 1, l + 1), recursive(arr, n - 1, l));
            return l;
        }
        else {
            l = recursive(arr, n-1, l);
            return l;
        }
    }

    static int memoized(int[] arr, int n, int l, int[] t) {
        if(n < 2)
            return l + n;

        if(t[n-1] != -1)
            return t[n-1];

        if(arr[n-1] > arr[n-2]) {
            l = Math.max(memoized(arr, n - 1, l + 1, t), memoized(arr, n - 1, l, t));
            t[n-1] = l;
            return l;
        }
        else {
            l = memoized(arr, n-1, l, t);
            t[n-1] = l;
            return l;
        }
    }

    static int bottomUpDp(int[] arr) {
        if(arr.length == 0)
            return 0;

        int[] t = new int[arr.length];
        Arrays.fill(t, 1);

        int max = 1;
        for(int i=1; i<arr.length; i++) {
            if(arr[i] > arr[i-1] && arr[i] > max) {
                t[i] = 1 + max;
            }
            else if(arr[i] > arr[i-1]) {
                t[i] = 1 + t[i-1];
            }
            else {
                t[i] = 1;
            }
            max = Math.max(max, t[i]);
        }
        return t[arr.length-1];
    }

}
