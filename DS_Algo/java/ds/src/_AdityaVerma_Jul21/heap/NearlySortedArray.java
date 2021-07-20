package _AdityaVerma_Jul21.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 *https://www.youtube.com/watch?v=dYfM6J1y0mU&list=PL_z_8CaSLPWdtY9W22VjnPxG30CXNZpI9&index=4
 *
 * Given an array of n elements, where each element is at most k away from its target position,
 * devise an algorithm that sorts in O(n log k) time. For example, let us consider k is 2,
 * an element at index 7 in the sorted array, can be at indexes 5, 6, 7, 8, 9 in the given array.
 *
 * Example:
 * Input : arr[] = {6, 5, 3, 2, 8, 10, 9}
 * k = 3
 * Output : arr[] = {2, 3, 5, 6, 8, 9, 10}
 */
public class NearlySortedArray {

    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 2, 8, 10, 9};
        System.out.println(Arrays.toString(arr));
        int k = 3;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int curr = 0;
        for(int i=0; i<arr.length; i++) {
            pq.offer(arr[i]);
            if(pq.size() > k) {
                arr[curr++] = pq.poll();
            }
        }

        while(curr < arr.length) {
            arr[curr++] = pq.poll();
        }
        System.out.println(Arrays.toString(arr));
    }


}
