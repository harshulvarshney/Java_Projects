package _AdityaVerma_Jul21.stack;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

/**
 * Given an array, print the Next Greater Element (NGE) for every element. The Next greater Element for an
 * element x is the first greater element on the right side of x in the array. Elements for which no greater
 * element exist, consider the next greater element as -1.
 *
 * For the input array [4, 5, 2, 25], the next greater elements for each element are as follows.
 * Element       NGE
 *    4      -->   5
 *    5      -->   25
 *    2      -->   25
 *    25     -->   -1
 */
public class NextLargestElement {

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 25};
        System.out.println(Arrays.toString(solve(arr)));
    }

    // hint: brute force approach of this question involve 2 loops:
    // outer loop will be: i=0; i<n; i++ and
    // inner loop will be: j=i+1; j<n; j++
    // in this solution, j depends on i ==> we can use stack here

    static int[] solve(int[] arr) {
        if(arr == null)
            return null;
        int[] resp = new int[arr.length];

        Deque<Integer> s = new LinkedList<>();
        for(int i=arr.length-1; i>=0; i--) {
            while(!s.isEmpty() && s.peek() < arr[i]) {
                s.pop();
            }
            resp[i] = s.isEmpty() ? -1 : s.peek();
            s.push(arr[i]);
        }
        return resp;
    }
}
